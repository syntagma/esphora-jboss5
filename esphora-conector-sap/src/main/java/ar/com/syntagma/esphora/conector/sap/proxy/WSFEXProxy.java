package ar.com.syntagma.esphora.conector.sap.proxy;

import org.apache.log4j.Logger;

import fex.dif.afip.gov.ar.ClsFEXOutAuthorize;
import fex.dif.afip.gov.ar.ClsFEXRequest;
import fex.dif.afip.gov.ar.FEXResponseAuthorize;
import fex.dif.afip.gov.ar.FEXResponseLastCMP;
import ar.com.syntagma.esphora.conector.sap.factory.WSFactory;
import ar.com.syntagma.esphora.conector.servicios.Wsfex;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

public class WSFEXProxy {
	public static WsfexService wsfexService;
	static final Logger logger = Logger.getLogger(WSFEXProxy.class);

	public WSFEXProxy() {
		wsfexService = WSFactory.createWSFEX();
	}

	/**
	 * Consume el metodo FEXAuthorize de WS y retorna la respuesta
	 * 
	 * @param request El comprobante ya cargado con todos los datos
	 * @return
	 */
	public FEXResponseAuthorize sendComprobante (ClsFEXRequest request, Long cuit) {
		FEXResponseAuthorize response = null;
		 Wsfex wsfex = wsfexService.getWsfexPort();
		logger.info("Se comienza a consumir el WS...");
		//Consume el WS de Syntagma
		response = wsfex.fexAuthorize(request, cuit.longValue());
		logger.info("Se recibio la respuesta");
		
		ClsFEXOutAuthorize result = response.getFEXResultAuth();
		//Si no devolvio resultado lo creo
		if (result == null) {
			result = new ClsFEXOutAuthorize();
		}
		//Sobreescribo siempre el id devuelto haya o no venido respuesta
		result.setId(request.getId());
		response.setFEXResultAuth(result);
		
		
		return response;
	}

	/**
	 * Consume el metodo FEXGetLast_CMP del WS y retorna la respuesta
	 * 
	 * @param pto_vta
	 * @param tipo_cbte
	 * @param cuit
	 * @return
	 */
	public FEXResponseLastCMP getLastCMPExpo (short pto_vta, short tipo_cbte, long cuit) {
		FEXResponseLastCMP response = null;
		
		Wsfex wsfex;
		wsfex = wsfexService.getWsfexPort();
		//Consume el WS de Syntagma
		response = wsfex.fexGetLastCMP(pto_vta, tipo_cbte, cuit);
		
		return response;
	}
	
	/**
	 * Recupera el ultimo numero de cbte y se lo setea + 1 al comprobante a enviar
	 * 
	 * @param request
	 * @param cuit
	 * @return
	 */
	public ClsFEXRequest setNumCbte (ClsFEXRequest request, long cuit){
		
		long cbteNum = getLastCMPExpo(request.getPuntoVta(), request.getTipoCbte(), cuit).
																		getFEXResultLastCMP().getCbteNro();
		cbteNum++;
		request.setCbteNro(cbteNum);
		return request;
	}

}
