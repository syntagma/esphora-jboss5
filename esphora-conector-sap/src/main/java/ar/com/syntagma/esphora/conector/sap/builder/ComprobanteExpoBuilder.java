package ar.com.syntagma.esphora.conector.sap.builder;

import org.apache.log4j.Logger;

import ar.com.syntagma.esphora.conector.sap.converter.TablaConverter;
import ar.com.syntagma.esphora.conector.sap.parameter.SapParameter;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

import fex.dif.afip.gov.ar.ArrayOfCmpAsoc;
import fex.dif.afip.gov.ar.ArrayOfItem;
import fex.dif.afip.gov.ar.ArrayOfPermiso;
import fex.dif.afip.gov.ar.ClsFEXRequest;
import fex.dif.afip.gov.ar.CmpAsoc;
import fex.dif.afip.gov.ar.FEXResponseAuthorize;
import fex.dif.afip.gov.ar.Item;
import fex.dif.afip.gov.ar.Permiso;

public class ComprobanteExpoBuilder {
	final static Logger logger = Logger.getLogger(ComprobanteExpoBuilder.class);

	/**
	 * Genera el comprobante para el WS interpretando las tablas pasadas por SAP
	 * 
	 * @param function es la RFC ejecutada por SAP que contiene las tablas
	 * @return ClsFEXRequest
	 */
	public ClsFEXRequest comprobanteExpoMaker (JCoFunction function) {
		ClsFEXRequest comprobante;
		JCoTable tablaComprobante = function.getTableParameterList().getTable(SapParameter.TABLA_COMPROBANTE);
		tablaComprobante.firstRow();
		//Creo la cabecera del comprobante
		comprobante = TablaConverter.converteTableComprobanteExpo(tablaComprobante);
		//Le agrego los permisos
		JCoTable tablapermisos = function.getTableParameterList().getTable(SapParameter.TABLA_PERMISOS);
		comprobante.setPermisos(getPermisos(tablapermisos));
		//Le agrego los items
		JCoTable tablaItems = function.getTableParameterList().getTable(SapParameter.TABLA_ITEMS);
		comprobante.setItems(getItems(tablaItems));
		//Le agrego los Comprobantes acosiados
		JCoTable tablaComprobanteAsoc = function.getTableParameterList().getTable(SapParameter.TABLA_CMPS_ASOC);
		comprobante.setCmpsAsoc(getComprobantesAsociados(tablaComprobanteAsoc));
		
		logger.info("Se convirtio los datos con exito");
		
		return comprobante;
	}

	/**
	 * Devuelve la lista de Permisos a partir de la tabla pasada por SAP
	 * 
	 * @param function
	 * @return
	 */
	private ArrayOfPermiso getPermisos (JCoTable tablapermisos) {
		ArrayOfPermiso permisos = null;
		
		if (!tablapermisos.isEmpty()) {
			tablapermisos.firstRow();
			do {
				if (permisos == null) permisos = new ArrayOfPermiso();	
				{
					Permiso permiso = TablaConverter.converterTablePermiso(tablapermisos);
					permisos.getPermiso().add(permiso);
				}
			}while (tablapermisos.nextRow());
		}
		return permisos;
	}

