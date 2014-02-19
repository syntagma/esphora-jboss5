package ar.com.syntagma.esphora.conector.factories;

import org.jboss.seam.Component;

import ar.com.syntagma.esphora.conector.builders.TicketAfipBuilder;
import ar.com.syntagma.esphora.conector.dominio.afip.TicketAfip;
import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.dominio.enums.ServicioAfip;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;

public class AuthRequestFactory {

	public static TicketAfip getAuthRequest  (Ambiente a,
			ServicioAfip servicioAfip, long cuit) throws ConectorException {
		//TicketAfip ticketAfip = AutorizacionHelper.getTicketAfip(a,servicioAfip, cuit);
		TicketAfipBuilder ticketAfipBuilder = (TicketAfipBuilder) Component.getInstance("ticketAfipBuilder");
		return ticketAfipBuilder.getTicketAfip(a, servicioAfip, cuit);
	}

}
