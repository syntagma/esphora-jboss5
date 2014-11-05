package ar.com.syntagma.esphora.conector.sap.builder;

import org.apache.log4j.Logger;

import ar.com.syntagma.esphora.conector.sap.converter.TablaConverter;
import ar.com.syntagma.esphora.conector.sap.parameter.SapParameter;

import com.sap.conn.jco.JCoFunction;
import com.sap.conn.jco.JCoTable;

import fev1.dif.afip.gov.ar.AlicIva;
import fev1.dif.afip.gov.ar.ArrayOfAlicIva;
import fev1.dif.afip.gov.ar.ArrayOfCbteAsoc;
import fev1.dif.afip.gov.ar.ArrayOfFECAEDetRequest;
import fev1.dif.afip.gov.ar.ArrayOfFECAEDetResponse;
import fev1.dif.afip.gov.ar.ArrayOfOpcional;
import fev1.dif.afip.gov.ar.ArrayOfTributo;
import fev1.dif.afip.gov.ar.CbteAsoc;
import fev1.dif.afip.gov.ar.Err;
import fev1.dif.afip.gov.ar.FECAECabResponse;
import fev1.dif.afip.gov.ar.FECAEDetRequest;
import fev1.dif.afip.gov.ar.FECAEDetResponse;
import fev1.dif.afip.gov.ar.FECAERequest;
import fev1.dif.afip.gov.ar.FECAEResponse;
import fev1.dif.afip.gov.ar.Obs;
import fev1.dif.afip.gov.ar.Opcional;
import fev1.dif.afip.gov.ar.Tributo;

public class ComprobanteLocalv1Builder {
	final static Logger logger = Logger
			.getLogger(ComprobanteLocalv1Builder.class);

	/**
	 * Genera el comprobante de factuar local V1 para el WS a partir de las
	 * tablas pasadas por SAP
	 * 
	 * @param function
	 * @return
	 */
	public FECAERequest comprobanteLocalv1Maker(JCoFunction function) {
		FECAERequest comprobante = new FECAERequest();
		// Recupera y setea la cabecera
		JCoTable tableCabecera = function.getTableParameterList().getTable(
				SapParameter.TABLA_T_FECABREQ);
		comprobante.setFeCabReq(TablaConverter
				.tableComprobanteLocalv1(tableCabecera));
		// Recupera y setea el detalle
		JCoTable tableDetalle = function.getTableParameterList().getTable(
				SapParameter.TABLA_T_FEDETREQ);
		comprobante.setFeDetReq(getDetallesComprobanteLocalv1(function,
				tableDetalle));

		return comprobante;

	}

	/**
	 * Devuelve la lista de detalles pasada en la tabla de SAP
	 * 
	 * @param tableDetalle
	 * @return
	 */
	public ArrayOfFECAEDetRequest getDetallesComprobanteLocalv1(
			JCoFunction function, JCoTable tableDetalle) {
		ArrayOfFECAEDetRequest detalles = new ArrayOfFECAEDetRequest();

		if (!tableDetalle.isEmpty()) {
			// detalles.getFEDetalleRequest() = new
			// FEDetalleRequest[tableDetalle.getNumRows()];
			tableDetalle.firstRow();
			do {
				FECAEDetRequest detalle = TablaConverter
						.detalleComprobanteLocalv1(tableDetalle);
				detalle.setCbtesAsoc(getCbtesAsoc(function
						.getTableParameterList().getTable(
								SapParameter.TABLA_T_CBTESASOC), detalle.getCbteDesde()));
				detalle.setTributos(getTributos(function
						.getTableParameterList().getTable(
								SapParameter.TABLA_T_TRIBUTOS), detalle.getCbteDesde()));
				detalle.setIva(getIva(function.getTableParameterList()
						.getTable(SapParameter.TABLA_T_IVA), detalle.getCbteDesde()));
				detalle.setOpcionales(getOpcionales(function
						.getTableParameterList().getTable(
								SapParameter.TABLA_T_OPCIONALES), detalle.getCbteDesde()));
				detalles.getFECAEDetRequest().add(detalle);
			} while (tableDetalle.nextRow());
		}
		return detalles;
	}

	public ArrayOfCbteAsoc getCbtesAsoc(JCoTable tableCbtesAsoc, Long cbtDesde) {
		ArrayOfCbteAsoc cbtesAsoc = null;
		if (!tableCbtesAsoc.isEmpty()) {
			
			tableCbtesAsoc.firstRow();
			do {
				if (tableCbtesAsoc.getLong(SapParameter.TABLA_T_CBTESASOC_CBT_DESDE)==cbtDesde)
				{
					if (cbtesAsoc == null) cbtesAsoc = new ArrayOfCbteAsoc();	
					CbteAsoc detalle = TablaConverter
							.CbteAsocLocalv1(tableCbtesAsoc);
					cbtesAsoc.getCbteAsoc().add(detalle);
				}
			} while (tableCbtesAsoc.nextRow());
		}

		return cbtesAsoc;
	}

