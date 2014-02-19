package ar.com.syntagma.esphora.facturalocal.control;


import ar.com.syntagma.esphora.conector.servicios.Wsfe;
import ar.com.syntagma.esphora.conector.servicios.WsfeService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import facturaelectronica.dif.afip.gov.ar.DummyResponse;

@Name("feDummyController")
public class FEDummyController {
	
	private long cuit;
	@Out(required=false)
	private DummyResponse dummyResponse;
	
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
		
		dummyResponse = port.feDummy(cuit);
		
	}
}
