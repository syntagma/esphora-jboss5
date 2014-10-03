package ar.com.syntagma.esphora.facturaexportacion.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fex.dif.afip.gov.ar.FEXResponseLastCMP;

@Name("fexGetLast_CMPController")
public class FEXGetLast_CMPController {
	
	private short tipoComprobante;
	private short puntoVenta;
	private long cuit;
	@Out(required=false)
	private FEXResponseLastCMP fexResponseLastCMP;
		
	public void setTipoComprobante(short tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public short getTipoComprobante() {
		return tipoComprobante;
	}
	public void setPuntoVenta(short puntoVenta) {
		this.puntoVenta = puntoVenta;
	}
	public short getPuntoVenta() {
		return puntoVenta;
	}
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	
	public void ejecutarConsulta() {
	
		WsfexService service;
		Wsfex port;
				
		service = new WsfexService();
		port = service.getWsfexPort();
		
		fexResponseLastCMP = port.fexGetLastCMP(tipoComprobante, puntoVenta, cuit);
	}

}
