package ar.com.syntagma.esphora.conector.services;

/**
 * keystoreService
 * 
 * @author Syntagma SA/ Sebastian Bromberg
 * @see http://www.syntagma.com.ar
 * 
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import ar.com.syntagma.esphora.conector.exceptions.ConectorException;

@Name("keystoreService")
@Scope(ScopeType.EVENT)
@AutoCreate
public class KeystoreService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7518663971074215200L;
	@Logger
	private Log log;

	public KeyStore getKeyStore(String jksfile, String jkspwd)
			throws ConectorException {

		//
		// Manage Keys & Certificates Base64.encode (loginTicketRequestXmlCms)
		//
		KeyStore ks = null;
		try {
			// ks = KeyStore.getInstance("jks");
			ks = KeyStore.getInstance(KeyStore.getDefaultType());
		} catch (KeyStoreException e4) {
			throw new ConectorException(99999,
					"Excepcion al instanciar el certificado", e4);
		}

		// InputStream p12stream =
		// ResourceLoader.instance().getResourceAsStream("/"+p12file);
		// //InputStream.class.getResourceAsStream(p12file);
		InputStream jksStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(jksfile);
		// System.out.println("Certificado Leido!: "+p12file);
		System.out.println("KetStore Leido!!: " + jksfile);

		try {
			// ks.load(p12stream, p12pass.toCharArray());
			ks.load(jksStream, jkspwd.toCharArray());
			System.out.println("Certificado Cargado! " + ks.getProvider());
		} catch (NoSuchAlgorithmException e) {
			throw new ConectorException(99999,
					"No se puede interpretar el algoritmo de encriptacion", e);
		} catch (CertificateException e) {
			throw new ConectorException(99999,
					"No se puede leer el certificado .'12", e);
		} catch (IOException e) {
			throw new ConectorException(99999,
					"Error de I/O al cargar el archivo de certificados", e);
		}
		try {
			System.out.println("Certificado Cargado! " + ks.size() + "-"
					+ ks.getType() + "-" + ks.toString());
		} catch (KeyStoreException e4) {
			throw new ConectorException(99999,
					"No se puede leer el certificado .p12", e4);
		}
		return ks;
	}

	public List<X509Certificate> getListaCertificados(KeyStore ks,
			String validador) throws ConectorException {
		List<X509Certificate> lista = new ArrayList<X509Certificate>();
		log.debug("Funcion de lista");
		try {
			if (ks.aliases().hasMoreElements()) {
				log.debug("Has keys!");
				Enumeration<String> aliases = ks.aliases();
				String alias;
				while (aliases.hasMoreElements()) {
					alias = (String) aliases.nextElement();
					X509Certificate certificado = (X509Certificate) ks
							.getCertificate(alias);

					if (certificado == null) {
						log.info("No key found for alias: " + alias);
					} else {
						if (!certificadoRelevante(certificado, validador))
							continue;

						log.debug("Alias:" + alias + " Expiracion: "
								+ certificado.getNotAfter());

						lista.add(certificado);
					}
				}
			} else {
				log.info("No keys!");
			}

		} catch (KeyStoreException e) {
			e.printStackTrace();
			throw new ConectorException(-9, "Excepcion de KeyStore", e);
		} catch (Exception e1) {
			throw new ConectorException(-9, "Excepcion no capturada", e1);
		}
		log.debug("Fin de Funcion de lista");
		return lista;
	}

	private boolean certificadoRelevante(X509Certificate certificado,
			String validador) {
		// CAMPO:REGEX
		String[] camposValidador = validador.split(":");

		String[] camposCertificado = certificado.getSubjectDN().getName()
				.split(",");

		log.debug("validando si " + certificado.getSubjectDN().getName()
				+ " es relevante con la regex " + validador);

		for (String campo : camposCertificado) {
			// Ej: CN=afip.gov.ar
			String[] registro = campo.split("=");
			if (registro[0].trim().equals(camposValidador[0].trim())) {
				return registro[1].trim().matches(camposValidador[1].trim());
			}
		}
		return false;
	}

}
