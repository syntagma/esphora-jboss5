package ar.com.syntagma.esphora.facturalocalv1.control;

/**
 * Modificado: Maximiliano Ferreyra 
 * Fecha: 12/12/2011 
 * Descripción: Se modifica le metodo "ejecutarConsulta" Se pasa por parametro el Cuit en forma de String.
 */

import java.io.Serializable;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.faces.FacesMessages;

import fev1.dif.afip.gov.ar.IvaTipoResponse;

import ar.com.syntagma.esphora.conector.helper.FEMensajeDeError;
import ar.com.syntagma.esphora.conector.helper.ServicePropertiesHelper;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1Service;

@Name("feParamGetTiposIva")
public class FEParamGetTiposIva implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242458660705333813L;

	@In
	FacesMessages facesMessages;
	
	//@SuppressWarnings("unused")
	@Out(required = false)
	private IvaTipoResponse ivaTipoResponse;
	
	public void ejecutarConsulta(String cuit) {

		Wsfev1Service service;
		Wsfev1 port;
		String servicio = "wsfev1";
		service = new Wsfev1Service(ServicePropertiesHelper.getURL(servicio),
				ServicePropertiesHelper.getQName(servicio));
		port = service.getWsfev1Port();

		//feResponse.getFedResp().getFEDetalleResponse().get(0).getCbtDesde()
		//pasa el valor que ingresa que es un string a un número.
		ivaTipoResponse = port.feParamGetTiposIva(Long.parseLong(cuit.trim()));
		
		// llama a la clase FEMensajeDeError para validar el mensaje de Error.
		FEMensajeDeError.ejecutarMensajeDeError(ivaTipoResponse.getErrors(), ivaTipoResponse.getEvents(), facesMessages);
		
	}

}
