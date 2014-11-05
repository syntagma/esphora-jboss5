package ar.com.syntagma.esphora.conector.helper;

import org.jboss.seam.international.StatusMessage.Severity;
import org.jboss.seam.faces.FacesMessages;
import fev1.dif.afip.gov.ar.ArrayOfErr;
import fev1.dif.afip.gov.ar.ArrayOfEvt;
import fev1.dif.afip.gov.ar.Err;
import fev1.dif.afip.gov.ar.Evt;


public class FEMensajeDeError {


	public static void ejecutarMensajeDeError(ArrayOfErr respuesta,
			ArrayOfEvt eventos, FacesMessages facesMessages) {
		// consulta si la lista no esta vacia.
		if (respuesta != null && respuesta.getErr() != null
				&& respuesta.getErr().size() > 0) {

			// Carga la lista de Errores y los muestra.
			for (Err err : respuesta.getErr()) {
				facesMessages.add(Severity.ERROR, err.getMsg() + " (Error: "
						+ err.getCode() + ")");
			}
		}

		// Consulta si la lista no esta vacia
		if (eventos != null && eventos.getEvt() != null
				&& eventos.getEvt().size() > 0) {
			// Carga la lista de eventos y los muestra.
			for (Evt evt : eventos.getEvt()) {
				facesMessages.add(Severity.INFO, evt.getMsg() + " (Evento: "
						+ evt.getCode() + ")");
			}
		}
	}
}
