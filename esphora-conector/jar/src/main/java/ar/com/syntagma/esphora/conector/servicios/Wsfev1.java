package ar.com.syntagma.esphora.conector.servicios;

import java.net.UnknownHostException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSFEv1;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.ClienteFactory;
import ar.com.syntagma.esphora.conector.factories.ErrorFactory;
import fev1.dif.afip.gov.ar.CbteTipoResponse;
import fev1.dif.afip.gov.ar.ConceptoTipoResponse;
import fev1.dif.afip.gov.ar.DocTipoResponse;
import fev1.dif.afip.gov.ar.FECAEAGetResponse;
import fev1.dif.afip.gov.ar.FECAEARequest;
import fev1.dif.afip.gov.ar.FECAEAResponse;
import fev1.dif.afip.gov.ar.FECAEASinMovConsResponse;
import fev1.dif.afip.gov.ar.FECAEASinMovResponse;
import fev1.dif.afip.gov.ar.FECAERequest;
import fev1.dif.afip.gov.ar.FECAEResponse;
import fev1.dif.afip.gov.ar.FECompConsultaReq;
import fev1.dif.afip.gov.ar.FECompConsultaResponse;
import fev1.dif.afip.gov.ar.FECotizacionResponse;
import fev1.dif.afip.gov.ar.FEPtoVentaResponse;
import fev1.dif.afip.gov.ar.FERecuperaLastCbteResponse;
import fev1.dif.afip.gov.ar.FERegXReqResponse;
import fev1.dif.afip.gov.ar.FETributoResponse;
import fev1.dif.afip.gov.ar.IvaTipoResponse;
import fev1.dif.afip.gov.ar.MonedaResponse;
import fev1.dif.afip.gov.ar.OpcionalTipoResponse;

/**
 * Clase destinada a brindar servicios web de Facturacion Electronica en AFIP.
 * 
 * @author sebastian.bromberg
 */
@WebService(name = "wsfev1")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT)
public class Wsfev1 {

