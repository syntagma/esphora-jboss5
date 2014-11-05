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
import fev1.dif.afip.gov.ar.FERecuperaLastCbteResponse;

import org.jboss.seam.faces.FacesMessages;

import ar.com.syntagma.esphora.conector.helper.FEMensajeDeError;
import ar.com.syntagma.esphora.conector.helper.ServicePropertiesHelper;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1Service;

@Name("feCompUltimoAutorizado")
public class FECompUltimoAutorizado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242458660705333813L;
	private int cbteTipo;
	private int ptoVta;
	
	@In
	FacesMessages facesMessages;
	
	public int getCbteTipo() {
		return cbteTipo;
	}

	public void setCbteTipo(int cbteTipo) {
		this.cbteTipo = cbteTipo;
	}

	public int getPtoVta() {
		return ptoVta;
	}

	public void setPtoVta(int ptoVta) {
		this.ptoVta = ptoVta;
	}

	//@SuppressWarnings("unused")
	@Out(required = false)
	private FERecuperaLastCbteResponse feRecuperaLastCbteResponse;
	
	public void ejecutarConsulta(String cuit) {

		Wsfev1Service service;
		Wsfev1 port;
		String servicio = "wsfev1";
		service = new Wsfev1Service(ServicePropertiesHelper.getURL(servicio),
				ServicePropertiesHelper.getQName(servicio));
		port = service.getWsfev1Port();
		
		//feResponse.getFedResp().getFEDetalleResponse().get(0).getCbtDesde()
		feRecuperaLastCbteResponse = port.feCompUltimoAutorizado(cbteTipo, ptoVta, Long.parseLong(cuit.trim()));
		
		
		// llama a la clase FEMensajeDeError para validar el mensaje de Error.
		FEMensajeDeError.ejecutarMensajeDeError(feRecuperaLastCbteResponse.getErrors(), feRecuperaLastCbteResponse.getEvents(), facesMessages);
	}
	
}