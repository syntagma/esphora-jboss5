package ar.com.syntagma.esphora.conector.acciones;

/**
 * EmailAction, engloba el comportamiento relacionado al envio de Email.
 * 
 * @author Syntagma SA/ Sebastian Bromberg
 * @see http://www.syntagma.com.ar
 * 
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Properties;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x509.X509CertificateStructure;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.X509CertificateObject;
import org.bouncycastle.openssl.PEMReader;
import org.bouncycastle.openssl.PasswordFinder;
import org.bouncycastle.util.encoders.Base64;
import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;

import org.jboss.seam.log.Log;

import ar.com.syntagma.esphora.conector.dominio.Compania;
import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.PropiedadesFactory;
import ar.com.syntagma.esphora.conector.services.KeystoreService;

@AutoCreate
@Name("companiaAccion")
@Scope(ScopeType.EVENT)
public class CompaniaAccion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -893441293845460564L;

	@In
	private KeystoreService keystoreService;

	@Logger
	private Log log;

	public String adherirCompania(Compania compania, String crt, String key)
			throws ConectorException {
		log.debug("Iniciando adhesion de compania");
		Properties conector = PropiedadesFactory.getArchivoConector();

		String jksfile;
		String alias = String.valueOf(compania.getCuil());

		String jkspwd = conector.getProperty("jkspwd");
		Ambiente ambiente = getAmbiente(conector);

		if (ambiente == Ambiente.PRODUCCION) {
			jksfile = "prod/" + conector.getProperty("jksfile");
		} else {
			jksfile = "test/" + conector.getProperty("jksfile");
		}

		log.debug("Abriendo el KeyStore de Empresas");
		KeyStore ks = keystoreService.getKeyStore(jksfile, jkspwd);

		log.debug("Chequeando que no exista el Alias previamente");
		try {
			if (ks.containsAlias(alias)) {
				return "Error - Ya existe un certificado para esta compania";
			}
		} catch (KeyStoreException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		log.debug("Generando un pkcs12 de los parametros recibidos");
		
		log.debug("crt: " + crt);
		

		Reader reader = new StringReader(crt);

		PEMReader pemReader = new PEMReader(reader);
		Certificate c[] = null;
		PrivateKey pk = getPrivateKey(key);
		try {
			Security.addProvider(new BouncyCastleProvider());
			c[0] = (X509Certificate) pemReader.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("Certificado Generado, pasando a grabar en el KeyStore");

		try {
			ks.setKeyEntry(alias, pk, jkspwd.toCharArray(),c);
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			ks.store(new FileOutputStream(jksfile), jkspwd.toCharArray());
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.debug("Actualizada " + jksfile);
		return "Ok";
	}

	private Ambiente getAmbiente(Properties conector) throws ConectorException {
		String a = conector.getProperty("ambiente");

		if (a.equals("test")) {
			return Ambiente.TEST;
		}
		if (a.equals("produccion")) {
			return Ambiente.PRODUCCION;
		} else {
			return Ambiente.DESARROLLO;
		}

	}
	
	private  PrivateKey getPrivateKey (String key) {

        // Remove the first and last lines

        String privKeyPEM = key.replace("-----BEGIN RSA PRIVATE KEY-----\n", "");
        privKeyPEM = privKeyPEM.replace("-----END RSA PRIVATE KEY-----", "");
        log.debug(privKeyPEM);

        // Base64 decode the data

        byte [] encoded = Base64.decode(privKeyPEM);

        // PKCS8 decode the encoded RSA private key

        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(encoded);
        KeyFactory kf = null;
		try {
			kf = KeyFactory.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        PrivateKey privKey = null;
		try {
			privKey = kf.generatePrivate(keySpec);
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        // Display the results

        log.debug(privKey);
        return privKey;
    }

}
