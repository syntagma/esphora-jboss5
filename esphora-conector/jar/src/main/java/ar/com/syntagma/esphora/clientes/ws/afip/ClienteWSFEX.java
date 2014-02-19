package ar.com.syntagma.esphora.clientes.ws.afip;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import org.jboss.seam.annotations.Name;

import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.dominio.enums.ServicioAfip;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.factories.AuthRequestFactory;
import fex.dif.afip.gov.ar.ClsFEXAuthRequest;
import fex.dif.afip.gov.ar.ClsFEXGetCMP;
import fex.dif.afip.gov.ar.ClsFEXGetCMPResponse;
import fex.dif.afip.gov.ar.ClsFEXLastCMP;
import fex.dif.afip.gov.ar.ClsFEXRequest;
import fex.dif.afip.gov.ar.DummyResponse;
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
import fex.dif.afip.gov.ar.Service;
import fex.dif.afip.gov.ar.ServiceSoap;

@Name("clienteWSFEX")
public class ClienteWSFEX extends ClienteWS {

	private Service service;
	private ServiceSoap port;
	private ClsFEXAuthRequest req;

	public ClienteWSFEX(long c) throws ConectorException{
		super(ServicioAfip.WSFEX, c);
	}

	/**
	 * Autoriza un comprobante, devolviendo su CAE correspondiente
	 */
	public FEXResponseAuthorize FEXAuthorize(ClsFEXRequest cmp) throws ConectorException{
		FEXResponseAuthorize response;

		try {

			response = port.fexAuthorize(req, cmp);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "No se pudo realizar el proceso de autorizacion del comprobante", e);
		}
		
