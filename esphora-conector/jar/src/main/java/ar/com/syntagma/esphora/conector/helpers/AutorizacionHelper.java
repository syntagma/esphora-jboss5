package ar.com.syntagma.esphora.conector.helpers;

import java.io.Reader;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSAA;
import ar.com.syntagma.esphora.conector.dominio.afip.TicketAfip;
import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.dominio.enums.ServicioAfip;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.ClienteFactory;
import ar.com.syntagma.esphora.conector.factories.PropiedadesFactory;

public class AutorizacionHelper {

	public static TicketAfip getTicketAfip(Ambiente a,
			ServicioAfip servicioAfip, Long cuit) throws ConectorException {
		TicketAfip ticketAfip = getTicketCompleto(a, servicioAfip, cuit);
		return ticketAfip;
	}

	private static TicketAfip getTicketCompleto(Ambiente a,
			ServicioAfip servicioAfip, Long cuit) throws ConectorException {
		Properties propiedades;
		TicketAfip ticketAfip = new TicketAfip();
		try {
			propiedades = PropiedadesFactory.getArchivoPropiedadesWS(a,
					ServicioAfip.WSAA);
		}
		catch (Exception e) {
			throw new ConectorException(
					99999,
					"No se ha encontrado la configuracion de empresa para el cuit: " + cuit,
					e);
		}	
			
		String service = null;
		if (servicioAfip == ServicioAfip.WSFE)
			service = "wsfe";
		if (servicioAfip == ServicioAfip.WSFEv1)
			service = "wsfe";
		if (servicioAfip == ServicioAfip.WSFEX)
			service = "wsfex";

		String dstDN = propiedades.getProperty("dstdn");


		String signer = Long.toString(cuit);

		byte[] loginTicketRequestXmlCms;
		/*
		 * Errores: Se controla error durante la crearcion del
		 * LoginTicketRequest
		 */
			// Create LoginTicketRequest_xml_cms
			loginTicketRequestXmlCms = EncriptacionHelper.crearCms(a,signer, dstDN, service);

		ClienteWSAA ws = null;
			// log.info("LoginTicketCMS: " +
			// loginTicketRequestXmlCms.toString());
		ws = ClienteFactory.getClienteWSAA(cuit);

		String LoginTicketResponse = null;

		/*
		 * Errores: LoginFault_Exception Control de si el servicio para la
		 * autorizacion de ticket es valida
		 */
		LoginTicketResponse = ws.LoginCMSService(loginTicketRequestXmlCms);

		// Get token & sign from LoginTicketResponse
		/*
		 * Errores: Control de que el usuario, se un usuario valido
		 */
			Reader tokenReader = new StringReader(LoginTicketResponse);
			Document tokenDoc;
			try {
				tokenDoc = new SAXReader(false).read(tokenReader);
			} catch (DocumentException e) {
				throw new ConectorException (99999,"Excepcion al leer el Token",e);
			}

			/* Error autorizacion, consultar el mensaje de error directamente */
			String token = tokenDoc
					.valueOf("/loginTicketResponse/credentials/token");
			String sign = tokenDoc
					.valueOf("/loginTicketResponse/credentials/sign");
			String generationTime = tokenDoc
			.valueOf("/loginTicketResponse/header/generationTime");
			String expirationTime = tokenDoc
			.valueOf("/loginTicketResponse/header/expirationTime");
			
			SimpleDateFormat dfGeneration = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss" );
			SimpleDateFormat dfExpiration = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ss" );

			
			ticketAfip.setSign(sign);
			ticketAfip.setToken(token);
			
			try {
				ticketAfip.setValidezDesde(dfGeneration.parse(generationTime));
			} catch (ParseException e) {
				throw new ConectorException (99999,"Excepcion al interpretar la fecha del ticket de acceso",e);
			}
			try {
				ticketAfip.setValidezHasta(dfExpiration.parse(expirationTime));
			} catch (ParseException e) {
				throw new ConectorException (99999,"Excepcion al interpretar la fecha del ticket de acceso",e);
			}

	

		return ticketAfip;

	}
}
