package ar.com.syntagma.esphora.clientes.ws.afip;

import java.net.URL;
import java.util.Date;
import java.util.Properties;

import ar.com.syntagma.esphora.conector.dominio.afip.TicketAfip;
import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.dominio.enums.ServicioAfip;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.PropiedadesFactory;
import facturaelectronica.dif.afip.gov.ar.FEAuthRequest;
import facturaelectronica.dif.afip.gov.ar.Service;
import facturaelectronica.dif.afip.gov.ar.ServiceSoap;

public abstract class ClienteWS {
	protected TicketAfip ticketAfip;
	protected URL baseUrl;
	protected URL wsdlLocation;
	protected ServiceSoap port;
	protected Service service;
	protected FEAuthRequest req;
	protected ServicioAfip servicioAfip;
	protected Ambiente ambiente;
	protected Properties propiedadesWS;
	protected long cuit;

	public ClienteWS(ServicioAfip s, long c) throws ConectorException {
		this.servicioAfip = s;
		this.cuit = c;
		ambiente = getAmbiente();
		propiedadesWS = PropiedadesFactory.getArchivoPropiedadesWS(ambiente,
				servicioAfip);
		// System.out.println("P12File: " +
		// propiedadesWS.getProperty("keystore"));
		completarParametros();
	}

	protected abstract Ambiente completarParametros() throws ConectorException;

	public Date getFechaVencimientoCertificado() {
		return ticketAfip != null ? ticketAfip.getFechaVencimientoCertificado()
				: null;
	}

	private Ambiente getAmbiente() throws ConectorException {
		String a = PropiedadesFactory.getArchivoAmbiente().getProperty(
				"ambiente");

		if (a.equals("test")) {
			return Ambiente.TEST;
		}
		if (a.equals("produccion")) {
			return Ambiente.PRODUCCION;
		} else {
			return Ambiente.DESARROLLO;
		}

	}

}