		//return null;
	}

	/**
	 * Verifica la existencia de la permiso/pais de destinacion de embarque
	 * ingresado
	 */
	public FEXResponseCheckPermiso FEXCheck_Permiso(String idPermiso,
			int dstMerc) throws ConectorException{
		FEXResponseCheckPermiso response;

		try {
			response = port.fexCheckPermiso(req, idPermiso, dstMerc);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas al verificar la existencia del pais de destino de embarque", e);
		}
		//return null;
	}

	/**
	 * Metodo dummy para verificacion basica de funcionamiento.
	 */
	public DummyResponse FEXDummy() throws ConectorException{

		DummyResponse response;

		try {			
			response = port.fexDummy();
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para la verificacion basica del funcionamiento", e);
		}
		//return null;
	}

	/**
	 * Recupera los datos completos de un comprobante ya autorizado
	 */
	public ClsFEXGetCMPResponse FEXGetCMP(ClsFEXGetCMP cmp) throws ConectorException{
		ClsFEXGetCMPResponse response;

		try {

			response = port.fexGetCMP(req, cmp);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar los datos completos de un comprobante ya autorizado", e);
		}
		//return null;
	}

	/**
	 * Recupera el ultimos comprobante autorizado
	 */
	public FEXResponseLastCMP FEXGetLast_CMP(short tipoComprobante,
			short puntoVenta) throws ConectorException{
		FEXResponseLastCMP response;

		try {

			ClsFEXLastCMP auth = new ClsFEXLastCMP();
			auth.setCuit(req.getCuit());
			auth.setPtoVenta(puntoVenta);
			auth.setSign(req.getSign());
			auth.setTipoCbte(tipoComprobante);
			auth.setToken(req.getToken());
			response = port.fexGetLastCMP(auth);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar el ultimo comprobante autorizado", e);
		}
		//return null;
	}

	/**
	 * Recupera el ultimo ID y su fecha
	 */
	public FEXResponseLastID FEXGetLast_ID() throws ConectorException{
		FEXResponseLastID response;

		try {
			response = port.fexGetLastID(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar el ultimo ID con su fecha", e);
		}
		//return null;
	}

	/**
	 * Recupera la cotizacion de la moneda consultada y su fecha
	 */
	public FEXResponseCtz FEXGetPARAM_Ctz(String monId) throws ConectorException{
		FEXResponseCtz response;

		try {
			response = port.fexGetPARAMCtz(req, monId);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar la cotizacion de la moneda con su fecha", e);
		}
		//return null;
	}

	/**
	 * Recupera el listado de las cuits de los paises de destinacion
	 */
	public FEXResponseDSTCuit FEXGetPARAM_DST_CUIT() throws ConectorException {
		FEXResponseDSTCuit response;

		try {
			response = port.fexGetPARAMDSTCUIT(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar la lista de cuits de los paises de destinacion", e);
		}
		//return null;
	}

	/**
	 * Recupera el listado de los paises de destinacion
	 */
	public FEXResponseDSTPais FEXGetPARAM_DST_pais() throws ConectorException{
		FEXResponseDSTPais response;

		try {
			response = port.fexGetPARAMDSTPais(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar la lista de paises de destinacion", e);
		}
		//return null;
	}

	/**
	 * Recupera el listado de los idiomas y sus codigos utilizables en servicio
	 * de autorizacion
	 */
	public FEXResponseIdi FEXGetPARAM_Idiomas() throws ConectorException{
		FEXResponseIdi response;

		try {
			response = port.fexGetPARAMIdiomas(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar la lista de idiomas y sus codigos", e);
		}
		//return null;
	}

	/**
	 * Recupera el listado Incoterms utilizables en servicio de autorizacion
	 */
	public FEXResponseInc FEXGetPARAM_Incoterms() throws ConectorException{
		FEXResponseInc response;

		try {
			response = port.fexGetPARAMIncoterms(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar la lista de incoterms", e);
		}
		//return null;
	}

	/**
	 * Recupera el listado de monedas y su codigo utilizables en servicio de
	 * autorizacion
	 */
	public FEXResponseMon FEXGetPARAM_MON() throws ConectorException{
		FEXResponseMon response;

		try {
			response = port.fexGetPARAMMON(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar el listado de monedas y sus codigos", e);
		}
		//return null;
	}

	/**
	 * Recupera el listado de los puntos de venta registrados para Factura
	 * electronica de exportacion - WS y su estado
	 */
	public FEXResponsePtoVenta FEXGetPARAM_PtoVenta() throws ConectorException{
		FEXResponsePtoVenta response;

		try {
			response = port.fexGetPARAMPtoVenta(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar el listado de puntos de venta registrados para FEX-WS y su estado", e);
		}
		//return null;
	}

	/**
	 * Recupera el listado de los tipos de comprobante y su codigo utilizables
	 * en servicio de autorizacion
	 */
	public FEXResponseTipoCbte FEXGetPARAM_Tipo_Cbte() throws ConectorException{
		FEXResponseTipoCbte response;

		try {
			response = port.fexGetPARAMTipoCbte(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar el listado de tipos de comprobante y sus codigos", e);
		}
		//return null;
	}

	/**
	 * Recupera el listado de los tipos de exportacion y sus codigo utilizables
	 * en servicio de autorizacionn
	 */
	public FEXResponseTex FEXGetPARAM_Tipo_Expo() throws ConectorException{
		FEXResponseTex response;

		try {
			response = port.fexGetPARAMTipoExpo(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar el listado de tipos de exportacion y sus codigos", e);
		}
		//return null;
	}

	/**
	 * Recupera el listado de las unidades de medida y su codigo utilizables en
	 * servicio de autorizacion
	 */
	public FEXResponseUmed FEXGetPARAM_UMed() throws ConectorException{
		FEXResponseUmed response;

		try {
			response = port.fexGetPARAMUMed(req);
			return response;

		} catch (Exception e) {
			throw new ConectorException(99999, "Problemas para recuperar el listado de unidades de medida", e);
		}
		//return null;
	}

	@Override
	protected Ambiente completarParametros() throws ConectorException {
		QName serviceName = new QName(propiedadesWS.getProperty("namespace"), propiedadesWS.getProperty("service"));
		
		try {
			if (ambiente == Ambiente.TEST) {
				baseUrl = Thread.currentThread().getContextClassLoader().getResource("test/");
			} else {
				baseUrl = Thread.currentThread().getContextClassLoader().getResource("prod/");
			}
			wsdlLocation = new URL(baseUrl,"wsfex.wsdl");

		} catch (MalformedURLException e) {
			throw new ConectorException(99999,"No se pudo formar la URL del servicio WSFEX",e);
		}
		
		try{
			service = new Service(wsdlLocation, serviceName);
		}catch (Exception e) {
			throw new ConectorException(99999, "No se puede establecer el servicio "+serviceName.toString()+" en la locacion "+wsdlLocation.toExternalForm(),e);
		}
		
		try {
			port = service.getServiceSoap();
		}catch (Exception e) {
			throw new ConectorException(99999, "No es posible obtener el servicio especificado "+serviceName.toString(),e);
		}

		ticketAfip = AuthRequestFactory.getAuthRequest(ambiente,servicioAfip,cuit);
		
		
		req = new ClsFEXAuthRequest();
		req.setCuit(cuit);
		req.setSign(ticketAfip.getSign());
		req.setToken(ticketAfip.getToken());

		return null;
	}
}
