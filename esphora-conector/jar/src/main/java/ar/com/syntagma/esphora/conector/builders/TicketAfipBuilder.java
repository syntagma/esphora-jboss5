package ar.com.syntagma.esphora.conector.builders;

import java.util.Date;
import java.util.HashMap;

import org.jboss.seam.ScopeType;
import org.jboss.seam.annotations.AutoCreate;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.annotations.Startup;
import org.jboss.seam.log.Log;

import ar.com.syntagma.esphora.conector.dominio.afip.TicketAfip;
import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.dominio.enums.ServicioAfip;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.helpers.AutorizacionHelper;

/**
 * 
 * @author sebastian.bromberg
 * @version 1.0
 * 
 *          Clase dedicada a la administracion de Tickets de autentificacion en
 *          AFIP.
 */

@Name("ticketAfipBuilder")
@Scope(ScopeType.APPLICATION)
@AutoCreate
@Startup
public class TicketAfipBuilder {

	private HashMap<String, TicketAfip> tickets;

	public TicketAfipBuilder() {
		super();
		tickets = new HashMap<String, TicketAfip>();
	}

	@Logger
	private Log log;

	/**
	 * Metodo que se encarga de devolver un ticket valido de AFIP. Ya sea
	 * creando uno nuevo o uno creado anteriormente pero aun con validez
	 * 
	 * @param a
	 * @param servicioAfip
	 * @param cuit
	 * @return TicketAfip
	 * @throws ConectorException
	 */
	public TicketAfip getTicketAfip(Ambiente a, ServicioAfip servicioAfip,
			Long cuit) throws ConectorException {
		TicketAfip ticketAfip = null;
		String clave = cuit.toString() + servicioAfip;
		log.info("Ingresamos a GetTicketAfip de TicketAfipBuilder.");
		/**
		 * Me fijo si hay un elemento para ese cuit
		 */
		try {
			if (!tickets.containsKey(clave)) {
				/**
				 * Si el cuit no estaba autorizado, realizamos la autorizacion y
				 * devolvemos el ticket
				 */
				log.info("No se ha encontrado un ticket para esta empresa: "
						+ cuit);
				ticketAfip = AutorizacionHelper.getTicketAfip(a, servicioAfip,
						cuit);
				tickets.put(clave, ticketAfip);
				log.info("Ticket obtenido OK para: " + cuit + " Servicio: "
						+ servicioAfip);
				return ticketAfip;
			}
		} catch (ConectorException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConectorException(
					99999,
					"No se ha podido conseguir el ticket de autorizacion para los servicios de AFIP",
					e);
		}

		try {
			/**
			 * Si el cuit ya tiene un ticket, se evalua si esta vencido o no. En
			 * caso de estar vencido se obtiene un nuevo ticket.
			 */
			ticketAfip = tickets.get(clave);
			log.info("Se ha encontrado un ticket para esta empresa: " + cuit
					+ " Servicio: " + servicioAfip);
			log.info("El vencimiento del mismo es: "
					+ ticketAfip.getValidezHasta());

			if (ticketAfip.getValidezHasta().before(new Date())) {
				log.info("Ticket Vencido");
				return AutorizacionHelper.getTicketAfip(a, servicioAfip, cuit);
			} else {
				log.info("Ticket Valido");
				return ticketAfip;
			}
		} catch (NullPointerException e) {
			log.info("Ticket Nulo");
			return AutorizacionHelper.getTicketAfip(a, servicioAfip, cuit);
		}

	}

}
