package ar.com.syntagma.esphora.conector.servicios;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSFE;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.ClienteFactory;
import ar.com.syntagma.esphora.conector.factories.ErrorFactory;
import facturaelectronica.dif.afip.gov.ar.DummyResponse;
import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEReq;
import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEResponse;
import facturaelectronica.dif.afip.gov.ar.FERecuperaLastCMPResponse;
import facturaelectronica.dif.afip.gov.ar.FERecuperaQTYResponse;
import facturaelectronica.dif.afip.gov.ar.FERequest;
import facturaelectronica.dif.afip.gov.ar.FEResponse;
import facturaelectronica.dif.afip.gov.ar.FEUltNroResponse;

/**
 * Clase destinada a brindar servicios web de Facturacion Electronica en AFIP.
 * 
 * @author sebastian.bromberg
 */
@WebService(name="wsfe")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT)
public class Wsfe {

	/*************** SECCION WSFE *************/
	/**
	 * Dado un lote de comprobantes retorna el mismo autorizado con el CAE
	 * otorgado
	 * 
	 * @param FERequest
	 *            Factura Electronica Request
	 * @return FEResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEResponse FEAutRequest(@WebParam(name = "fer") FERequest fer,
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFE wsfe = ClienteFactory.getClienteWSFE(cuit); return
		 * wsfe.FEAutRequest(fer);
		 */

		ClienteWSFE wsfe = null;
		FEResponse resp = null;

		try {
			wsfe = ClienteFactory.getClienteWSFE(cuit);
			resp = wsfe.FEAutRequest(fer);
		} catch (ConectorException e) {
			resp = new FEResponse();
			resp.setRError(ErrorFactory.getErrorFE(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Consulta el CAE
	 * 
	 * @param FEConsultaCAEReq
	 * 
	 * @return FEConsultaCAEResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEConsultaCAEResponse FEConsultaCAERequest(
			@WebParam(name = "FEConsultaCAEReq") FEConsultaCAEReq argCAERequest,
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFE wsfe = ClienteFactory.getClienteWSFE(cuit); return
		 * wsfe.FEConsultaCAERequest(argCAERequest);
		 */
		ClienteWSFE wsfe = null;
		FEConsultaCAEResponse resp = null;

		try {
			wsfe = ClienteFactory.getClienteWSFE(cuit);
			resp = wsfe.FEConsultaCAERequest(argCAERequest);
		} catch (ConectorException e) {
			resp = new FEConsultaCAEResponse();
			resp.setRError(ErrorFactory.getErrorFE(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Metodo dummy para verificacion basica de funcionamiento
	 * 
	 * @return DummyResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public DummyResponse FEDummy(@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFE wsfe = ClienteFactory.getClienteWSFE(cuit); return
		 * wsfe.FEDummy();
		 */
		ClienteWSFE wsfe = null;
		DummyResponse resp = null;

		try {
			wsfe = ClienteFactory.getClienteWSFE(cuit);
			resp = wsfe.FEDummy();
		} catch (ConectorException e) {
			resp = new DummyResponse();
			resp.setAppserver("Error");
			resp.setAuthserver("Error");
			resp.setDbserver("Error");
			return resp;
		}

		return resp;

	}

	/**
	 * Retorna el ultimo comprobante autorizado para el tipo de comprobante
	 * /cuit / punto de venta ingresado.
	 * 
	 * @param tipoComprobante
	 * @param puntoVenta
	 * 
	 * @return FERecuperaLastCMPResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FERecuperaLastCMPResponse FERecuperaLastCMPRequest(
			@WebParam(name = "tipoComprobante") int tipoComprobante,
			@WebParam(name = "puntoVenta") int puntoVenta,
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFE wsfe = ClienteFactory.getClienteWSFE(cuit); return
		 * wsfe.FERecuperaLastCMPRequest(tipoComprobante,puntoVenta);
		 */

		ClienteWSFE wsfe = null;
		FERecuperaLastCMPResponse resp = null;

		try {
			wsfe = ClienteFactory.getClienteWSFE(cuit);
			resp = wsfe.FERecuperaLastCMPRequest(tipoComprobante, puntoVenta);
		} catch (ConectorException e) {
			resp = new FERecuperaLastCMPResponse();
			resp.setRError(ErrorFactory.getErrorFE(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Retorna la cantidad maxima de registros de detalle que puede tener una
	 * invocacion al FEAutorizarRequest
	 * 
	 * 
	 * @return FERecuperaQTYResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FERecuperaQTYResponse FERecuperaQTYRequest(
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFE wsfe = ClienteFactory.getClienteWSFE(cuit); return
		 * wsfe.FERecuperaQTYRequest();
		 */

		ClienteWSFE wsfe = null;
		FERecuperaQTYResponse resp = null;

		try {
			wsfe = ClienteFactory.getClienteWSFE(cuit);
			resp = wsfe.FERecuperaQTYRequest();
		} catch (ConectorException e) {
			resp = new FERecuperaQTYResponse();
			resp.setRError(ErrorFactory.getErrorFE(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Retorna el ultimo numero de Request
	 * 
	 * 
	 * @return FEUltNroResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEUltNroResponse FEUltNroRequest(@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFE wsfe = ClienteFactory.getClienteWSFE(cuit); return
		 * wsfe.FEUltNroRequest();
		 */

		ClienteWSFE wsfe = null;
		FEUltNroResponse resp = null;

		try {
			wsfe = ClienteFactory.getClienteWSFE(cuit);
			resp = wsfe.FEUltNroRequest();
		} catch (ConectorException e) {
			resp = new FEUltNroResponse();
			resp.setRError(ErrorFactory.getErrorFE(e));
			return resp;
		}

		return resp;
	}

}
