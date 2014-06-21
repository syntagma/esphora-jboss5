package ar.com.syntagma.esphora.clientes.ws.afip;

import gov.afip.desein.dvadac.sua.view.wsaa.LoginCms;
import https.wsaa_afip_gov_ar.ws.services.logincms.LoginFault_Exception;
import https.wsaahomo_afip_gov_ar.ws.services.logincms.LoginCMSService;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.axis.encoding.Base64;
import org.jboss.seam.annotations.Name;

import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.dominio.enums.ServicioAfip;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;

@Name("clienteWSAA")
public class ClienteWSAA extends ClienteWS {
	LoginCMSService serviceTest;
	https.wsaa_afip_gov_ar.ws.services.logincms.LoginCMSService serviceProd;

	public ClienteWSAA(Long c) throws ConectorException {
		super(ServicioAfip.WSAA, c);
	}

	// Se envia el string encriptado para la autentificacion y se recibe un
	// string encriptado
	// con el Token y el Sign
	public String LoginCMSService(byte[] loginTicketRequestXmlCms)
			throws ConectorException {
		String response = null;

			LoginCms in = new LoginCms();
			in.setIn0(Base64.encode(loginTicketRequestXmlCms).toString());
			if (this.ambiente == Ambiente.PRODUCCION) {
				try {
					response = serviceProd.getLoginCms().loginCms(in.getIn0());
				} catch (LoginFault_Exception e) {
					 throw new ConectorException(99998,
							 "Error al intentar usar el servicio de autenficicacion de Afip: " + e.getMessage(), e);
				} catch (Exception e) {
					 throw new ConectorException(99999,
							 "Error al intentar usar el certificado para conectarse a afip: " + e.getMessage(), e);					
				}
				
			} else {
				try {
					response = serviceTest.getLoginCms().loginCms(in.getIn0());
				} catch (https.wsaahomo_afip_gov_ar.ws.services.logincms.LoginFault_Exception e) {
					 throw new ConectorException(99997,
							 "Error al intentar usar el servicio autenficicacion de Afip: " + e.getMessage(), e);
				} catch (Exception e) {
					 throw new ConectorException(99996,
							 "Error al intentar usar el certificado para conectarse a afip: " + e.getMessage(), e);					
				}
			}


		return (response);
	}

	@Override
	protected Ambiente completarParametros() throws ConectorException {
		if (this.ambiente == Ambiente.PRODUCCION) {
			baseUrl = https.wsaa_afip_gov_ar.ws.services.logincms.LoginCMSService.class
					.getResource(".");
		} else {
			baseUrl = https.wsaahomo_afip_gov_ar.ws.services.logincms.LoginCMSService.class
					.getResource(".");

		}

		QName serviceName = new QName(propiedadesWS.getProperty("namespace"),
				propiedadesWS.getProperty("service"));
		try {
			wsdlLocation = new URL(baseUrl, propiedadesWS.getProperty("wsdl"));
		} catch (MalformedURLException e) {
			throw new ConectorException(99999,
					"No se pudo formar la URL del servicio WSFE", e);
		}

		try {
			if (this.ambiente == Ambiente.PRODUCCION) {
				serviceProd = new https.wsaa_afip_gov_ar.ws.services.logincms.LoginCMSService(
						wsdlLocation, serviceName);
			} else {
				serviceTest = new https.wsaahomo_afip_gov_ar.ws.services.logincms.LoginCMSService(
						wsdlLocation, serviceName);
			}
		} catch (SOAPFaultException e) {
			throw new ConectorException(99999,
					"No se puede establecer el servicio "
							+ serviceName.toString() + " en la locacion "
							+ wsdlLocation.toExternalForm(), e);
		}
		return null;
	}

}
