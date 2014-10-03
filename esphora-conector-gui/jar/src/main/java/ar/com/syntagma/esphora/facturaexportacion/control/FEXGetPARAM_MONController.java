package ar.com.syntagma.esphora.facturaexportacion.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fex.dif.afip.gov.ar.FEXResponseMon;

@Name("fexGetPARAM_MONController")
public class FEXGetPARAM_MONController {
	
	private long cuit;
	@Out(required=false)
	private FEXResponseMon fexResponseMon;
		
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
		
		fexResponseMon = port.fexGetPARAMMON(cuit);
		
	}

}
