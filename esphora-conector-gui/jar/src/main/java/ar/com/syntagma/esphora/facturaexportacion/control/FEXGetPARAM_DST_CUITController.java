package ar.com.syntagma.esphora.facturaexportacion.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fex.dif.afip.gov.ar.FEXResponseDSTCuit;

@Name("fexGetPARAM_DST_CUITController")
public class FEXGetPARAM_DST_CUITController {
	
	private long cuit;
	@Out(required=false)
	private FEXResponseDSTCuit fexResponseDSTCuit;
		
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
		
		fexResponseDSTCuit = port.fexGetPARAMDSTCUIT(cuit);
	}

}