	/**
	 * Dado un lote de comprobantes retorna el mismo autorizado con el CAE
	 * otorgado
	 * 
	 * @param FECAERequest
	 *            Factura Electronica Request
	 * @return FECAEResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FECAEResponse FECAESolicitar(
			@WebParam(name = "fer") FECAERequest fer,
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FECAEResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FECAESolicitar(fer);
		} catch (ConectorException e) {
			resp = new FECAEResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Consulta de comprobante por Tipo, Numero y Pto de Venta
	 * 
	 * @param FECompConsultaReq
	 * 
	 * @return FECompConsultaResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FECompConsultaResponse FECompConsultar(
			@WebParam(name = "FECompConsultaReq") FECompConsultaReq consulta,
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FECompConsultaResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FECompConsultar(consulta);
		} catch (ConectorException e) {
			resp = new FECompConsultaResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
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
	public fev1.dif.afip.gov.ar.DummyResponse FEV1Dummy(
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFE wsfe = ClienteFactory.getClienteWSFE(cuit); return
		 * wsfe.FEDummy();
		 */
		ClienteWSFEv1 wsfev1 = null;
		fev1.dif.afip.gov.ar.DummyResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FEv1Dummy();
			resp.setFechaVencimientoCertificado(wsfev1
					.getFechaVencimientoCertificado() != null ? String
					.valueOf(wsfev1.getFechaVencimientoCertificado().getTime())
					: null);
			return resp;
		} catch (ConectorException e) {
			resp = new fev1.dif.afip.gov.ar.DummyResponse();
			resp.setAppServer("OK");
			resp.setAuthServer("Error");
			if ((wsfev1 != null && wsfev1.getFechaVencimientoCertificado() != null)) {
				resp.setFechaVencimientoCertificado(String.valueOf(wsfev1
						.getFechaVencimientoCertificado().getTime()));
			}

			if ("Error".equals(resp.getAuthServer())) {
				resp.setDbServer("NA");
			} else {
				resp.setDbServer("Error");
			}
			resp.setErrorMsg(e.getMensaje());
			return resp;
		}
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
	public FERecuperaLastCbteResponse FECompUltimoAutorizado(
			@WebParam(name = "tipoComprobante") int tipoComprobante,
			@WebParam(name = "puntoVenta") int puntoVenta,
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FERecuperaLastCbteResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FECompUltimoAutorizado(tipoComprobante, puntoVenta);
		} catch (ConectorException e) {
			resp = new FERecuperaLastCbteResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Consultar CAEA Emitidos
	 * 
	 * @param periodo
	 * @param orden
	 * 
	 * @return FECAEAGetResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FECAEAGetResponse FECAEAConsultar(
			@WebParam(name = "periodo") int periodo,
			@WebParam(name = "orden") short orden,
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FECAEAGetResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FECAEAConsultar(periodo, orden);
		} catch (ConectorException e) {
			resp = new FECAEAGetResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Solicitud de Codigo de Autorizacion Electronico Anticipado
	 * 
	 * @param periodo
	 * @param orden
	 * 
	 * @return FECAEAGetResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FECAEAGetResponse FECAEASolicitar(
			@WebParam(name = "periodo") int periodo,
			@WebParam(name = "orden") short orden,
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FECAEAGetResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FECAEASolicitar(periodo, orden);
		} catch (ConectorException e) {
			resp = new FECAEAGetResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Rendicion de Comprobantes Asociados a un CAEA
	 * 
	 * @param FECAEARequest
	 *            feCAEARegInfReq
	 * 
	 * @return FECAEAResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FECAEAResponse FECAEARegInformativo(
			@WebParam(name = "feCAEARegInfReq") FECAEARequest feCAEARegInfReq,
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FECAEAResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FECAEARegInformativo(feCAEARegInfReq);
		} catch (ConectorException e) {
			resp = new FECAEAResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Consulta CAEA informado como sin movimientos
	 * 
	 * @param String
	 *            caea
	 * @param int ptoVta
	 * 
	 * @return FECAEASinMovConsResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FECAEASinMovConsResponse FECAEASinMovimientoConsultar(
			@WebParam(name = "caea") String caea,
			@WebParam(name = "ptoVta") int ptoVta,
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FECAEASinMovConsResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FECAEASinMovimientoConsultar(caea, ptoVta);
		} catch (ConectorException e) {
			resp = new FECAEASinMovConsResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Informa CAEA sin movimientos
	 * 
	 * @param String
	 *            caea
	 * @param int ptoVta
	 * 
	 * @return FECAEASinMovResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FECAEASinMovResponse FECAEASinMovimientoInformar(
			@WebParam(name = "caea") String caea,
			@WebParam(name = "ptoVta") int ptoVta,
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FECAEASinMovResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FECAEASinMovimientoInformar(caea, ptoVta);
		} catch (ConectorException e) {
			resp = new FECAEASinMovResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Retorna la cantidad maxima de registros que puede tener una invocacion al
	 * metodo FECAESolicitar / FECAEARegInformativo
	 * 
	 * @param String
	 *            caea
	 * @param int ptoVta
	 * 
	 * @return FECAEASinMovConsResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FERegXReqResponse FECompTotXRequest(
			@WebParam(name = "caea") String caea,
			@WebParam(name = "ptoVta") int ptoVta,
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FERegXReqResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FECompTotXRequest(caea, ptoVta);
		} catch (ConectorException e) {
			resp = new FERegXReqResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera la cotizacion de la moneda consultada y su fecha
	 * 
	 * @param String
	 *            monId
	 * 
	 * @return FECotizacionResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FECotizacionResponse FEParamGetCotizacion(
			@WebParam(name = "monId") String monId,
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FECotizacionResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FEParamGetCotizacion(monId);
		} catch (ConectorException e) {
			resp = new FECotizacionResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de puntos de venta registrados y su estado
	 * 
	 * 
	 * @return FEPtoVentaResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEPtoVentaResponse FEParamGetPtosVenta(
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FEPtoVentaResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FEParamGetPtosVenta();
		} catch (ConectorException e) {
			resp = new FEPtoVentaResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de Tipos de Comprobantes utilizables en servicio de
	 * autorizaci—n
	 * 
	 * 
	 * @return CbteTipoResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public CbteTipoResponse FEParamGetTiposCbte(
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		CbteTipoResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FEParamGetTiposCbte();
		} catch (ConectorException e) {
			resp = new CbteTipoResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de identificadores para el campo Concepto
	 * 
	 * 
	 * @return ConceptoTipoResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public ConceptoTipoResponse FEParamGetTiposConcepto(
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		ConceptoTipoResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FEParamGetTiposConcepto();
		} catch (ConectorException e) {
			resp = new ConceptoTipoResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de Tipos de Documentos utilizables en servicio de
	 * autorizaci—n
	 * 
	 * 
	 * @return DocTipoResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public DocTipoResponse FEParamGetTiposDoc(@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		DocTipoResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FEParamGetTiposDoc();
		} catch (ConectorException e) {
			resp = new DocTipoResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de Tipos de Iva utilizables en servicio de
	 * autorizaci—n
	 * 
	 * 
	 * @return IvaTipoResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public IvaTipoResponse FEParamGetTiposIva(@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		IvaTipoResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FEParamGetTiposIva();
		} catch (ConectorException e) {
			resp = new IvaTipoResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de monedas utilizables en servicio de autorizaci—n
	 * 
	 * 
	 * @return MonedaResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public MonedaResponse FEParamGetTiposMonedas(
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		MonedaResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FEParamGetTiposMonedas();
		} catch (ConectorException e) {
			resp = new MonedaResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de identificadores para los campos Opcionales
	 * 
	 * 
	 * @return OpcionalTipoResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public OpcionalTipoResponse FEParamGetTiposOpcional(
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		OpcionalTipoResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FEParamGetTiposOpcional();
		} catch (ConectorException e) {
			resp = new OpcionalTipoResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de los diferente tributos que pueden ser utilizados
	 * en el servicio de autorizacion
	 * 
	 * 
	 * @return FETributoResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FETributoResponse FEParamGetTiposTributo(
			@WebParam(name = "cuit") long cuit) {

		ClienteWSFEv1 wsfev1 = null;
		FETributoResponse resp = null;

		try {
			wsfev1 = ClienteFactory.getClienteWSFEv1(cuit);
			resp = wsfev1.FEParamGetTiposTributo();
		} catch (ConectorException e) {
			resp = new FETributoResponse();
			resp.setErrors(ErrorFactory.getErrorFEv1(e));
			return resp;
		}

		return resp;
	}

}
