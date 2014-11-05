package ar.com.syntagma.esphora.facturalocal.control;


import ar.com.syntagma.esphora.conector.helper.ServicePropertiesHelper;
import ar.com.syntagma.esphora.conector.servicios.Wsfe;
import ar.com.syntagma.esphora.conector.servicios.WsfeService;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import facturaelectronica.dif.afip.gov.ar.FERecuperaQTYResponse;

@Name("feRecuperaQTYRequestController")
public class FERecuperaQTYRequestController {
	
	private long cuit;
	@Out(required=false)
	private FERecuperaQTYResponse feRecuperaQTYResponse;
	
	public long getCuit() {
		return cuit;
	}
	public void setCuit(long cuit) {
		this.cuit = cuit;
	}
	
	public void ejecutarConsulta() {
	
		WsfeService service;
		Wsfe port;
		String servicio = "wsfe";

		service = new WsfeService(ServicePropertiesHelper.getURL(servicio),
				ServicePropertiesHelper.getQName(servicio));
		port = service.getWsfePort();
		
		feRecuperaQTYResponse = port.feRecuperaQTYRequest(cuit);
		
	}
}
