package ar.com.syntagma.esphora.facturalocal.control;

import java.io.Serializable;

import ar.com.syntagma.esphora.conector.servicios.Wsfe;
import ar.com.syntagma.esphora.conector.servicios.WsfeService;

import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Out;
import org.jboss.seam.log.Log;

import facturaelectronica.dif.afip.gov.ar.FECabeceraRequest;
import facturaelectronica.dif.afip.gov.ar.FERequest;
import facturaelectronica.dif.afip.gov.ar.FEResponse;

@Name("feAutRequestController")
public class FEAutRequestController implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = -5005279101385041389L;
	private long id;
	private long cuit;
	@Out(required = false)
	private FEResponse feResponse;

	@Logger
	Log log;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

		service = new WsfeService();
		port = service.getWsfePort();

		FERequest fer = new FERequest();
		FECabeceraRequest fecr = new FECabeceraRequest();
		fecr.setId(id);
		fer.setFecr(fecr);
		//feResponse.getFedResp().getFEDetalleResponse().get(0).getCbtDesde()
		feResponse = port.feAutRequest(fer, cuit);

	}


}
