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

import fev1.dif.afip.gov.ar.FECompConsultaReq;
import fev1.dif.afip.gov.ar.FECompConsultaResponse;

import ar.com.syntagma.esphora.conector.helper.FEMensajeDeError;
import ar.com.syntagma.esphora.conector.helper.ServicePropertiesHelper;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1Service;

@Name("feCompConsultarController")
public class FECompConsultarController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242458660705333813L;
	private int cbteTipo;
	private int ptoVta;
	private long nroFactura;

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

	public long getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(long nroFactura) {
		this.nroFactura = nroFactura;
	}

	@In
	FacesMessages facesMessages;
	//@SuppressWarnings("unused")
	@Out(required = false)
	private FECompConsultaResponse feCompConsultaResponse;
	
	public void ejecutarConsulta(String cuit) {

		Wsfev1Service service;
		Wsfev1 port;
		String servicio = "wsfev1";
		service = new Wsfev1Service(ServicePropertiesHelper.getURL(servicio),
				ServicePropertiesHelper.getQName(servicio));
		port = service.getWsfev1Port();

		//Se crea la variable de entrada al servicio que contiene los datos de la factura a autorizar	
		FECompConsultaReq feCompConsultaReq = new FECompConsultaReq();
		
		feCompConsultaReq.setCbteNro(nroFactura);
		feCompConsultaReq.setCbteTipo(cbteTipo);
		feCompConsultaReq.setPtoVta(ptoVta);
		
		//pasa el valor que ingresa que es un string a un número.
		feCompConsultaResponse = port.feCompConsultar(feCompConsultaReq, Long.parseLong(cuit.trim()));
		
		// llama a la clase FEMensajeDeError para validar el mensaje de Error.
		FEMensajeDeError.ejecutarMensajeDeError(feCompConsultaResponse.getErrors(), feCompConsultaResponse.getEvents(), facesMessages);
		
	}
	
}
