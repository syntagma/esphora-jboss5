package ar.com.syntagma.esphora.facturaexportacion.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fex.dif.afip.gov.ar.FEXResponseCtz;

@Name("fexGetPARAM_CtzController")
public class FEXGetPARAM_CtzController {
	
	private long cuit;
	private String idMoneda;
	@Out(required=false)
	private FEXResponseCtz fexResponseCtz;
		
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	public String getIdMoneda() {
		return idMoneda;
	}
	public void setIdMoneda(String idMoneda) {
		this.idMoneda = idMoneda;
	}
	
	public void ejecutarConsulta() {
	
		WsfexService service;
		Wsfex port;
				
		service = new WsfexService();
		port = service.getWsfexPort();
		
		fexResponseCtz = port.fexGetPARAMCtz(idMoneda, cuit);
	}

}
