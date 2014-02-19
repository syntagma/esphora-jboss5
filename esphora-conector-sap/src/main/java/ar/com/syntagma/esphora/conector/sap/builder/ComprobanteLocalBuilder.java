package ar.com.syntagma.esphora.conector.sap.builder;

import org.apache.log4j.Logger;

import ar.com.syntagma.esphora.conector.sap.converter.TablaConverter;
import ar.com.syntagma.esphora.conector.sap.parameter.SapParameter;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

import facturaelectronica.dif.afip.gov.ar.ArrayOfFEDetalleRequest;
import facturaelectronica.dif.afip.gov.ar.ArrayOfFEDetalleResponse;
import facturaelectronica.dif.afip.gov.ar.FECabeceraResponse;
import facturaelectronica.dif.afip.gov.ar.FEDetalleRequest;
import facturaelectronica.dif.afip.gov.ar.FEDetalleResponse;
import facturaelectronica.dif.afip.gov.ar.FERequest;
import facturaelectronica.dif.afip.gov.ar.FEResponse;
import facturaelectronica.dif.afip.gov.ar.VError;

public class ComprobanteLocalBuilder {
	final static Logger logger = Logger.getLogger(ComprobanteLocalBuilder.class);

	/**
	 * Genera el comprobante de factuar local para el WS a partir de las tablas pasadas por SAP
	 * 
	 * @param function
	 * @return
	 */
	public FERequest comprobanteLocalMaker (JCoFunction function) {
		FERequest comprobante = new FERequest();
		//Recupera y setea la cabecera
		JCoTable tableCabecera = function.getTableParameterList().getTable(SapParameter.TABLA_L_COMPROBANTE);
		comprobante.setFecr(TablaConverter.tableComprobanteLocal(tableCabecera));
		//Recupera y setea el detalle
		JCoTable tableDetalle = function.getTableParameterList().getTable(SapParameter.TABLA_DETAIL_L);
		comprobante.setFedr(getDetallesComprobanteLocal(tableDetalle));
				
		return comprobante;
		
	}
	
	/**
	 * Devuelve la lista de detalles pasada en la tabla de SAP
	 * 
	 * @param tableDetalle
	 * @return
	 */
	public  ArrayOfFEDetalleRequest getDetallesComprobanteLocal (JCoTable tableDetalle) {
		ArrayOfFEDetalleRequest detalles = new ArrayOfFEDetalleRequest(); 
				
		if (!tableDetalle.isEmpty()) {
			//detalles.getFEDetalleRequest()  = new FEDetalleRequest[tableDetalle.getNumRows()];
			tableDetalle.firstRow();
			do {
				FEDetalleRequest detalle = TablaConverter.detalleComprobanteLocal(tableDetalle);
				detalles.getFEDetalleRequest().add(detalle);
			}while (tableDetalle.nextRow());
		}
		return detalles;
	}	

	/**
	 * Convierte los datos devuletos por el WS y los setea en la tablas de vuelta de SAP
	 * 
	 * @param function
	 * @param response
	 */
	public void makeFacturaLocalAnswer (JCoFunction function, FEResponse response) {
		JCoTable tableResultCabecera = function.getTableParameterList().getTable(
																			SapParameter.T_RESULT_CBTE_LOCAL);
		FECabeceraResponse cabecera = response.getFecResp();
		tableResultCabecera.appendRow();
		if (cabecera != null) {
			logger.info("Llenando la cabecera...");
			tableResultCabecera.setValue(SapParameter.T_RESULT_CBTE_LOCAL_CANT_REG, cabecera.getCantidadreg());
			tableResultCabecera.setValue(SapParameter.T_RESULT_CBTE_LOCAL_CUIT, cabecera.getCuit());
			tableResultCabecera.setValue(SapParameter.T_RESULT_CBTE_LOCAL_FCH_CAE, cabecera.getFechaCae());
			tableResultCabecera.setValue(SapParameter.T_RESULT_CBTE_LOCAL_ID, cabecera.getId());
			tableResultCabecera.setValue(SapParameter.T_RESULT_CBTE_LOCAL_MOTIVO, cabecera.getMotivo());
			tableResultCabecera.setValue(SapParameter.T_RESULT_CBTE_LOCAL_PRESTA_SERV, cabecera.getPrestaServ());
			tableResultCabecera.setValue(SapParameter.T_RESULT_CBTE_LOCAL_REPROCESO, cabecera.getReproceso());
			tableResultCabecera.setValue(SapParameter.T_RESULT_CBTE_LOCAL_RESULT, cabecera.getResultado());
			logger.info("Cabecera cargada, se procede a cargar el detalle");
			if (response.getFedResp() != null) {
				addDetalle(function, response.getFedResp(), response.getFecResp().getId());
			} else {
				logger.info("No hay detalle");
			}
		}
		//Seteo el error
		VError error = response.getRError();
		logger.info("Se setea el error...");
		tableResultCabecera.setValue(SapParameter.T_RESULT_CBTE_LOCAL_ERROR_COD, error.getPercode());
		tableResultCabecera.setValue(SapParameter.T_RESULT_CBTE_LOCAL_ERROR_MSG, error.getPerrmsg());
		logger.info("Error cargado");
				
	}
	
	/**
	 * Agrega el detalle a la respuesta de la factura local
	 * 
	 * @param function
	 * @param tableDetallesResultado
	 */
	private void addDetalle (JCoFunction function, ArrayOfFEDetalleResponse detalles, Long id) {
		JCoTable tableResultDetalle = function.getTableParameterList().getTable(SapParameter.T_RESULT_DETALLE);
		//Recorro la lista de detalles pasada por el WS de la AFIP y los seteo en las tablas de retorno de SAP
		for (FEDetalleResponse elemento: detalles.getFEDetalleResponse()) {
			logger.info("Agregando el detalle "  + elemento.getCbtDesde());
			tableResultDetalle.appendRow();
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_ID, id);
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_CAE, elemento.getCae());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_CBTE_DESDE, elemento.getCbtDesde());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_CBTE_HASTA, elemento.getCbtHasta());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_FCH_CBTE, elemento.getFechaCbte());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_FCH_SERV_DESDE, elemento.getFechaServDesde());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_FCH_SERV_HASTA, elemento.getFechaServHasta());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_FCH_VENC_PAGO, elemento.getFechaVencPago());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_FCH_VTO, elemento.getFechaVto());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_IMP_NETO, elemento.getImpNeto());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_IMP_OP_EX, elemento.getImpOpEx());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_IMP_TOT_CONC, elemento.getImpTotConc());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_IMP_TOTAL, elemento.getImpTotal());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_IMPTO_LIQ, elemento.getImptoLiq());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_IMPTO_LIQ_RNI, elemento.getImptoLiqRni());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_MOTIVO, elemento.getMotivo());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_NRO_DOC, elemento.getNroDoc());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_PTO_VTA, elemento.getPuntoVta());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_RESULTADO, elemento.getResultado());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_TIPO_CBTE, elemento.getTipoCbte());
			tableResultDetalle.setValue(SapParameter.T_RESULT_DETALLE_TIPO_DOC, elemento.getTipoDoc());
			logger.info("Se agrego el detalle "  + elemento.getCbtDesde());
		}
		logger.info("Detalles agregados");
	}
	
	
}
