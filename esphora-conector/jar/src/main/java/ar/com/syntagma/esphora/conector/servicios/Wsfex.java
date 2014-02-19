package ar.com.syntagma.esphora.conector.servicios;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSFEX;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.ClienteFactory;
import ar.com.syntagma.esphora.conector.factories.ErrorFactory;
import fex.dif.afip.gov.ar.ClsFEXGetCMP;
import fex.dif.afip.gov.ar.ClsFEXGetCMPResponse;
import fex.dif.afip.gov.ar.ClsFEXRequest;
import fex.dif.afip.gov.ar.FEXResponseAuthorize;
import fex.dif.afip.gov.ar.FEXResponseCheckPermiso;
import fex.dif.afip.gov.ar.FEXResponseCtz;
import fex.dif.afip.gov.ar.FEXResponseDSTCuit;
import fex.dif.afip.gov.ar.FEXResponseDSTPais;
import fex.dif.afip.gov.ar.FEXResponseIdi;
import fex.dif.afip.gov.ar.FEXResponseInc;
import fex.dif.afip.gov.ar.FEXResponseLastCMP;
import fex.dif.afip.gov.ar.FEXResponseLastID;
import fex.dif.afip.gov.ar.FEXResponseMon;
import fex.dif.afip.gov.ar.FEXResponsePtoVenta;
import fex.dif.afip.gov.ar.FEXResponseTex;
import fex.dif.afip.gov.ar.FEXResponseTipoCbte;
import fex.dif.afip.gov.ar.FEXResponseUmed;

/**
 * Clase destinada a brindar servicios web de Facturacion Electronica en AFIP.
 * 
 * @author sebastian.bromberg
 */
@WebService(name = "wsfex")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT)
public class Wsfex {

