package ar.com.syntagma.esphora.facturalocalv1.control;

import java.io.Serializable;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fev1.dif.afip.gov.ar.FERecuperaLastCbteResponse;

import ar.com.syntagma.esphora.conector.servicios.Wsfev1;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1Service;

@Name("feCompUltimoAutorizado")
public class FECompUltimoAutorizado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242458660705333813L;
	private long cuit;
	private int cbteTipo;
	private int ptoVta;
	
	public long getCuit() {
		return cuit;
	}

	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

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

	@SuppressWarnings("unused")
	@Out(required = false)
	private FERecuperaLastCbteResponse feRecuperaLastCbteResponse;
	
	public void ejecutarConsulta() {

		Wsfev1Service service;
		Wsfev1 port;

		service = new Wsfev1Service();
		port = service.getWsfev1Port();

		//feResponse.getFedResp().getFEDetalleResponse().get(0).getCbtDesde()
		feRecuperaLastCbteResponse = port.feCompUltimoAutorizado(cbteTipo, ptoVta, cuit);
	}

}
