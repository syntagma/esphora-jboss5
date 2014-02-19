package ar.com.syntagma.esphora.conector.sap.control;

import org.apache.log4j.Logger;

import ar.com.syntagma.esphora.conector.sap.builder.ComprobanteExpoBuilder;
import ar.com.syntagma.esphora.conector.sap.builder.ComprobanteLocalBuilder;
import ar.com.syntagma.esphora.conector.sap.builder.ComprobanteLocalv1Builder;
import ar.com.syntagma.esphora.conector.sap.parameter.SapParameter;
import ar.com.syntagma.esphora.conector.sap.proxy.WSFEProxy;
import ar.com.syntagma.esphora.conector.sap.proxy.WSFEXProxy;
import ar.com.syntagma.esphora.conector.sap.proxy.WSFEv1Proxy;

import com.sap.conn.jco.JCoFunction;

import facturaelectronica.dif.afip.gov.ar.FERecuperaLastCMPResponse;
import facturaelectronica.dif.afip.gov.ar.FERequest;
import facturaelectronica.dif.afip.gov.ar.FEResponse;
import fev1.dif.afip.gov.ar.FECAERequest;
import fev1.dif.afip.gov.ar.FECAEResponse;
import fex.dif.afip.gov.ar.ClsFEXRequest;
import fex.dif.afip.gov.ar.FEXResponseAuthorize;
import fex.dif.afip.gov.ar.FEXResponseLastCMP;

public class InvocadorControl {
	
	final static Logger logger = Logger.getLogger(InvocadorControl.class);
	private static WSFEProxy wsfe = new WSFEProxy();
	private static WSFEXProxy wsfex = new WSFEXProxy();
	private static WSFEv1Proxy wsfev1 = new WSFEv1Proxy();
	

    /**
     * Recupera el comprobante de las tablas que envía SAP, con esos datos genera el objeto que será enviado
     * por el WS, recibe la respuesta y la guarda en la lista de las respuestas.
     * 
     * @param function
     */
    public static FEXResponseAuthorize sendComprobantes (JCoFunction function) {
    	ComprobanteExpoBuilder builder = new ComprobanteExpoBuilder();
    	Long cuit = function.getImportParameterList().getLong(SapParameter.NUMERO_CUIT);
    	
    	ClsFEXRequest request = builder.comprobanteExpoMaker(function);
    	
    	FEXResponseAuthorize response = wsfex.sendComprobante(request, cuit);
    	
    	logger.info("Recibio la factura de EXPO se procede a realizar la conversion de los datos para SAP...");
    	
    	builder.makeAnswer(function, response);
    	
    	return response;
    }
    
    /**
     * Recupera la factura local de las tablas que envía SAP, con esos datos genera el objeto que será enviado
     * por el WS, recibe la respuesta y devulve la respuesta.
     * 
     * @param function
     */
    public static void sendLocalComprobante (JCoFunction function) {
    	ComprobanteLocalBuilder builder = new ComprobanteLocalBuilder();
    	Long cuit = function.getImportParameterList().getLong(SapParameter.NUMERO_CUIT);
    	FERequest request = builder.comprobanteLocalMaker(function);
    	
    	FEResponse response = wsfe.sendFacturaLocal(request, cuit);
    	logger.info("Recibio la factura LOCAL se procede a realizar la conversion de los datos para SAP...");
    	builder.makeFacturaLocalAnswer(function, response);
    	
    }

    /**
     * Recupera la factura local v1 de las tablas que envía SAP, con esos datos genera el objeto que será enviado
     * por el WS, recibe la respuesta y devulve la respuesta.
     * 
     * @param function
     */
    public static void sendLocalComprobantev1 (JCoFunction function) {
    	ComprobanteLocalv1Builder builder = new ComprobanteLocalv1Builder();
    	Long cuit = function.getImportParameterList().getLong(SapParameter.NUMERO_CUIT);
    	FECAERequest request = builder.comprobanteLocalv1Maker(function);
    	
    	FECAEResponse response = wsfev1.sendFacturaLocal(request, cuit);
    	logger.info("Recibio la factura LOCAL V1 se procede a realizar la conversion de los datos para SAP...");
    	builder.makeFacturaLocalv1Answer(function, response);
    	
    }
 
    /**
     * Se recuperan los 3 parametros enviados por SAP solicitados por el WS para devolver el ultimo numero
     * de comprobante
     * 
     * @param function
     */
    public static void getNumCMPLocal (JCoFunction function) {
    	Long cuit = function.getImportParameterList().getLong(SapParameter.NUMERO_CUIT);
    	int pto_vta = function.getImportParameterList().getInt(SapParameter.RFC_PARAMETER_LOCAL_NCMP_PTO_VTA);
    	int tipo_cbte = function.getImportParameterList().getInt(SapParameter.RFC_PARAMETER_LOCAL_NCMP_TIPO_CBTE);
    	
    	FERecuperaLastCMPResponse response = wsfe.getLastCMPLocal(pto_vta, tipo_cbte, cuit);
    	
    }
  
    /**
     * Se recuperan los 3 parametros enviados por SAP solicitados por el WS para devolver el ultimo numero
     * de comprobante
     * 
     * @param function
     */
    public static void getNumCMPExpo (JCoFunction function) {
    	Long cuit = function.getImportParameterList().getLong(SapParameter.NUMERO_CUIT);
    	short pto_vta = function.getImportParameterList().getShort(SapParameter.RFC_PARAMETER_EXPO_NCMP_PTO_VTA);
    	short tipo_cbte = function.getImportParameterList().getShort(SapParameter.RFC_PARAMETER_EXPO_NCMP_TIPO_CBTE);
    	
    	FEXResponseLastCMP response = wsfex.getLastCMPExpo(pto_vta, tipo_cbte, cuit);
    	
    }

}
