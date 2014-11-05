package ar.com.syntagma.esphora.conector.servicios;

/**
 * ServicioEmail
 * 
 * @author Syntagma SA/Sebastian Bromberg
 * @see http://www.syntagma.com.ar
 * 
 */

import java.io.Serializable;

import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.contexts.Contexts;
import org.jboss.seam.faces.Renderer;
import org.jboss.seam.log.Log;

@Name("servicioEmail")
@AutoCreate
public class ServicioEmail implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 91119580927899597L;

    private static final String PATH_PREFIX = "/emails/";
    private static final String PATH_SUFFIX = ".xhtml";

    private boolean active = true;

    @In(required = false)
    private Renderer renderer;

    @Logger
    Log log;

    public boolean isActive() {
	return active;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    // TODO: Hacer control de errores para que la excepcion devuelva mensaje
    // para el reporte

    public void send(String template, String toNombre, String toEmail, List<X509Certificate> lista, String subject) {
	log.debug("Iniciando envio de mail ...");

	Map<String, Object> params = null;
	if (!active) {
	    log.trace("El servicio de eMail está inactivo.");
	    return;
	}

	if (params == null) {
	    params = new HashMap<String, Object>();
	}

	toEmail = toEmail.trim();
	List<MailStruct> listaEmails = obtenerListaEmails(toEmail);

	// from.setEmail(from.getEmail().trim());

	params.put("toNombre", toNombre);
	params.put("toEmail", listaEmails);
	params.put("fromNombre", "Esphora Conector");
	params.put("lista", lista);
	params.put("subject", subject);

	for (Map.Entry<String, Object> entry : params.entrySet()) {
	    Contexts.getSessionContext().set(entry.getKey(), entry.getValue());
	}

	renderer.render(PATH_PREFIX + template + PATH_SUFFIX);
    }

    private List<MailStruct> obtenerListaEmails(String toEmail) {
	String[] mails = toEmail.split(",");
	List<MailStruct> listaEmails = new ArrayList<MailStruct>();
	for (String m : mails) {
	    String direccion = "";
	    String nombre = "";
	    if (m.contains("\"")) {
		direccion = m.substring(m.lastIndexOf("\"") + 1).trim();
		nombre = m.substring(m.indexOf("\"") + 1, m.lastIndexOf("\"")).trim();
	    }
	    else {
		direccion = m.trim();
	    }

	    log.debug(direccion);
	    log.debug(nombre);

	    listaEmails.add(new MailStruct(nombre, direccion));

	}
	return listaEmails;
    }
}
