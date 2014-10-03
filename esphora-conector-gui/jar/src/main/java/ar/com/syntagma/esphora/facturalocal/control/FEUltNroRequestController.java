package ar.com.syntagma.esphora.facturalocal.control;


import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import ar.com.syntagma.esphora.conector.servicios.Wsfe;
import ar.com.syntagma.esphora.conector.servicios.WsfeService;
import facturaelectronica.dif.afip.gov.ar.FEUltNroResponse;


@Name("feUltNroRequestController")
public class FEUltNroRequestController {

	private long cuit;
	@Out(required=false)
	private FEUltNroResponse feUltNroResponse;
	
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
		
		feUltNroResponse = port.feUltNroRequest(cuit);
		
	}
}
