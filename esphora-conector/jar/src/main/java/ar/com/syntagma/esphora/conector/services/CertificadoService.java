package ar.com.syntagma.esphora.conector.services;

/**
 * EmailFactory, se agrupan los factories de Seam para toda la aplicacion.
 * 
 * @author Syntagma SA/ Sebastian Bromberg
 * @see http://www.syntagma.com.ar
 * 
 */

import java.io.Serializable;
import java.security.KeyStore;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.log.Log;

import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.PropiedadesFactory;
import ar.com.syntagma.esphora.conector.helpers.ExpiracionHelper;

@Name("certificadoService")
@Scope(ScopeType.EVENT)
@AutoCreate
public class CertificadoService implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -4044117987819561116L;

    @In
    private KeystoreService keystoreService;

    @In
    private ExpiracionHelper expiracionHelper;

    @Logger
    private Log log;

    public List<X509Certificate> getCertificadosEmpresas() throws ConectorException {
		Properties conector = PropiedadesFactory.getArchivoConector();

		String jksfile;

		String jkspwd = conector.getProperty("jkspwd");
		Ambiente ambiente = getAmbiente(conector);

		if (ambiente == Ambiente.PRODUCCION) {
			jksfile = "prod/" + conector.getProperty("jksfile");
		} else {
			jksfile = "test/" + conector.getProperty("jksfile");
		}

	return getCertificados(jksfile, jkspwd, conector.getProperty("validador.empresas"));
    }

    public List<X509Certificate> getCertificadosServicioAfip() throws ConectorException {
	Properties conector = PropiedadesFactory.getArchivoConector();

	String jksfile = conector.getProperty("servicio.jksfile");
	String jkspwd = conector.getProperty("servicio.jkspwd");

	return getCertificados(jksfile, jkspwd, conector.getProperty("validador.servicio.afip"));

    }

    /**
     * Metodo que devuelve la lista de contactos para enviar los Emails de
     * notificacion.
     * 
     * @param validador
     * 
     * @return Lista de contactos disponibles para el envio de mail.
     * @throws ConectorException
     */
    public List<X509Certificate> getCertificados(String jksFile, String jksPwd, String validador) throws ConectorException {
	log.debug("Obteniendo certificados");
	KeyStore ks = keystoreService.getKeyStore(jksFile, jksPwd);
	log.debug("CErtificados obtenidos");
	List<X509Certificate> lista = keystoreService.getListaCertificados(ks, validador);
	log.debug("Lista completa");

	List<X509Certificate> resultado = new ArrayList<X509Certificate>();

	for (X509Certificate certificado : lista) {
	    if (!expiracionHelper.certificadoValido(certificado)) {
		log.debug("CERTIFICADO VENCIDO" + certificado.getSubjectDN().getName());
		resultado.add(certificado);
	    }

	}

	return resultado;
    }

    private Ambiente getAmbiente(Properties conector) throws ConectorException {
	String a = conector.getProperty("ambiente");

	if (a.equals("test")) {
	    return Ambiente.TEST;
	}
	if (a.equals("produccion")) {
	    return Ambiente.PRODUCCION;
	}
	else {
	    return Ambiente.DESARROLLO;
	}

    }

}
