package ar.com.syntagma.esphora.facturaexportacion.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fex.dif.afip.gov.ar.FEXResponseTipoCbte;

@Name("fexGetPARAM_Tipo_CbteController")
public class FEXGetPARAM_Tipo_CbteController {
	
	private long cuit;
	@SuppressWarnings("unused")
	@Out(required=false)
	private FEXResponseTipoCbte fexResponseTipoCbte;
		
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
		
		fexResponseTipoCbte = port.fexGetPARAMTipoCbte(cuit);
	}

}