	public ArrayOfTributo getTributos(JCoTable tableTributos, Long cbtDesde) {
		ArrayOfTributo tributos = null;
		if (!tableTributos.isEmpty()) {
			tableTributos.firstRow();
			do {
				if (tableTributos.getLong(SapParameter.TABLA_T_TRIBUTOS_CBT_DESDE)==cbtDesde)
				{
					if (tributos == null) tributos = new ArrayOfTributo();
					Tributo tributo = TablaConverter.TributosLocalv1(tableTributos);
					tributos.getTributo().add(tributo);
				}
			} while (tableTributos.nextRow());
		}

		return tributos;
	}

	public ArrayOfAlicIva getIva(JCoTable tableIva, Long cbtDesde) {
		ArrayOfAlicIva ivas = null;
		if (!tableIva.isEmpty()) {
			tableIva.firstRow();
			do {
				if (tableIva.getLong(SapParameter.TABLA_T_IVA_CBT_DESDE)==cbtDesde)
				{	
					if (ivas == null) ivas = new ArrayOfAlicIva();
					AlicIva iva = TablaConverter.IvaLocalv1(tableIva);
					ivas.getAlicIva().add(iva);
				}
			} while (tableIva.nextRow());
		}

		return ivas;
	}

	public ArrayOfOpcional getOpcionales(JCoTable tableOpcionales, Long cbtDesde) {
		ArrayOfOpcional opcionales = null;
		if (!tableOpcionales.isEmpty()) {
			tableOpcionales.firstRow();
			do {
				if (tableOpcionales.getLong(SapParameter.TABLA_T_OPCIONALES_CBT_DESDE)==cbtDesde)
				{	
					if (opcionales == null) opcionales = new ArrayOfOpcional();
					Opcional opcional = TablaConverter
							.OpcionalesLocalv1(tableOpcionales);
					opcionales.getOpcional().add(opcional);
				}	
			} while (tableOpcionales.nextRow());
		}

		return opcionales;
	}

	/**
	 * Convierte los datos devuletos por el WS y los setea en la tablas de
	 * vuelta de SAP
	 * 
	 * @param function
	 * @param response
	 */
	public void makeFacturaLocalv1Answer(JCoFunction function,
			FECAEResponse response) {
		// TODO Cambiar la funcionalidad local por local v1
		if (response.getFeCabResp() != null) {
			JCoTable tableResultCabecera = function.getTableParameterList()
					.getTable(SapParameter.TABLA_T_FECABRESP);
			FECAECabResponse cabecera = response.getFeCabResp();
			tableResultCabecera.appendRow();
			if (cabecera != null) {
				logger.info("Llenando la cabecera...");
				tableResultCabecera.setValue(
						SapParameter.TABLA_T_FECABRESP_CANTIDADREG,
						cabecera.getCantReg());
				tableResultCabecera.setValue(SapParameter.TABLA_T_FECABRESP_CUIT,
						cabecera.getCuit());
				tableResultCabecera.setValue(
						SapParameter.TABLA_T_FECABRESP_REPROCESO,
						cabecera.getReproceso());
				tableResultCabecera.setValue(
						SapParameter.TABLA_T_FECABRESP_RESULTADO,
						cabecera.getResultado());
				tableResultCabecera.setValue(
						SapParameter.TABLA_T_FECABRESP_PUNTO_VTA,
						cabecera.getPtoVta());
				tableResultCabecera.setValue(
						SapParameter.TABLA_T_FECABRESP_TIPO_CBTE,
						cabecera.getCbteTipo());
				tableResultCabecera.setValue(
						SapParameter.TABLA_T_FECABRESP_FECHPROCESO,
						cabecera.getFchProceso());
				logger.info("Cabecera cargada, se procede a cargar el detalle");
				if (response.getFeDetResp() != null) {
					addDetalle(function, response.getFeDetResp(),cabecera.getPtoVta(), cabecera.getCbteTipo());
				} else {
					logger.info("No hay detalle");
				}
			}
		}
		
		// Seteo los errores
		if (response.getErrors() != null) {
			logger.info("Se agregan los errores de la cabecera ");
			JCoTable tablaError = function.getTableParameterList().getTable(
					SapParameter.TABLA_T_ERRORES);
			
			for (Err error : response.getErrors().getErr()) {
				tablaError.appendRow();
				logger.info("Se setea el error...");
				tablaError.setValue(SapParameter.TABLA_T_ERRORES_CODE, error.getCode());
				tablaError.setValue(SapParameter.TABLA_T_ERRORES_MSG, error.getMsg());
				if (response.getFeCabResp() != null) {
					tablaError.setValue(SapParameter.TABLA_T_ERRORES_CUIT, response.getFeCabResp().getCuit() );
					tablaError.setValue(SapParameter.TABLA_T_ERRORES_PUNTO_VTA, response.getFeCabResp().getPtoVta());
					tablaError.setValue(SapParameter.TABLA_T_ERRORES_TIPO_CBTE, response.getFeCabResp().getCbteTipo());
				}
				logger.info("Error cargado");
			}
		}
		else {
			logger.info("no se encuentran errores de la cabecera ");				
		}
	}

