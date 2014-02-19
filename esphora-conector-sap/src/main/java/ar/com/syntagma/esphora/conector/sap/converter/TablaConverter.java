package ar.com.syntagma.esphora.conector.sap.converter;

import ar.com.syntagma.esphora.conector.sap.parameter.SapParameter;

import com.sap.conn.jco.JCoTable;

import facturaelectronica.dif.afip.gov.ar.FECabeceraRequest;
import facturaelectronica.dif.afip.gov.ar.FEDetalleRequest;
import fev1.dif.afip.gov.ar.AlicIva;
import fev1.dif.afip.gov.ar.CbteAsoc;
import fev1.dif.afip.gov.ar.FECAECabRequest;
import fev1.dif.afip.gov.ar.FECAEDetRequest;
import fev1.dif.afip.gov.ar.Opcional;
import fev1.dif.afip.gov.ar.Tributo;
import fex.dif.afip.gov.ar.ClsFEXRequest;
import fex.dif.afip.gov.ar.CmpAsoc;
import fex.dif.afip.gov.ar.Item;
import fex.dif.afip.gov.ar.Permiso;

public class TablaConverter {
	/**
	 * Recibe la tabla cabecera de SAP y la transforma en el objeto para el WS
	 * 
	 * @param cabecera
	 * @return
	 */
	public static FECabeceraRequest tableComprobanteLocal(JCoTable cabecera) {
		FECabeceraRequest request = new FECabeceraRequest();
		request.setId(cabecera.getLong(SapParameter.TABLA_L_COMPROBANTE_ID));
		request.setCantidadreg(cabecera
				.getInt(SapParameter.TABLA_L_COMPROBANTE_CANT_REG));
		request.setPrestaServ(cabecera
				.getInt(SapParameter.TABLA_L_COMPROBANTE_PRESTA_SERV));
		return request;
	}

	/**
	 * Recibe una JCo table correspondiente a detalle parada en el registro que
	 * se necesita leer
	 * 
	 * @param tableDetalle
	 * @return
	 */
	public static FEDetalleRequest detalleComprobanteLocal(JCoTable tableDetalle) {
		FEDetalleRequest detalle = new FEDetalleRequest();
		detalle.setCbtDesde(tableDetalle
				.getLong(SapParameter.TABLA_DETAIL_L_CBTE_DESDE));
		detalle.setCbtHasta(tableDetalle
				.getLong(SapParameter.TABLA_DETAIL_L_CBTE_HASTA));
		detalle.setFechaCbte(tableDetalle
				.getString(SapParameter.TABLA_DETAIL_L_FCH_CBTE));
		if (tableDetalle.getString(SapParameter.TABLA_DETAIL_L_FCH_SERV_DESDE)
				.equals(""))
			detalle.setFechaServDesde(null);
		else
			detalle.setFechaServDesde(tableDetalle
					.getString(SapParameter.TABLA_DETAIL_L_FCH_SERV_DESDE));
		if (tableDetalle.getString(SapParameter.TABLA_DETAIL_L_FCH_SERV_HASTA)
				.equals(""))
			detalle.setFechaServHasta(null);
		else
			detalle.setFechaServHasta(tableDetalle
					.getString(SapParameter.TABLA_DETAIL_L_FCH_SERV_HASTA));
		if (tableDetalle.getString(SapParameter.TABLA_DETAIL_L_FCH_VENC_PAGO)
				.equals(""))
			detalle.setFechaVencPago(null);
		else
			detalle.setFechaVencPago(tableDetalle
					.getString(SapParameter.TABLA_DETAIL_L_FCH_VENC_PAGO));
		detalle.setImpNeto(tableDetalle
				.getDouble(SapParameter.TABLA_DETAIL_L_IMP_NETO));
		detalle.setImpOpEx(tableDetalle
				.getDouble(SapParameter.TABLA_DETAIL_L_IMP_OP_EX));
		detalle.setImpTotal(tableDetalle
				.getDouble(SapParameter.TABLA_DETAIL_L_IMP_TOTAL));
		detalle.setImpTotConc(tableDetalle
				.getDouble(SapParameter.TABLA_DETAIL_L_IMP_TOTAL_CONC));
		detalle.setImptoLiq(tableDetalle
				.getDouble(SapParameter.TABLA_DETAIL_L_IMPTO_LIQ));
		detalle.setImptoLiqRni(tableDetalle
				.getDouble(SapParameter.TABLA_DETAIL_L_IMPTO_LIQ_RNI));
		detalle.setNroDoc(tableDetalle
				.getLong(SapParameter.TABLA_DETAIL_L_NRO_DOC));
		detalle.setPuntoVta(tableDetalle
				.getInt(SapParameter.TABLA_DETAIL_L_PTO_VTA));
		detalle.setTipoCbte(tableDetalle
				.getInt(SapParameter.TABLA_DETAIL_L_TIPO_CBTE));
		detalle.setTipoDoc(tableDetalle
				.getInt(SapParameter.TABLA_DETAIL_L_TIPO_DOC));

		return detalle;

	}

