package ar.com.syntagma.esphora.facturalocal.control;


import ar.com.syntagma.esphora.conector.helper.ServicePropertiesHelper;
import ar.com.syntagma.esphora.conector.servicios.Wsfe;
import ar.com.syntagma.esphora.conector.servicios.WsfeService;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;

import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEReq;
import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEResponse;
import fex.dif.afip.gov.ar.ClsFEXGetCMP;

@Name("feConsultaCAERequestController")
public class FEConsultaCAERequestController {

	private FEConsultaCAEReq feConsultaCAEReq;
	private long cuit;
	@Out(required=false)
	private FEConsultaCAEResponse feConsultaCAEResponse;
	
	public FEConsultaCAERequestController() {
		super();
		feConsultaCAEReq = new FEConsultaCAEReq();
	}
	
	public FEConsultaCAEReq getFeConsultaCAEReq() {
		return feConsultaCAEReq;
	}
	public void setFeConsultaCAEReq(FEConsultaCAEReq feConsultaCAEReq) {
		this.feConsultaCAEReq = feConsultaCAEReq;
	}
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
		
		feConsultaCAEReq.setCuitEmisor(cuit);
		feConsultaCAEResponse = port.feConsultaCAERequest(feConsultaCAEReq,cuit);
		
	}
}