	/**
	 * Agrega el detalle a la respuesta de la factura local
	 * 
	 * @param function
	 * @param tableDetallesResultado
	 */
	private void addDetalle(JCoFunction function,
			ArrayOfFECAEDetResponse detalles, int puntoVta, int tipoCbte) {
		// TODO Cambiar la funcionalidad local por local v1
		JCoTable tableResultDetalle = function.getTableParameterList()
				.getTable(SapParameter.TABLA_T_FEDETRESP);
		// Recorro la lista de detalles pasada por el WS de la AFIP y los seteo
		// en las tablas de retorno de SAP
		for (FECAEDetResponse elemento : detalles.getFECAEDetResponse()) {
			logger.info("Agregando el detalle " + elemento.getCbteDesde());
			tableResultDetalle.appendRow();
			tableResultDetalle.setValue(SapParameter.TABLA_T_FEDETRESP_CAE,
					elemento.getCAE());
			tableResultDetalle.setValue(
					SapParameter.TABLA_T_FEDETRESP_CBT_DESDE,
					elemento.getCbteDesde());
			tableResultDetalle.setValue(
					SapParameter.TABLA_T_FEDETRESP_CBT_HASTA,
					elemento.getCbteHasta());
			tableResultDetalle.setValue(
					SapParameter.TABLA_T_FEDETRESP_FECHA_CBTE,
					elemento.getCbteFch());
			tableResultDetalle.setValue(SapParameter.TABLA_T_FEDETRESP_NRO_DOC,
					elemento.getDocNro());
			tableResultDetalle.setValue(
					SapParameter.TABLA_T_FEDETRESP_RESULTADO,
					elemento.getResultado());
			tableResultDetalle.setValue(
					SapParameter.TABLA_T_FEDETRESP_TIPO_DOC,
					elemento.getDocTipo());
			tableResultDetalle.setValue(
					SapParameter.TABLA_T_FEDETRESP_CONCEPTO,
					elemento.getConcepto());
			tableResultDetalle.setValue(
					SapParameter.TABLA_T_FEDETRESP_FECHA_VTO,
					elemento.getCAEFchVto());
			tableResultDetalle.setValue(
					SapParameter.TABLA_T_FEDETRESP_PUNTO_VTA,
					puntoVta);
			tableResultDetalle.setValue(
					SapParameter.TABLA_T_FEDETRESP_TIPO_CBTE,
					tipoCbte);
			logger.info("Se agrego el detalle " + elemento.getCbteDesde());

			// Seteo los errores
			if (elemento.getObservaciones() != null) {
				logger.info("Se agregan las observaciones del detalle " + elemento.getCbteDesde());
				JCoTable tableResultObservaciones = function.getTableParameterList()
				.getTable(SapParameter.TABLA_T_OBSERVACIONES);
				logger.info("Tabla Correcta");				
				
				for (Obs observacion : elemento.getObservaciones().getObs()) {
					logger.info("Se carga la observacione" + observacion.getCode());				
					tableResultObservaciones.appendRow();
					tableResultObservaciones.setValue(
							SapParameter.TABLA_T_OBSERVACIONES_CODE,
							observacion.getCode());
					tableResultObservaciones.setValue(
							SapParameter.TABLA_T_OBSERVACIONES_MSG,
							observacion.getMsg());
					tableResultObservaciones.setValue(
							SapParameter.TABLA_T_OBSERVACIONES_CBT_DESDE,
							elemento.getCbteDesde());
					tableResultObservaciones.setValue(
							SapParameter.TABLA_T_OBSERVACIONES_PUNTO_VTA,
							puntoVta);
					tableResultObservaciones.setValue(
							SapParameter.TABLA_T_OBSERVACIONES_TIPO_CBTE,
							tipoCbte);
					logger.info("Se agrego Observacion " + observacion.getCode());
				}
				logger.info("Se terminaron de agregar observaciones del detalle " + elemento.getCbteDesde());
			} else {
				logger.info("No se encuentran observaciones");
			}
		}
		logger.info("Detalles agregados");
	}

}