	/**
	 * Recibe la tabla cabecera de SAP y la transforma en el objeto para el WS
	 * 
	 * @param cabecera
	 * @return
	 */
	public static FECAECabRequest tableComprobanteLocalv1(JCoTable cabecera) {
		FECAECabRequest request = new FECAECabRequest();
		request.setCantReg(cabecera
				.getInt(SapParameter.TABLA_T_FECABREQ_CANTIDADREG));
		request.setCbteTipo(cabecera
				.getInt(SapParameter.TABLA_T_FECABREQ_TIPO_CBTE));
		request.setPtoVta(cabecera
				.getInt(SapParameter.TABLA_T_FECABREQ_PUNTO_VTA));
		return request;
	}

	/**
	 * Recibe una JCo table correspondiente a detalle parada en el registro que
	 * se necesita leer
	 * 
	 * @param tableDetalle
	 * @return
	 */
	public static FECAEDetRequest detalleComprobanteLocalv1(
			JCoTable tableDetalle) {
		FECAEDetRequest detalle = new FECAEDetRequest();
		detalle.setCbteDesde(tableDetalle
				.getLong(SapParameter.TABLA_T_FEDETREQ_CBT_DESDE));
		detalle.setCbteHasta(tableDetalle
				.getLong(SapParameter.TABLA_T_FEDETREQ_CBT_DESDE));
		detalle.setCbteFch(tableDetalle
				.getString(SapParameter.TABLA_T_FEDETREQ_FECHA_CBTE));
		if (tableDetalle.getString(
				SapParameter.TABLA_T_FEDETREQ_FECHA_SERV_DESDE).equals(""))
			detalle.setFchServDesde(null);
		else
			detalle.setFchServDesde(tableDetalle
					.getString(SapParameter.TABLA_T_FEDETREQ_FECHA_SERV_DESDE));
		if (tableDetalle.getString(
				SapParameter.TABLA_T_FEDETREQ_FECHA_SERV_HASTA).equals(""))
			detalle.setFchServHasta(null);
		else
			detalle.setFchServHasta(tableDetalle
					.getString(SapParameter.TABLA_T_FEDETREQ_FECHA_SERV_HASTA));
		if (tableDetalle.getString(
				SapParameter.TABLA_T_FEDETREQ_FECHA_VENC_PAGO).equals(""))
			detalle.setFchVtoPago(null);
		else
			detalle.setFchVtoPago(tableDetalle
					.getString(SapParameter.TABLA_T_FEDETREQ_FECHA_VENC_PAGO));
		detalle.setImpNeto(tableDetalle
				.getDouble(SapParameter.TABLA_T_FEDETREQ_IMP_NETO));
		detalle.setImpOpEx(tableDetalle
				.getDouble(SapParameter.TABLA_T_FEDETREQ_IMP_OP_EX));
		detalle.setImpTotal(tableDetalle
				.getDouble(SapParameter.TABLA_T_FEDETREQ_IMP_TOTAL));
		detalle.setImpTotConc(tableDetalle
				.getDouble(SapParameter.TABLA_T_FEDETREQ_IMP_TOT_CONC));
		detalle.setDocNro(tableDetalle
				.getLong(SapParameter.TABLA_T_FEDETREQ_NRO_DOC));
		detalle.setDocTipo(tableDetalle
				.getInt(SapParameter.TABLA_T_FEDETREQ_TIPO_DOC));
		detalle.setConcepto(tableDetalle
				.getInt(SapParameter.TABLA_T_FEDETREQ_CONCEPTO));
		detalle.setImpIVA(tableDetalle
				.getDouble(SapParameter.TABLA_T_FEDETREQ_IMPTO_LIQ));
		detalle.setImpTrib(tableDetalle
				.getDouble(SapParameter.TABLA_T_FEDETREQ_IMPTRIB));
		detalle.setMonCotiz(tableDetalle
				.getDouble(SapParameter.TABLA_T_FEDETREQ_MONEDA_CTZ));
		detalle.setMonId(tableDetalle
				.getString(SapParameter.TABLA_T_FEDETREQ_MONEDA_ID));

		return detalle;

	}