	/**
	 * Devuelve la lista de Items a partir de la tabla pasada por SAP
	 * 
	 * @param tablaItems
	 * @return
	 */
	private ArrayOfItem getItems (JCoTable tablaItems) {
		ArrayOfItem items = null; 
		
		if (!tablaItems.isEmpty()) {
			tablaItems.firstRow();
			do {
				if (items == null) items = new ArrayOfItem();	
				{
					Item item = TablaConverter.converterTableItems(tablaItems);
					items.getItem().add(item);
				}
			}while (tablaItems.nextRow());
		}
		return items;
	}
	
	
	/**
	 * Devuelve la lista de comprobantes asociados a partir de la tabla pasada por SAP
	 * 
	 * @param tablaCompAsoc
	 * @return
	 */
	private ArrayOfCmpAsoc getComprobantesAsociados (JCoTable tablaCompAsoc) {
		ArrayOfCmpAsoc cmpAsocs = null; 
		
		if (!tablaCompAsoc.isEmpty()) {
			tablaCompAsoc.firstRow();
			do {
				if (cmpAsocs == null) cmpAsocs = new ArrayOfCmpAsoc();	
				{
					CmpAsoc item = TablaConverter.converterTableComproAsoc(tablaCompAsoc);
					cmpAsocs.getCmpAsoc().add(item);
				}
			}while (tablaCompAsoc.nextRow());
		}
		return cmpAsocs;
	}
	
	/**
	 * Carga los datos devueltos de la WS en la tabla result para SAP
	 * 
	 * @param function
	 * @param response
	 * 
	 */
	public void makeAnswer (JCoFunction function, FEXResponseAuthorize response) {
		JCoTable tablaResultado = function.getTableParameterList().getTable(SapParameter.TABLA_RESULTADO);
    	tablaResultado.appendRow();
    	//Seteo la respuesta
    	tablaResultado.setValue(SapParameter.TABLA_RESULTADO_ID, response.getFEXResultAuth().getId());
    	if (response.getFEXResultAuth().getCae() != null) {
    		tablaResultado.setValue(SapParameter.TABLA_RESULTADO_CAE, response.getFEXResultAuth().getCae());
    		tablaResultado.setValue(SapParameter.TABLA_RESULTADO_CUIT, response.getFEXResultAuth().getCuit());
    		tablaResultado.setValue(
    				SapParameter.TABLA_RESULTADO_FECHA_COMPROBANTE,response.getFEXResultAuth().getFchCbte());
    		tablaResultado.setValue(
    				SapParameter.TABLA_RESULTADO_FECHA_VENC_CAE,response.getFEXResultAuth().getFchVencCae());
    		tablaResultado.setValue(
    				SapParameter.TABLA_RESULTADO_MOTIVOS_OBS, response.getFEXResultAuth().getMotivosObs());
    		tablaResultado.setValue(
    				SapParameter.TABLA_RESULTADO_REPROCESO, response.getFEXResultAuth().getReproceso());
    		tablaResultado.setValue(
    				SapParameter.TABLA_RESULTADO_RESULTADO, response.getFEXResultAuth().getResultado());
    	} 
    	//Seteo los errores
    	if (response.getFEXErr() != null) {
	    	tablaResultado.setValue(SapParameter.TABLA_RESULTADO_ERRO_COD, response.getFEXErr().getErrCode());
	    	String errMsg = response.getFEXErr().getErrMsg();
	    	if (errMsg != null) {
	    		logger.info("Msg de Error: " + errMsg);
		    	if (errMsg.length() > SapParameter.LENGTH_ERR_MSG)
		    		errMsg = errMsg.substring(0, SapParameter.LENGTH_ERR_MSG-1);
		    	tablaResultado.setValue(SapParameter.TABLA_RESULTADO_ERRO_DESC, errMsg);
	    	}
    	}  else {
    		throw new RuntimeException();
    	}
    	//Seteo los eventos
    	if(response.getFEXEvents() != null) {
	    	tablaResultado.setValue(SapParameter.TABLA_RESULTADO_EVENT_COD, response.getFEXEvents().getEventCode());
	    	String eventMsg = response.getFEXEvents().getEventMsg();
		    if(eventMsg != null) {
	    		if (eventMsg.length() > SapParameter.LENGTH_EVENT_MSG)
		    		eventMsg = eventMsg.substring(0, SapParameter.LENGTH_EVENT_MSG-1);
		    	tablaResultado.setValue(SapParameter.TABLA_RESULTADO_EVENT_DESC, eventMsg);
		    }
    	}
    	
	}
	
}
