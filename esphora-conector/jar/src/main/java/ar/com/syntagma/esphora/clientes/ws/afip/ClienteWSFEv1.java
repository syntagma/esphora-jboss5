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
import fev1.dif.afip.gov.ar.CbteTipoResponse;
import fev1.dif.afip.gov.ar.ConceptoTipoResponse;
import fev1.dif.afip.gov.ar.DocTipoResponse;
import fev1.dif.afip.gov.ar.DummyResponse;
import fev1.dif.afip.gov.ar.FEAuthRequest;
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
import fev1.dif.afip.gov.ar.Service;
import fev1.dif.afip.gov.ar.ServiceSoap;

@Name("clienteWSFEv1")
public class ClienteWSFEv1 extends ClienteWS {
	private Service service;
	private ServiceSoap port;
	private FEAuthRequest req;

	public ClienteWSFEv1(long c) throws ConectorException{
		super(ServicioAfip.WSFEv1,c);
	}

	/**
	 * Dado un lote de comprobantes retorna el mismo autorizado con el CAE
	 * otorgado
	 */
	public FECAEResponse FECAESolicitar(FECAERequest fer) throws ConectorException{
		FECAEResponse response;
		try {

			
			response = port.fecaeSolicitar(req,fer);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso de dado un lote de comprobantes, retonar el mismo autorizado con el CAE", e);
		}
		//return null;
	}

	/**
	 * Consulta el Comprobante
	 */
	public FECompConsultaResponse FECompConsultar(FECompConsultaReq consulta) throws ConectorException{
		FECompConsultaResponse response;

		try {
			response = port.feCompConsultar(req, consulta);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso de de comprobante", e);
		}
		//return null;
	}

	/**
	 * Metodo dummy para verificacion basica de funcionamiento
	 */
	public DummyResponse FEv1Dummy() throws ConectorException{

		DummyResponse response = null;

		try {
			response = port.feDummy();
			return response;
		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para la verificacion basica del funcionamiento", e);
		}
	}

	/**
	 * Retorna el ultimo comprobante autorizado para el tipo de comprobante
	 * /cuit / punto de venta ingresado.
	 */
	public FERecuperaLastCbteResponse FECompUltimoAutorizado(
			int tipoComprobante, int puntoVenta) throws ConectorException{
		 FERecuperaLastCbteResponse response;

		try {
			response = port.feCompUltimoAutorizado(req, puntoVenta, tipoComprobante);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
		//return null;
	}

	/**
	 * Consultar CAEA Emitidos
	 */
	public FECAEAGetResponse FECAEAConsultar(
			int periodo, short orden) throws ConectorException{
		 FECAEAGetResponse response;

		try {
			response = port.fecaeaConsultar(req, periodo, orden);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}


	/**
	 * Solicitud de Codigo de Autorizacion Electronico Anticipado
	 */
	public FECAEAGetResponse FECAEASolicitar(
			int periodo, short orden) throws ConectorException{
		 FECAEAGetResponse response;

		try {
			response = port.fecaeaSolicitar(req, periodo, orden);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}

	/**
	 * Rendicion de Comprobantes Asociados a un CAEA
	 */
	public FECAEAResponse FECAEARegInformativo(
			FECAEARequest feCAEARegInfReq) throws ConectorException{
		FECAEAResponse response;

		try {
			
			response = port.fecaeaRegInformativo(req, feCAEARegInfReq);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}

	/**
	 * Consulta CAEA informado como sin movimientos
	 */
	public FECAEASinMovConsResponse FECAEASinMovimientoConsultar(
			String caea, int ptoVta) throws ConectorException{
		FECAEASinMovConsResponse response;

		try {
			
			response = port.fecaeaSinMovimientoConsultar(req, caea, ptoVta);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}
	
	/**
	 * Informa CAEA sin movimientos
	 */
	public FECAEASinMovResponse FECAEASinMovimientoInformar(
			String caea, int ptoVta) throws ConectorException{
		FECAEASinMovResponse response;

		try {
			
			response = port.fecaeaSinMovimientoInformar(req, ptoVta, caea);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}	

	/**
	 * Retorna la cantidad maxima de registros que puede 
	 * tener una invocacion al metodo FECAESolicitar / FECAEARegInformativo
	 */
	public FERegXReqResponse FECompTotXRequest(
			String caea, int ptoVta) throws ConectorException{
		FERegXReqResponse response;

		try {
			
			response = port.feCompTotXRequest(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}

	/**
	 * Recupera la cotizacion de la moneda consultada y su fecha 
	 */
	public FECotizacionResponse FEParamGetCotizacion(
			String monId) throws ConectorException{
		FECotizacionResponse response;

		try {
			
			response = port.feParamGetCotizacion(req, monId);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}

	/**
	 * Recupera el listado de Tipos de Comprobantes utilizables en servicio de autorizaci—n. 
	 */
	public CbteTipoResponse FEParamGetTiposCbte(
			) throws ConectorException{
		CbteTipoResponse response;

		try {
			
			response = port.feParamGetTiposCbte(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}	
	
	/**
	 * Recupera el listado de puntos de venta registrados y su estado 
	 */
	public FEPtoVentaResponse FEParamGetPtosVenta(
			) throws ConectorException{
		FEPtoVentaResponse response;

		try {
			
			response = port.feParamGetPtosVenta(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}		

	/**
	 * Recupera el listado de identificadores para el campo Concepto 
	 */
	public ConceptoTipoResponse FEParamGetTiposConcepto(
			) throws ConectorException{
		ConceptoTipoResponse response;

		try {
			
			response = port.feParamGetTiposConcepto(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}	
	
	/**
	 * Recupera el listado de Tipos de Documentos utilizables en servicio de autorizaci—n. 
	 */
	public DocTipoResponse FEParamGetTiposDoc(
			) throws ConectorException{
		DocTipoResponse response;

		try {
			
			response = port.feParamGetTiposDoc(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}	

	/**
	 * Recupera el listado de Tipos de Iva utilizables en servicio de autorizaci—n 
	 */
	public IvaTipoResponse FEParamGetTiposIva(
			) throws ConectorException{
		IvaTipoResponse response;

		try {
			
			response = port.feParamGetTiposIva(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}		
	
	/**
	 * Recupera el listado de monedas utilizables en servicio de autorizaci—n 
	 */
	public MonedaResponse FEParamGetTiposMonedas(
			) throws ConectorException{
		MonedaResponse response;

		try {
			
			response = port.feParamGetTiposMonedas(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}		

	/**
	 * Recupera el listado de identificadores para los campos Opcionales 
	 */
	public OpcionalTipoResponse FEParamGetTiposOpcional(
			) throws ConectorException{
		OpcionalTipoResponse response;

		try {
			
			response = port.feParamGetTiposOpcional(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
	}	
	
	/**
	 * Recupera el listado de los diferente tributos que pueden ser utilizados en el servicio de autorizacion 
	 */
	public FETributoResponse FEParamGetTiposTributo(
			) throws ConectorException{
		FETributoResponse response;

		try {
			
			response = port.feParamGetTiposTributos(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso que retorna el ultimo comprobante para el tipo de comprobante/cuit/ptoVenta ingresado", e);
		}
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
			wsdlLocation = new URL(baseUrl,"wsfev1.wsdl");

		} catch (MalformedURLException e) {
			throw new ConectorException(99999,"No se pudo formar la URL del servicio WSFEV1",e);
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
