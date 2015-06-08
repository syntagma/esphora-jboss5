package ar.com.syntagma.esphora.facturaexportacion.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fex.dif.afip.gov.ar.FEXResponseIdi;

@Name("fexGetPARAM_IdiomasController")
public class FEXGetPARAM_IdiomasController {
	
	private long cuit;
	@Out(required=false)
	private FEXResponseIdi fexResponseIdi;
		
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	
	public void ejecutarConsulta(Long cuit) {
	
		WsfexService service;
		Wsfex port;
				
		service = new WsfexService();
		port = service.getWsfexPort();
		
		fexResponseIdi = port.fexGetPARAMIdiomas(cuit);
		
	}

}
