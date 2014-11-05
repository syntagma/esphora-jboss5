package ar.com.syntagma.esphora.conector.servicios;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;

import org.jboss.seam.Component;

import ar.com.syntagma.esphora.conector.acciones.CompaniaAccion;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;
import ar.com.syntagma.esphora.conector.servicios.dominio.AdherirCompaniaRequest;

/**
 * Clase destinada a brindar servicios web para adminsitracion de compania
 * 
 * @author sebastian.bromberg
 */
@WebService(name = "operacionesCompania")
@SOAPBinding(parameterStyle = ParameterStyle.WRAPPED, style = Style.DOCUMENT)
public class OperacionesCompania {

	/**
	 * Dado una nueva empresa, generar el certificado en el KeyStore
	 * 
	 * @param AdherirCompaniaRequest
	 * 
	 * @return AdherirCompaniaResponse
	 * @throws Exception
	 *             the exception
	 */
	@WebMethod
	public String adherirCompania(
			@WebParam(name = "req") AdherirCompaniaRequest req) {

		CompaniaAccion companiaAccion = (CompaniaAccion) Component.getInstance("companiaAccion", true);//new CompaniaAccion();
		//AdherirCompaniaResponse resp = null;
		String resp;

		try {

			resp=companiaAccion.adherirCompania(req.getCompania(),
					req.getCrt(), req.getKey());
		} catch (ConectorException e) {
			resp = "Error";

			return resp;
		}

		return resp;
	}

}
