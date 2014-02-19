package ar.com.syntagma.esphora.conector.sap.proxy;

import org.apache.log4j.Logger;

import facturaelectronica.dif.afip.gov.ar.FECabeceraResponse;
import facturaelectronica.dif.afip.gov.ar.FERecuperaLastCMPResponse;
import facturaelectronica.dif.afip.gov.ar.FERequest;
import facturaelectronica.dif.afip.gov.ar.FEResponse;
import ar.com.syntagma.esphora.conector.sap.factory.WSFactory;
import ar.com.syntagma.esphora.conector.servicios.Wsfe;
import ar.com.syntagma.esphora.conector.servicios.WsfeService;

public class WSFEProxy {
	public static WsfeService wsfeService;
	static final Logger logger = Logger.getLogger(WSFEProxy.class);

	public WSFEProxy() {
		wsfeService = WSFactory.createWSFE();
	}

	/**
	 * Consume el metodo FEAutRequest del WS y retorna la respuesta
	 * 
	 * @param request
	 * @param cuit
	 * @return
	 */
	public FEResponse sendFacturaLocal (FERequest request, Long cuit) {
		FEResponse response = null;
		
		Wsfe wsfe = wsfeService.getWsfePort();
		logger.info("Se comienza a consumir el WS...");
		//Consume el WS de Syntagma
		response = wsfe.feAutRequest(request, cuit);
		FECabeceraResponse cabeceraResult = response.getFecResp();
		if (cabeceraResult == null) {
			cabeceraResult = new FECabeceraResponse();
		} 
		cabeceraResult.setId(request.getFecr().getId());
		response.setFecResp(cabeceraResult);
		
		return response;
	}

	/**
	 * Consume el metodo FERecuperaLastCMPRequest del WS y retorna la respuesta
	 * 
	 * @param pto_vta
	 * @param tipo_cbte
	 * @param cuit
	 * @return
	 */
	public FERecuperaLastCMPResponse getLastCMPLocal (int pto_vta, int tipo_cbte, long cuit) {
		FERecuperaLastCMPResponse response = null;
			
		Wsfe wsfe = wsfeService.getWsfePort();
		//Consume el WS de Syntagma
		response = wsfe.feRecuperaLastCMPRequest(pto_vta, tipo_cbte, cuit);
		
		return response;
	}
	
}
