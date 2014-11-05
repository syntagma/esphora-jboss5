package ar.com.syntagma.esphora.conector.helper;

import org.jboss.seam.faces.FacesMessages;
import org.jboss.seam.international.StatusMessage.Severity;

import fex.dif.afip.gov.ar.ClsFEXErr;
import fex.dif.afip.gov.ar.ClsFEXEvents;

public class FEXMensajeDeError {

	public static void ejecutarMensajeDeError(ClsFEXErr respuesta,
			ClsFEXEvents eventos, FacesMessages facesMessages) {

		// consulta si hay un mensaje de error.
		if (respuesta != null && respuesta.getErrCode() != 0) {
			// Carga el error y lo muestra.
			facesMessages.add(Severity.ERROR, respuesta.getErrMsg()
					+ " (Error: " + respuesta.getErrCode() + ")");
		}

		// consulta si hay un evento a mostrar.
		if (eventos != null && eventos.getEventCode() != 0) {
			// Carga el evento y lo muestra.
			facesMessages.add(Severity.INFO, eventos.getEventMsg()
					+ " (Evento: " + eventos.getEventCode() + ")");
		}

	}

}