	public static CbteAsoc CbteAsocLocalv1(JCoTable tabla) {
		CbteAsoc cbteAsoc = new CbteAsoc();
		cbteAsoc.setNro(tabla.getLong(SapParameter.TABLA_T_CBTESASOC_CBTE_NRO));
		cbteAsoc.setPtoVta(tabla
				.getInt(SapParameter.TABLA_T_CBTESASOC_CBTE_PUNTO_VTA));
		cbteAsoc.setTipo(tabla.getInt(SapParameter.TABLA_T_CBTESASOC_CBTE_TIPO));

		return cbteAsoc;
	}

	public static Tributo TributosLocalv1(JCoTable tabla) {
		Tributo tributo = new Tributo();
		tributo.setAlic(tabla.getDouble(SapParameter.TABLA_T_TRIBUTOS_ALIC));
		tributo.setBaseImp(tabla
				.getDouble(SapParameter.TABLA_T_TRIBUTOS_BASEIMP));
		tributo.setDesc(tabla
				.getString(SapParameter.TABLA_T_TRIBUTOS_DESC_TRIB));
		tributo.setId(tabla.getShort(SapParameter.TABLA_T_TRIBUTOS_ID_TRIB));
		tributo.setImporte(tabla
				.getDouble(SapParameter.TABLA_T_TRIBUTOS_IMPORTE));

		return tributo;
	}

	public static AlicIva IvaLocalv1(JCoTable tabla) {
		AlicIva alicIva = new AlicIva();
		alicIva.setBaseImp(tabla.getDouble(SapParameter.TABLA_T_IVA_BASEIMP));
		alicIva.setId(tabla.getShort(SapParameter.TABLA_T_IVA_ID_IVA));
		alicIva.setImporte(tabla.getDouble(SapParameter.TABLA_T_IVA_IMPORTE));

		return alicIva;
	}

	public static Opcional OpcionalesLocalv1(JCoTable tabla) {
		Opcional opcional = new Opcional();
		opcional.setValor(tabla
				.getString(SapParameter.TABLA_T_OPCIONALES_VALOR));
		opcional.setId(tabla.getString(SapParameter.TABLA_T_OPCIONALES_ID_OPC));

		return opcional;
	}

