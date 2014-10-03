package ar.com.syntagma.esphora.facturaexportacion.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import fex.dif.afip.gov.ar.ClsFEXGetCMP;
import fex.dif.afip.gov.ar.ClsFEXGetCMPResponse;

@Name("fexGetCMPController")
public class FEXGetCMPController {
	
	private ClsFEXGetCMP cmp;
	private long cuit;
	@Out(required=false)
	private ClsFEXGetCMPResponse clsFEXGetCMPResponse;	
	
	@Create
	public void init (){
		cmp = new ClsFEXGetCMP();
	}
	
	public void setCmp(ClsFEXGetCMP cmp) {
		this.cmp = cmp;
	}
	public ClsFEXGetCMP getCmp() {
		return cmp;
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
		
		clsFEXGetCMPResponse = port.fexGetCMP(cmp, cuit);
	}
}
