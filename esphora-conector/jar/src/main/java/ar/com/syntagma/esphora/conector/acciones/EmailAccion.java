package ar.com.syntagma.esphora.conector.acciones;

/**
 * EmailAction, engloba el comportamiento relacionado al envio de Email.
 * 
 * @author Syntagma SA/ Sebastian Bromberg
 * @see http://www.syntagma.com.ar
 * 
 */

import java.io.Serializable;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.faces.context.FacesContext;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.async.Asynchronous;

import org.jboss.seam.international.StatusMessages;
import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.log.Log;

import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.PropiedadesFactory;
import ar.com.syntagma.esphora.conector.services.CertificadoService;
import ar.com.syntagma.esphora.conector.servicios.ServicioEmail;

@AutoCreate
@Name("emailAccion")
@Scope(ScopeType.EVENT)
public class EmailAccion implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -893441293845460564L;

	@In
	private ServicioEmail servicioEmail;

	@In
	private StatusMessages statusMessages;

	@In
	private CertificadoService certificadoService;

	@Logger
	private Log log;

	@In(value = "#{facesContext}", required = false)
	FacesContext facesContext;

	public void enviarPrueba() {
		servicioEmail.send("conector", "Sebastián Bromberg",
				"Sebastian.Bromberg@Syntagma.com.ar",
				new ArrayList<X509Certificate>(), "prueba");
		statusMessages.addFromResourceBundle(Severity.INFO, "info.prueba");
	}

	public void ping() {
		log.info("ping!");
	}

	private Date fecha = new Date();

	@Asynchronous
	public String enviarSync() throws ConectorException {

		log.debug("Obteniendo certificados ...");

		List<X509Certificate> listaEmpresas = certificadoService
				.getCertificadosEmpresas();
		List<X509Certificate> listaServicioAfip = certificadoService
				.getCertificadosServicioAfip();

		log.debug("enviando mail");

		Properties conector = PropiedadesFactory.getArchivoConector();

		if (!listaEmpresas.isEmpty()) {
			servicioEmail.send(
					"conector",
					conector.getProperty("administrador.nombre"),
					conector.getProperty("administrador.email"),
					listaEmpresas,
					"Certificados de Empresas por Expirar - "
							+ conector.getProperty("ambiente"));
		}

		if (!listaServicioAfip.isEmpty()) {
			servicioEmail.send(
					"conector",
					conector.getProperty("administrador.nombre"),
					conector.getProperty("administrador.email"),
					listaServicioAfip,
					"Certificados de Conexion a AFIP por Expirar - "
							+ conector.getProperty("ambiente"));
		}

		// servicioEmail.send("conector", "Diego.Balseiro",
		// "Diego.Balseiro@Syntagma.com.ar");
		// log.debug("email enviado ...");

		return "SUCCESS";
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}
}
