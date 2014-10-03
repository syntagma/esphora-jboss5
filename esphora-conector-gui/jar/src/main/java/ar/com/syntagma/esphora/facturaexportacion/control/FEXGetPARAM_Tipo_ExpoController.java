package ar.com.syntagma.esphora.facturaexportacion.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fex.dif.afip.gov.ar.FEXResponseTex;

@Name("fexGetPARAM_Tipo_ExpoController")
public class FEXGetPARAM_Tipo_ExpoController {
	
	private long cuit;
	@Out(required=false)
	private FEXResponseTex fexResponseTex;
		
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
		
		fexResponseTex = port.fexGetPARAMTipoExpo(cuit);
	}

}
