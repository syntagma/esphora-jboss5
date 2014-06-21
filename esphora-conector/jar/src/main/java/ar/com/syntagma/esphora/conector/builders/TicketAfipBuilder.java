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
	public TicketAfip getTicketAfip(Ambiente a, ServicioAfip servicioAfip, Long cuit) throws ConectorException {
		String clave = cuit.toString() + servicioAfip;
		log.info("Ingresamos a GetTicketAfip de TicketAfipBuilder.");
		try {
			//obtengo el ticket de la coleccion
			TicketAfip ticketAfip = obtenerTicketAfipFromCache(clave);
			
			if (!isValid(ticketAfip)) {
				log.info("No se ha encontrado un ticket para esta empresa: "
						+ cuit);
				try {
					ticketAfip = AutorizacionHelper.getTicketAfip(a, servicioAfip, cuit);
				}
				catch(ConectorException e) {
					throw e;
				}
				tickets.put(clave, ticketAfip);
			}
			
			return ticketAfip;
		}
		catch(ConectorException ce) {
			ce.printStackTrace();
			throw ce;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ConectorException(
					99999,
					"No se ha podido conseguir el ticket de autorizacion para los servicios de AFIP",
					e);
		}
	}
	private boolean isValid(TicketAfip ticketAfip) {
		try {
			if (ticketAfip != null) {
				if (ticketAfip.getValidezHasta().before(new Date())) {
					log.info("Ticket Vencido");
					return false;
				} else {
					log.info("Ticket Valido");
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			log.info("Ticket Nulo");
			return false;
		}
	}
	
	private TicketAfip obtenerTicketAfipFromCache(String clave) {
		TicketAfip ticketAfip = null;
		if (tickets.containsKey(clave)) {
			ticketAfip = tickets.get(clave);
		}
		return ticketAfip;
	}

}
