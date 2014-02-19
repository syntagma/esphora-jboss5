package ar.com.syntagma.esphora.clientes.ws.afip;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.soap.SOAPFaultException;

import org.jboss.seam.annotations.Name;

import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.dominio.enums.ServicioAfip;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.AuthRequestFactory;
import facturaelectronica.dif.afip.gov.ar.DummyResponse;
import facturaelectronica.dif.afip.gov.ar.FEAuthRequest;
import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEReq;
import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEResponse;
import facturaelectronica.dif.afip.gov.ar.FELastCMPtype;
import facturaelectronica.dif.afip.gov.ar.FERecuperaLastCMPResponse;
import facturaelectronica.dif.afip.gov.ar.FERecuperaQTYResponse;
import facturaelectronica.dif.afip.gov.ar.FERequest;
import facturaelectronica.dif.afip.gov.ar.FEResponse;
import facturaelectronica.dif.afip.gov.ar.FEUltNroResponse;
import facturaelectronica.dif.afip.gov.ar.Service;

@Name("clienteWSFE")
public class ClienteWSFE extends ClienteWS {

	public ClienteWSFE(long c) throws ConectorException{
		super(ServicioAfip.WSFE,c);
	}

	/**
	 * Dado un lote de comprobantes retorna el mismo autorizado con el CAE
	 * otorgado
	 */
	public FEResponse FEAutRequest(FERequest fer) throws ConectorException{
		FEResponse response;

		try {

			response = port.feAutRequest(req, fer);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso de dado un lote de comprobantes, retonar el mismo autorizado con el CAE", e);
		}
		//return null;
	}

	/**
	 * Consulta el CAE
	 */
	public FEConsultaCAEResponse FEConsultaCAERequest(
			FEConsultaCAEReq argCAERequest) throws ConectorException{
		FEConsultaCAEResponse response;

		try {
			response = port.feConsultaCAERequest(req, argCAERequest);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso de consulta del CAE", e);
		}
		//return null;
	}

	/**
	 * Metodo dummy para verificacion basica de funcionamiento
	 */
	public DummyResponse FEDummy() throws ConectorException{

		DummyResponse response = null;

		try {
			response = port.feDummy();

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar dummy", e);
		}
		return response;
	}

	/**
	 * Retorna el ultimo comprobante autorizado para el tipo de comprobante
	 * /cuit / punto de venta ingresado.
	 */
	public FERecuperaLastCMPResponse FERecuperaLastCMPRequest(
			int tipoComprobante, int puntoVenta) throws ConectorException{
		FERecuperaLastCMPResponse response;

		try {
			FELastCMPtype type = new FELastCMPtype();
			type.setTipoCbte(tipoComprobante);
			type.setPtoVta(puntoVenta);
			response = port.feRecuperaLastCMPRequest(req, type);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
		//return null;
	}

	/**
	 * Retorna la cantidad maxima de registros de detalle que puede tener una
	 * invocacion al FEAutorizarRequest
	 */
	public FERecuperaQTYResponse FERecuperaQTYRequest()throws ConectorException {
		FERecuperaQTYResponse response;

		try {
			response = port.feRecuperaQTYRequest(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna la maxima cantidad de resgitros de detalle que puede tener una invocacion al FEAutorizarRequest", e);
		}
		//return null;
	}

	/**
	 * Retorna el ultimo numero de Request
	 */
	public FEUltNroResponse FEUltNroRequest() throws ConectorException{
		FEUltNroResponse response;

		try {
			response = port.feUltNroRequest(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo numero de request", e);
		}
		//return null;
	}

	@Override
	protected Ambiente completarParametros() throws ConectorException{
		QName serviceName = new QName(propiedadesWS.getProperty("namespace"), propiedadesWS.getProperty("service"));
		
		try {
			if (ambiente == Ambiente.TEST) {
				baseUrl = Thread.currentThread().getContextClassLoader().getResource("test/");
			} else {
				baseUrl = Thread.currentThread().getContextClassLoader().getResource("prod/");
			}
			wsdlLocation = new URL(baseUrl,"wsfe.wsdl");

		} catch (MalformedURLException e) {
			throw new ConectorException(99999,"No se pudo formar la URL del servicio WSFE",e);
		}
		
		
		try{
			service = new Service(wsdlLocation, serviceName);
		}catch (SOAPFaultException e) {
			throw new ConectorException(99999, "No se puede establecer el servicio "+serviceName.toString()+" en la locacion "+wsdlLocation.toExternalForm(),e); 
		}
		
		try{
			port = service.getServiceSoap();
		}catch (SOAPFaultException e) {
			throw new ConectorException(99999, "No es posible obtener el servicio especificado "+serviceName.toString(),e);
		}
		
		
		ticketAfip = AuthRequestFactory.getAuthRequest(ambiente,servicioAfip,cuit);
		
		
		req = new FEAuthRequest();
		req.setCuit(cuit);
		req.setSign(ticketAfip.getSign());
		req.setToken(ticketAfip.getToken());
		return null;
	}

}