	/**
	 * Interpreta la tabla de comprobantes de SAP y setea los datos del objeto
	 * ClsFEXRequest para el WS
	 * 
	 * @param tablaComprobantes
	 * @return
	 */
	public static ClsFEXRequest converteTableComprobanteExpo(
			JCoTable tablaComprobantes) {
		ClsFEXRequest comprobante = new ClsFEXRequest();
		comprobante.setCbteNro(tablaComprobantes
				.getLong(SapParameter.TABLA_COMPROBANTE_NUMERO));
		comprobante.setCliente(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_CLIENTE));
		comprobante.setCuitPaisCliente(tablaComprobantes
				.getLong(SapParameter.TABLA_COMPROBANTE_CUIT_PAIS_CLIENTE));
		comprobante.setDomicilioCliente(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_DIRE_CLIENTE));
		comprobante.setDstCmp(tablaComprobantes
				.getShort(SapParameter.TABLA_COMPROBANTE_DESTINO));
		comprobante.setFechaCbte(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_FECHA));
		comprobante.setFormaPago(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_FORMA_PAGO));
		comprobante.setId(tablaComprobantes
				.getLong(SapParameter.TABLA_COMPROBANTE_ID));
		comprobante.setIdImpositivo(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_IMPOSITIVO_ID));
		comprobante.setIdiomaCbte(tablaComprobantes
				.getShort(SapParameter.TABLA_COMPROBANTE_IDIOMA));
		comprobante.setImpTotal(tablaComprobantes
				.getDouble(SapParameter.TABLA_COMPROBANTE_TOTAL));
		comprobante.setIncoterms(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_INCOTERMS));
		comprobante.setIncotermsDs(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_INCOTERMS_INFO));
		comprobante.setMonedaCtz(tablaComprobantes
				.getDouble(SapParameter.TABLA_COMPROBANTE_MONEDA_CTZ));
		comprobante.setMonedaId(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_MONEDA_ID));
		comprobante.setObs(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_OBS));
		comprobante.setObsComerciales(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_OBS_COMERC));
		comprobante.setPermisoExistente(tablaComprobantes
				.getString(SapParameter.TABLA_COMPROBANTE_PERMISO));
		comprobante.setPuntoVta(tablaComprobantes
				.getShort(SapParameter.TABLA_COMPROBANTE_PTO_VTA));
		comprobante.setTipoCbte(tablaComprobantes
				.getShort(SapParameter.TABLA_COMPROBANTE_TIPO));
		comprobante.setTipoExpo(tablaComprobantes
				.getShort(SapParameter.TABLA_COMPROBANTE_TIPO_EXPO));

		return comprobante;
	}

	/**
	 * Recibe una JCo table correspondiente a Items parada en el registro que se
	 * necesita leer
	 * 
	 * @param tablaItems
	 * @return
	 */
	public static Item converterTableItems(JCoTable tablaItems) {
		Item item = new Item();
		item.setProCodigo(tablaItems.getString(SapParameter.TABLA_ITEMS_CODIGO));
		item.setProDs(tablaItems.getString(SapParameter.TABLA_ITEMS_DESCR));
		item.setProPrecioUni(tablaItems
				.getDouble(SapParameter.TABLA_ITEMS_PRECIO_UNI));
		item.setProTotalItem(tablaItems
				.getDouble(SapParameter.TABLA_ITEMS_TOTAL));
		item.setProUmed(tablaItems.getInt(SapParameter.TABLA_ITEMS_UM));
		item.setProQty(tablaItems.getDouble(SapParameter.TABLA_ITEMS_CANTIDAD));

		return item;
	}

	/**
	 * Recibe una JCo table correspondiente a Cmp_asoc parada en el registro que
	 * se necesita leer
	 * 
	 * @param tablaCompAsoc
	 * @return
	 */
	public static CmpAsoc converterTableComproAsoc(JCoTable tablaCompAsoc) {
		CmpAsoc cmpAsoc = new CmpAsoc();
		cmpAsoc.setCbteNro(tablaCompAsoc
				.getLong(SapParameter.TABLA_CMPS_NUMERO));
		cmpAsoc.setCBteTipo(tablaCompAsoc
				.getShort(SapParameter.TABLA_CMPS_ASOC_TIPO));
		cmpAsoc.setCbtePuntoVta(tablaCompAsoc
				.getShort(SapParameter.TABLA_CMPS_PTO_VTA));
		return cmpAsoc;
	}

	/**
	 * Recibe una JCo table correspondiente a Permiso parada en el registro que
	 * se necesita leer
	 * 
	 * @param tablapermisos
	 * @return
	 */
	public static Permiso converterTablePermiso(JCoTable tablapermisos) {
		Permiso permiso = new Permiso();
		permiso.setDstMerc(tablapermisos
				.getInt(SapParameter.TABLA_PERMISOS_PAIS_DEST));
		permiso.setIdPermiso(tablapermisos
				.getString(SapParameter.TABLA_PERMISOS_ID));
		return permiso;
	}

}
