package ar.com.syntagma.esphora.facturalocal.control;


import java.io.Serializable;

import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

import ar.com.syntagma.esphora.conector.servicios.Wsfe;
import ar.com.syntagma.esphora.conector.servicios.WsfeService;
import facturaelectronica.dif.afip.gov.ar.FERecuperaLastCMPResponse;


@Name("feRecuperaLastCMPRequestController")
public class FERecuperaLastCMPRequestController implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1687729481259880597L;
	
	private int tipoComprobante;
	private int puntoVenta;
	private long cuit;
	@Out(required=false)
	private FERecuperaLastCMPResponse feRecuperaLastCMPResponse;
	
	@Logger
	Log log;
	
	public int getTipoComprobante() {
		return tipoComprobante;
	}
	public void setTipoComprobante(int tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public int getPuntoVenta() {
		return puntoVenta;
	}
	public void setPuntoVenta(int puntoVenta) {
		this.puntoVenta = puntoVenta;
	}
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}

	public void ejecutarConsulta() {
	
		WsfeService service;
		Wsfe port;

		service = new WsfeService();
		port = service.getWsfePort();

		feRecuperaLastCMPResponse = port.feRecuperaLastCMPRequest(tipoComprobante, puntoVenta, cuit);
		
	}
}
