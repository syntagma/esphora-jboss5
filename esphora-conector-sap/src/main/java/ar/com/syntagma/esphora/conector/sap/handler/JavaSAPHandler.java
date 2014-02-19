package ar.com.syntagma.esphora.conector.sap.handler;

import org.apache.log4j.Logger;

import ar.com.syntagma.esphora.conector.sap.control.InvocadorControl;
import ar.com.syntagma.esphora.conector.sap.control.SapControl;
import ar.com.syntagma.esphora.conector.sap.parameter.SapParameter;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.server.JCoServerContext;
import com.sap.conn.jco.server.JCoServerFunctionHandler;


/**
 * Maneja el pedido de SAP
 * 
 *
 */
public class JavaSAPHandler implements JCoServerFunctionHandler
{

	final static Logger logger = Logger.getLogger(SapControl.class);

    public void handleRequest(JCoServerContext serverCtx, JCoFunction function)
    {	
		System.out.println("Funcion que ejecuto: " + function.getName());
		//manejo de la RFC de factura de EXPO de SAP
		if(function.getName().equals(SapParameter.RFC_FUNCTION_1)){
			
			logger.info("SE EJECUTO LA RFC PARA FACTURA ELECTRONICA");
			InvocadorControl.sendComprobantes(function);
			logger.info("Finalizo con exito el llamado a la RFC");
		} else {
			//manejo de la RFC de factura de LOCAL de SAP
			if (function.getName().equals(SapParameter.RFC_FUNCTION_2)) {
    			logger.info("SE EJECUTO LA RFC PARA FACTURA ELECTRONICA LOCAL");
    			InvocadorControl.sendLocalComprobante(function);
    			logger.info("Finalizo con exito el llamado a la RFC DE FACTURA ELECTRONICA LOCAL");
    			//manejo de la RFC de factura de LOCAL v1 de SAP
			} else {
    			if (function.getName().equals(SapParameter.RFC_FUNCTION_3)) {
        			logger.info("SE EJECUTO LA RFC PARA FACTURA ELECTRONICA LOCAL V1");
        			InvocadorControl.sendLocalComprobantev1(function);
        			logger.info("Finalizo con exito el llamado a la RFC DE FACTURA ELECTRONICA LOCAL V1");
				} else {
						if (function.getName().equals(SapParameter.RFC_FUNCTION_LAST_CMP_EXPO)) {
			    			logger.info("SE EJECUTO LA RFC PARA OBTENER ULTIMO CMP DE FACTURA ELECTRONICA EXPO");
			    			InvocadorControl.getNumCMPExpo(function);
			    			logger.info("Finalizo con exito el llamado a la RFC PARA OBTENER ULTIMO CMP DE FACTURA ELECTRONICA EXPO");
		    			} else {
		    				if (function.getName().equals(SapParameter.RFC_FUNCTION_LAST_CMP_LOCAL)) {
		    	    			logger.info("SE EJECUTO LA RFC PARA OBTENER ULTIMO CMP DE FACTURA ELECTRONICA LOCAL");
		    	    			InvocadorControl.getNumCMPLocal(function);
		    	    			logger.info("Finalizo con exito el llamado a la RFC PARA OBTENER ULTIMO CMP DE FACTURA ELECTRONICA LOCAL");
		        			}
		    			}
					}
				}
		    } 
    	}

}
