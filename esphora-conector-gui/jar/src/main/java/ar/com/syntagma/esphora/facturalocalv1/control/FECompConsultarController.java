package ar.com.syntagma.esphora.facturalocalv1.control;

import java.io.Serializable;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fev1.dif.afip.gov.ar.FECompConsultaReq;
import fev1.dif.afip.gov.ar.FECompConsultaResponse;

import ar.com.syntagma.esphora.conector.servicios.Wsfev1;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1Service;

@Name("feCompConsultarController")
public class FECompConsultarController implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4242458660705333813L;
	private long cuit;
	private int cbteTipo;
	private int ptoVta;
	private long nroFactura;
	
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

	public long getNroFactura() {
		return nroFactura;
	}

	public void setNroFactura(long nroFactura) {
		this.nroFactura = nroFactura;
	}

	@Out(required = false)
	private FECompConsultaResponse feCompConsultaResponse;
	
	public void ejecutarConsulta() {

		Wsfev1Service service;
		Wsfev1 port;

		service = new Wsfev1Service();
		port = service.getWsfev1Port();

		//Se crea la variable de entrada al servicio que contiene los datos de la factura a autorizar	
		FECompConsultaReq feCompConsultaReq = new FECompConsultaReq();
		
		feCompConsultaReq.setCbteNro(nroFactura);
		feCompConsultaReq.setCbteTipo(cbteTipo);
		feCompConsultaReq.setPtoVta(ptoVta);
		
		feCompConsultaResponse = port.feCompConsultar(feCompConsultaReq, cuit);
	}
	

}
