package ar.com.syntagma.esphora.facturaexportacion.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fex.dif.afip.gov.ar.FEXResponseDSTPais;


@Name("fexResponseDSTPaisController")
public class FEXGetPARAM_DST_paisController {
	
	private long cuit;
	@Out(required=false)
	private FEXResponseDSTPais fexResponseDSTPais;
		
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
		
		fexResponseDSTPais = port.fexGetPARAMDSTPais(cuit);
		
	}

}
