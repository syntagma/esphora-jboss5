package ar.com.syntagma.esphora.facturalocalv1.control;

import java.io.Serializable;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fev1.dif.afip.gov.ar.MonedaResponse;

import ar.com.syntagma.esphora.conector.servicios.Wsfev1;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1Service;

@Name("feParamGetTiposMoneda")
public class FEParamGetTiposMoneda implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242458660705333813L;
	private long cuit;
	
	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}


	@SuppressWarnings("unused")
	@Out(required = false)
	private MonedaResponse monedaResponse;
	
	public void ejecutarConsulta() {

		Wsfev1Service service;
		Wsfev1 port;

		service = new Wsfev1Service();
		port = service.getWsfev1Port();

		//feResponse.getFedResp().getFEDetalleResponse().get(0).getCbtDesde()
		monedaResponse = port.feParamGetTiposMonedas(cuit);
	}

}