	/**
	 * Autoriza un comprobante, devolviendo su CAE correspondiente
	 * 
	 * @param ClsFEXRequest
	 * @return FEXResponseAuthorize
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseAuthorize FEXAuthorize(
			@WebParam(name = "cmp") ClsFEXRequest cmp,
			@WebParam(name = "cuit") long cuit) {
		ClienteWSFEX wsfex;
		FEXResponseAuthorize resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXAuthorize(cmp);
		} catch (ConectorException e) {
			resp = new FEXResponseAuthorize();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		// return wsfex.FEXAuthorize(cmp);
		return resp;
	}

	/**
	 * Verifica la existencia de la permiso/pais de destinacion de embarque
	 * ingresado
	 * 
	 * @param idPermiso
	 * @param dstMerc
	 * @return FEXResponseCheckPermiso
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseCheckPermiso FEXCheck_Permiso(
			@WebParam(name = "idPermiso") String idPermiso,
			@WebParam(name = "dstMerc") int dstMerc,
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXCheck_Permiso(idPermiso, dstMerc);
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseCheckPermiso resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXCheck_Permiso(idPermiso, dstMerc);
		} catch (ConectorException e) {
			resp = new FEXResponseCheckPermiso();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Metodo dummy para verificacion basica de funcionamiento.
	 * 
	 * @return DummyResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public fex.dif.afip.gov.ar.DummyResponse FEXDummy(
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXDummy();
		 */
		ClienteWSFEX wsfex = null;
		fex.dif.afip.gov.ar.DummyResponse dum = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			dum = wsfex.FEXDummy();
			dum.setFechaVencimientoCertificado(wsfex
					.getFechaVencimientoCertificado() != null ? String
					.valueOf(wsfex.getFechaVencimientoCertificado().getTime())
					: null);
			return dum;
		} catch (ConectorException e) {
			dum = new fex.dif.afip.gov.ar.DummyResponse();
			dum.setAppServer("OK");
			dum.setAuthServer((wsfex != null && wsfex
					.getFechaVencimientoCertificado() != null) ? "OK" : "Error");

			if ("Error".equals(dum.getAuthServer())) {
				dum.setDbServer("NA");
			} else {
				dum.setDbServer("Error");
			}
			dum.setErrorMsg(e.getMensaje());
			return dum;
		}

	}

	/**
	 * Recupera los datos completos de un comprobante ya autorizado
	 * 
	 * @param FEXGetCMPResult
	 * @return FEXResponseCheckPermiso
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public ClsFEXGetCMPResponse FEXGetCMP(
			@WebParam(name = "cmp") ClsFEXGetCMP cmp,
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetCMP(cmp);
		 */

		ClienteWSFEX wsfex = null;
		ClsFEXGetCMPResponse resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetCMP(cmp);
		} catch (ConectorException e) {
			resp = new ClsFEXGetCMPResponse();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el ultimo comprobante autorizado
	 * 
	 * @param tipoComprobante
	 * @param puntoVenta
	 * @return FEXResponseLastCMP
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseLastCMP FEXGetLast_CMP(
			@WebParam(name = "tipoComprobante") short tipoComprobante,
			@WebParam(name = "puntoVenta") short puntoVenta,
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetLast_CMP(tipoComprobante, puntoVenta);
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseLastCMP resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetLast_CMP(tipoComprobante, puntoVenta);
		} catch (ConectorException e) {
			resp = new FEXResponseLastCMP();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el ultimo ID y su fecha
	 * 
	 * @return FEXResponseLastID
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseLastID FEXGetLast_ID(@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetLast_ID();
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseLastID resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetLast_ID();
		} catch (ConectorException e) {
			resp = new FEXResponseLastID();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;

	}

	/**
	 * Recupera la cotizacion de la moneda consultada y su fecha
	 * 
	 * @param monId
	 * @return FEXResponseCtz
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseCtz FEXGetPARAM_Ctz(
			@WebParam(name = "idMoneda") String monId,
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetPARAM_Ctz(monId);
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseCtz resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetPARAM_Ctz(monId);
		} catch (ConectorException e) {
			resp = new FEXResponseCtz();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de las cuits de los paises de destinacion
	 * 
	 * @return FEXResponseDSTCuit
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseDSTCuit FEXGetPARAM_DST_CUIT(
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetPARAM_DST_CUIT();
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseDSTCuit resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetPARAM_DST_CUIT();
		} catch (ConectorException e) {
			resp = new FEXResponseDSTCuit();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de los paises de destinacion
	 * 
	 * @return FEXResponseDSTPais
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseDSTPais FEXGetPARAM_DST_pais(
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetPARAM_DST_pais();
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseDSTPais resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetPARAM_DST_pais();
		} catch (ConectorException e) {
			resp = new FEXResponseDSTPais();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de los idiomas y sus codigos utilizables en servicio
	 * de autorizacion
	 * 
	 * @return FEXResponseIdi
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseIdi FEXGetPARAM_Idiomas(@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetPARAM_Idiomas();
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseIdi resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetPARAM_Idiomas();
		} catch (ConectorException e) {
			resp = new FEXResponseIdi();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado Incoterms utilizables en servicio de autorizacion
	 * 
	 * @return FEXResponseInc
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseInc FEXGetPARAM_Incoterms(
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetPARAM_Incoterms();
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseInc resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetPARAM_Incoterms();
		} catch (ConectorException e) {
			resp = new FEXResponseInc();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de monedas y su codigo utilizables en servicio de
	 * autorizacion
	 * 
	 * @return FEXResponseMon
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseMon FEXGetPARAM_MON(@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetPARAM_MON();
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseMon resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetPARAM_MON();
		} catch (ConectorException e) {
			resp = new FEXResponseMon();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de los puntos de venta registrados para Factura
	 * electronica de exportacion - WS y su estado
	 * 
	 * @return FEXResponsePtoVenta
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponsePtoVenta FEXGetPARAM_PtoVenta(
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetPARAM_PtoVenta();
		 */

		ClienteWSFEX wsfex = null;
		FEXResponsePtoVenta resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetPARAM_PtoVenta();
		} catch (ConectorException e) {
			resp = new FEXResponsePtoVenta();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de los tipos de comprobante y su codigo utilizables
	 * en servicio de autorizacion
	 * 
	 * @return FEXResponseTipoCbte
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseTipoCbte FEXGetPARAM_Tipo_Cbte(
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetPARAM_Tipo_Cbte();
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseTipoCbte resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetPARAM_Tipo_Cbte();
		} catch (ConectorException e) {
			resp = new FEXResponseTipoCbte();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de los tipos de exportacion y sus codigo utilizables
	 * en servicio de autorizacionn
	 * 
	 * @return FEXResponseTex
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseTex FEXGetPARAM_Tipo_Expo(
			@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetPARAM_Tipo_Expo();
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseTex resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetPARAM_Tipo_Expo();
		} catch (ConectorException e) {
			resp = new FEXResponseTex();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

	/**
	 * Recupera el listado de las unidades de medida y su codigo utilizables en
	 * servicio de autorizacion
	 * 
	 * @return FEXResponseUmed
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public FEXResponseUmed FEXGetPARAM_UMed(@WebParam(name = "cuit") long cuit) {
		/*
		 * ClienteWSFEX wsfex = ClienteFactory.getClienteWSFEX(cuit); return
		 * wsfex.FEXGetPARAM_UMed();
		 */

		ClienteWSFEX wsfex = null;
		FEXResponseUmed resp = null;

		try {
			wsfex = ClienteFactory.getClienteWSFEX(cuit);
			resp = wsfex.FEXGetPARAM_UMed();
		} catch (ConectorException e) {
			resp = new FEXResponseUmed();
			resp.setFEXErr(ErrorFactory.getError(e));
			return resp;
		}

		return resp;
	}

}
