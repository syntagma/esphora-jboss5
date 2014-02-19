package ar.com.syntagma.esphora.conector.sap.proxy;

import org.apache.log4j.Logger;

import fev1.dif.afip.gov.ar.FECAECabResponse;
import fev1.dif.afip.gov.ar.FECAERequest;
import fev1.dif.afip.gov.ar.FECAEResponse;
import fev1.dif.afip.gov.ar.FECompConsultaReq;
import fev1.dif.afip.gov.ar.FECompConsultaResponse;
import ar.com.syntagma.esphora.conector.sap.factory.WSFactory;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1Service;

public class WSFEv1Proxy {
	public static Wsfev1Service wsfev1Service;
	static final Logger logger = Logger.getLogger(WSFEv1Proxy.class);

	public WSFEv1Proxy() {
		wsfev1Service = WSFactory.createWSFEv1();
	}

	/**
	 * Consume el metodo fecaeSolicitar del WS y retorna la respuesta
	 * 
	 * @param FECAERequest request
	 * @param Long cuit
	 * @return FECAEResponse
	 */
	public FECAEResponse sendFacturaLocal (FECAERequest request, Long cuit) {
		FECAEResponse response = null;
		
		Wsfev1 wsfev1 = wsfev1Service.getWsfev1Port();
		logger.info("Se comienza a consumir el WS...");
		//Consume el WS de Syntagma
		response = wsfev1.fecaeSolicitar(request, cuit);
		FECAECabResponse cabeceraResult = response.getFeCabResp();
		if (cabeceraResult == null) {
			cabeceraResult = new FECAECabResponse();
		} 
		return response;
	}

	/**
	 * Consume el metodo feCompConsultar del WS y retorna la respuesta
	 * 
	 * @param pto_vta
	 * @param tipo_cbte
	 * @param numero
	 * @param cuit
	 * @return
	 */
	public FECompConsultaResponse getComprobante (int pto_vta, int tipo_cbte,long numero, long cuit) {
		FECompConsultaResponse response = null;
			
		Wsfev1 wsfev1 = wsfev1Service.getWsfev1Port();
		//Consume el WS de Syntagma
		FECompConsultaReq feCompConsultaReq = new FECompConsultaReq();
		feCompConsultaReq.setPtoVta(pto_vta);
		feCompConsultaReq.setCbteTipo(tipo_cbte);
		feCompConsultaReq.setCbteNro(numero);
		response = wsfev1.feCompConsultar(feCompConsultaReq, cuit);
		
		return response;
	}
	
}
