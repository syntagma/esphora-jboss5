package ar.com.syntagma.esphora.conector.sap.parameter;

public class SapParameter {
	// File reader
	public static final String SEPARADOR_RESPONSE = "/@/";
	//public static final String EXTENSION_TMP = ".tmp";
	//public static final String FILE_RESPONSE_NAME = "response.txt";
	//public static final String APP_PATH = System.getProperty("user.dir") + "/";

	public static final String SERVER_NAME = "SERVER";
	public static final String SERVER_NAME1 = "SERVER1";
	public static final String SERVER_NAME2 = "SERVER2";
	public static final String SERVER_NAME3 = "SERVER3";
	public static final String SERVER_AMOUNT = "servers";
	public static final String DESTINATION_NAME1 = "ABAP_AS_WITHOUT_POOL";
	public static final String DESTINATION_NAME2 = "ABAP_AS_WITH_POOL";
	// Nombre de la RFC que envia la factura de expo
	public final static String RFC_FUNCTION_1 = "ZJ_1A_RFC";
	// Nombre de la RFC que envia la factura local
	public final static String RFC_FUNCTION_2 = "ZJ_1A_RFC_LCL";
	// Nombre de la RFC que envia la factura local v1
	public final static String RFC_FUNCTION_3 = "ZJ_1A_RFC_LOC";

	public final static String RFC_FUNCTION_LAST_CMP_EXPO = "";

	public final static String RFC_FUNCTION_LAST_CMP_LOCAL = "";

	public final static String RFC_FUNCTION_LAST_CMP_LOCALV1 = "";

	// Parameters
	public final static String NUMERO_CUIT = "I_CUIT";

	// Parametros de la RFC de numero de comprobante para factura local
	public final static String RFC_PARAMETER_LOCAL_NCMP_TIPO_CBTE = "TIPO_CBTE";
	public final static String RFC_PARAMETER_LOCAL_NCMP_PTO_VTA = "PTO_VTA";

	// Parametros de la RFC de numero de comprobante para factura de exportacion
	public final static String RFC_PARAMETER_EXPO_NCMP_TIPO_CBTE = "TIPO_CBTE";
	public final static String RFC_PARAMETER_EXPO_NCMP_PTO_VTA = "PTO_VTA";

	// Tabla comprobante local
	public static final String TABLA_L_COMPROBANTE = "T_FECR";
	public static final String TABLA_L_COMPROBANTE_ID = "ID";
	public static final String TABLA_L_COMPROBANTE_CANT_REG = "CANTIDADREG";
	public static final String TABLA_L_COMPROBANTE_PRESTA_SERV = "PRESTA_SERV";

	// Tabla detalle comprobante local
	public static final String TABLA_DETAIL_L = "T_FEDR";
	public static final String TABLA_DETAIL_L_TIPO_DOC = "TIPO_DOC";
	public static final String TABLA_DETAIL_L_NRO_DOC = "NRO_DOC";
	public static final String TABLA_DETAIL_L_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_DETAIL_L_PTO_VTA = "PUNTO_VTA";
	public static final String TABLA_DETAIL_L_CBTE_DESDE = "CBT_DESDE";
	public static final String TABLA_DETAIL_L_CBTE_HASTA = "CBT_HASTA";
	public static final String TABLA_DETAIL_L_IMP_TOTAL = "IMP_TOTAL";
	public static final String TABLA_DETAIL_L_IMP_TOTAL_CONC = "IMP_TOT_CONC";
	public static final String TABLA_DETAIL_L_IMP_NETO = "IMP_NETO";
	public static final String TABLA_DETAIL_L_IMPTO_LIQ = "IMPTO_LIQ";
	public static final String TABLA_DETAIL_L_IMPTO_LIQ_RNI = "IMPTO_LIQ_RNI";
	public static final String TABLA_DETAIL_L_IMP_OP_EX = "IMP_OP_EX";
	public static final String TABLA_DETAIL_L_FCH_SERV_DESDE = "FECHA_SERV_DESDE";
	public static final String TABLA_DETAIL_L_FCH_SERV_HASTA = "FECHA_SERV_HASTA";
	public static final String TABLA_DETAIL_L_FCH_VENC_PAGO = "FECHA_VENC_PAGO";
	public static final String TABLA_DETAIL_L_FCH_CBTE = "FECHA_CBTE";

	// Tabla resultado comprobante local
	public static final String T_RESULT_CBTE_LOCAL = "T_FECRESP";
	public static final String T_RESULT_CBTE_LOCAL_ID = "ID";
	public static final String T_RESULT_CBTE_LOCAL_CUIT = "CUIT";
	public static final String T_RESULT_CBTE_LOCAL_FCH_CAE = "FECHA_CAE";
	public static final String T_RESULT_CBTE_LOCAL_CANT_REG = "CANTIDADREG";
	public static final String T_RESULT_CBTE_LOCAL_RESULT = "RESULTADO";
	public static final String T_RESULT_CBTE_LOCAL_MOTIVO = "MOTIVO";
	public static final String T_RESULT_CBTE_LOCAL_REPROCESO = "REPROCESO";
	public static final String T_RESULT_CBTE_LOCAL_PRESTA_SERV = "PRESTA_SERV";
	public static final String T_RESULT_CBTE_LOCAL_ERROR_COD = "PERCODE";
	public static final String T_RESULT_CBTE_LOCAL_ERROR_MSG = "PERRMSG";

	// Tabla resultado comprobante detalle
	public static final String T_RESULT_DETALLE = "T_FEDRESP";
	public static final String T_RESULT_DETALLE_ID = "ID";
	public static final String T_RESULT_DETALLE_TIPO_DOC = "TIPO_DOC";
	public static final String T_RESULT_DETALLE_NRO_DOC = "NRO_DOC";
	public static final String T_RESULT_DETALLE_TIPO_CBTE = "TIPO_CBTE";
	public static final String T_RESULT_DETALLE_PTO_VTA = "PUNTO_VTA";
	public static final String T_RESULT_DETALLE_CBTE_DESDE = "CBT_DESDE";
	public static final String T_RESULT_DETALLE_CBTE_HASTA = "CBT_HASTA";
	public static final String T_RESULT_DETALLE_IMP_TOTAL = "IMP_TOTAL";
	public static final String T_RESULT_DETALLE_IMP_TOT_CONC = "IMP_TOT_CONC";
	public static final String T_RESULT_DETALLE_IMP_NETO = "IMP_NETO";
	public static final String T_RESULT_DETALLE_IMPTO_LIQ = "IMPTO_LIQ";
	public static final String T_RESULT_DETALLE_IMPTO_LIQ_RNI = "IMPTO_LIQ_RNI";
	public static final String T_RESULT_DETALLE_IMP_OP_EX = "IMP_OP_EX";
	public static final String T_RESULT_DETALLE_FCH_CBTE = "FECHA_CBTE";
	public static final String T_RESULT_DETALLE_RESULTADO = "RESULTADO";
	public static final String T_RESULT_DETALLE_CAE = "CAE";
	public static final String T_RESULT_DETALLE_FCH_VTO = "FECHA_VTO";
	public static final String T_RESULT_DETALLE_MOTIVO = "MOTIVO";
	public static final String T_RESULT_DETALLE_FCH_SERV_DESDE = "FECHA_SERV_DESDE";
	public static final String T_RESULT_DETALLE_FCH_SERV_HASTA = "FECHA_SERV_HASTA";
	public static final String T_RESULT_DETALLE_FCH_VENC_PAGO = "FECHA_VENC_PAGO";

	// Tabla Comprobante exportacion
	public static final String TABLA_COMPROBANTE = "T_CMP";
	public static final String TABLA_COMPROBANTE_ID = "ID";
	public static final String TABLA_COMPROBANTE_TIPO = "TIPO_CBTE";
	public static final String TABLA_COMPROBANTE_FECHA = "FECHA_CBTE";
	public static final String TABLA_COMPROBANTE_PTO_VTA = "PUNTO_VTA";
	public static final String TABLA_COMPROBANTE_NUMERO = "CBT_NRO";
	public static final String TABLA_COMPROBANTE_TIPO_EXPO = "TIPO_EXPO";
	public static final String TABLA_COMPROBANTE_PERMISO = "PERMISO_EXISTENTE";
	public static final String TABLA_COMPROBANTE_DESTINO = "DST_CMP";
	public static final String TABLA_COMPROBANTE_CLIENTE = "CLIENTE";
	public static final String TABLA_COMPROBANTE_CUIT_PAIS_CLIENTE = "CUIT_PAIS_CLIENTE";
	public static final String TABLA_COMPROBANTE_DIRE_CLIENTE = "DOMICILIO_CLIENTE";
	public static final String TABLA_COMPROBANTE_IMPOSITIVO_ID = "ID_IMPOSITIVO";
	public static final String TABLA_COMPROBANTE_MONEDA_ID = "MONEDA_ID";
	public static final String TABLA_COMPROBANTE_MONEDA_CTZ = "MONEDA_CTZ";
	public static final String TABLA_COMPROBANTE_OBS_COMERC = "OBS_COMERCIALES";
	public static final String TABLA_COMPROBANTE_TOTAL = "IMP_TOTAL";
	public static final String TABLA_COMPROBANTE_OBS = "OBS";
	public static final String TABLA_COMPROBANTE_FORMA_PAGO = "FORMA_PAGO";
	public static final String TABLA_COMPROBANTE_INCOTERMS = "INCOTERMS";
	public static final String TABLA_COMPROBANTE_INCOTERMS_INFO = "INCOTERMS_DS";
	public static final String TABLA_COMPROBANTE_IDIOMA = "IDIOMA_CBTE";

	// Tabla permisos
	public static final String TABLA_PERMISOS = "T_PERMISOS";
	public static final String TABLA_PERMISOS_FK_COMPROBANTE = "ID";
	public static final String TABLA_PERMISOS_ID = "ID_PERMISOS";
	public static final String TABLA_PERMISOS_PAIS_DEST = "DST_MERC";

	// Tabla comprobantes asociados
	public static final String TABLA_CMPS_ASOC = "T_CMPS_ASOC";
	public static final String TABLA_CMPS_ASOC_FK_COMPROBANTE = "ID";
	public static final String TABLA_CMPS_ASOC_TIPO = "CBTE_TIPO";
	public static final String TABLA_CMPS_PTO_VTA = "CBTE_PUNTO_VTA";
	public static final String TABLA_CMPS_NUMERO = "CBTE_NRO";

	// Tabla Items
	public static final String TABLA_ITEMS = "T_ITEMS";
	public static final String TABLA_ITEMS_FK_COMPROBANTE = "ID";
	public static final String TABLA_ITEMS_CODIGO = "PRO_CODIGO";
	public static final String TABLA_ITEMS_DESCR = "PRO_DS";
	public static final String TABLA_ITEMS_CANTIDAD = "PRO_QTY";
	public static final String TABLA_ITEMS_UM = "PRO_UMED";
	public static final String TABLA_ITEMS_PRECIO_UNI = "PRO_PRECIO_UNI";
	public static final String TABLA_ITEMS_TOTAL = "PRO_TOTAL_ITEM";

	// Tabla resultado
	public static final String TABLA_RESULTADO = "T_RESULT";
	public static final String TABLA_RESULTADO_ID = "ID";
	public static final String TABLA_RESULTADO_CUIT = "CUIT";
	public static final String TABLA_RESULTADO_CAE = "CAE";
	public static final String TABLA_RESULTADO_FECHA_VENC_CAE = "FCH_VENC_CAE";
	public static final String TABLA_RESULTADO_FECHA_COMPROBANTE = "FECHA_CBTE";
	public static final String TABLA_RESULTADO_RESULTADO = "RESULTADO";
	public static final String TABLA_RESULTADO_REPROCESO = "REPROCESO";
	public static final String TABLA_RESULTADO_MOTIVOS_OBS = "MOTIVOS_OBS";
	public static final String TABLA_RESULTADO_ERRO_DESC = "ERRMSG";
	public static final String TABLA_RESULTADO_ERRO_COD = "ERRCODE";
	public static final String TABLA_RESULTADO_EVENT_DESC = "EVENTMSG";
	public static final String TABLA_RESULTADO_EVENT_COD = "EVENTCODE";

	public static final int LENGTH_ERR_MSG = 200;
	public static final int LENGTH_EVENT_MSG = 200;

	// Tabla comprobante local v1 Cabecera
	public static final String TABLA_T_FECABREQ = "T_FECABREQ";
	public static final String TABLA_T_FECABREQ_CANTIDADREG = "CANTIDADREG";
	public static final String TABLA_T_FECABREQ_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_T_FECABREQ_PUNTO_VTA = "PUNTO_VTA";

	// Tabla comprobante local v1 Detalle
	public static final String TABLA_T_FEDETREQ = "T_FEDETREQ";
	public static final String TABLA_T_FEDETREQ_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_T_FEDETREQ_PUNTO_VTA = "PUNTO_VTA";
	public static final String TABLA_T_FEDETREQ_CONCEPTO = "CONCEPTO";
	public static final String TABLA_T_FEDETREQ_TIPO_DOC = "TIPO_DOC";
	public static final String TABLA_T_FEDETREQ_NRO_DOC = "NRO_DOC";
	public static final String TABLA_T_FEDETREQ_CBT_DESDE = "CBT_DESDE";
	public static final String TABLA_T_FEDETREQ_CBT_HASTA = "CBT_HASTA";
	public static final String TABLA_T_FEDETREQ_FECHA_CBTE = "FECHA_CBTE";
	public static final String TABLA_T_FEDETREQ_IMP_TOTAL = "IMP_TOTAL";
	public static final String TABLA_T_FEDETREQ_IMP_TOT_CONC = "IMP_TOT_CONC";
	public static final String TABLA_T_FEDETREQ_IMP_NETO = "IMP_NETO";
	public static final String TABLA_T_FEDETREQ_IMP_OP_EX = "IMP_OP_EX";
	public static final String TABLA_T_FEDETREQ_IMPTO_LIQ = "IMPTO_LIQ";
	public static final String TABLA_T_FEDETREQ_IMPTRIB = "IMPTRIB";
	public static final String TABLA_T_FEDETREQ_FECHA_SERV_DESDE = "FECHA_SERV_DESDE";
	public static final String TABLA_T_FEDETREQ_FECHA_SERV_HASTA = "FECHA_SERV_HASTA";
	public static final String TABLA_T_FEDETREQ_FECHA_VENC_PAGO = "FECHA_VENC_PAGO";
	public static final String TABLA_T_FEDETREQ_MONEDA_ID = "MONEDA_ID";
	public static final String TABLA_T_FEDETREQ_MONEDA_CTZ = "MONEDA_CTZ";

	// Tabla comprobante local v1 Comprobantes Asociados
	public static final String TABLA_T_CBTESASOC = "T_CBTESASOC";
	public static final String TABLA_T_CBTESASOC_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_T_CBTESASOC_PUNTO_VTA = "PUNTO_VTA";
	public static final String TABLA_T_CBTESASOC_CBT_DESDE = "CBT_DESDE";
	public static final String TABLA_T_CBTESASOC_CBTE_TIPO = "CBTE_TIPO";
	public static final String TABLA_T_CBTESASOC_CBTE_PUNTO_VTA = "CBTE_PUNTO_VTA";
	public static final String TABLA_T_CBTESASOC_CBTE_NRO = "CBTE_NRO";

	// Tabla comprobante local v1 Tributos
	public static final String TABLA_T_TRIBUTOS = "T_TRIBUTOS";
	public static final String TABLA_T_TRIBUTOS_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_T_TRIBUTOS_PUNTO_VTA = "PUNTO_VTA";
	public static final String TABLA_T_TRIBUTOS_CBT_DESDE = "CBT_DESDE";
	public static final String TABLA_T_TRIBUTOS_ID_TRIB = "ID_TRIB";
	public static final String TABLA_T_TRIBUTOS_DESC_TRIB = "DESC_TRIB";
	public static final String TABLA_T_TRIBUTOS_BASEIMP = "BASEIMP";
	public static final String TABLA_T_TRIBUTOS_ALIC = "ALIC";
	public static final String TABLA_T_TRIBUTOS_IMPORTE = "IMPORTE";

	// Tabla comprobante local v1 Iva
	public static final String TABLA_T_IVA = "T_IVA";
	public static final String TABLA_T_IVA_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_T_IVA_PUNTO_VTA = "PUNTO_VTA";
	public static final String TABLA_T_IVA_CBT_DESDE = "CBT_DESDE";
	public static final String TABLA_T_IVA_ID_IVA = "ID_IVA";
	public static final String TABLA_T_IVA_BASEIMP = "BASEIMP";
	public static final String TABLA_T_IVA_IMPORTE = "IMPORTE";

	// Tabla comprobante local v1 Opcionales
	public static final String TABLA_T_OPCIONALES = "T_OPCIONALES";
	public static final String TABLA_T_OPCIONALES_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_T_OPCIONALES_PUNTO_VTA = "PUNTO_VTA";
	public static final String TABLA_T_OPCIONALES_CBT_DESDE = "CBT_DESDE";
	public static final String TABLA_T_OPCIONALES_ID_OPC = "ID_OPC";
	public static final String TABLA_T_OPCIONALES_VALOR = "VALOR";

	// Tabla de Respuesta comprobante local v1 Cabecera
	public static final String TABLA_T_FECABRESP = "T_FECABRESP";
	public static final String TABLA_T_FECABRESP_CANTIDADREG = "CANTIDADREG";
	public static final String TABLA_T_FECABRESP_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_T_FECABRESP_PUNTO_VTA = "PUNTO_VTA";
	public static final String TABLA_T_FECABRESP_CUIT = "CUIT";
	public static final String TABLA_T_FECABRESP_FECHPROCESO = "FECHPROCESO";
	public static final String TABLA_T_FECABRESP_RESULTADO = "RESULTADO";
	public static final String TABLA_T_FECABRESP_REPROCESO = "REPROCESO";

	// Tabla de Respuesta comprobante local v1 Detalle
	public static final String TABLA_T_FEDETRESP = "T_FEDETRESP";
	public static final String TABLA_T_FEDETRESP_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_T_FEDETRESP_PUNTO_VTA = "PUNTO_VTA";
	public static final String TABLA_T_FEDETRESP_CONCEPTO = "CONCEPTO";
	public static final String TABLA_T_FEDETRESP_TIPO_DOC = "TIPO_DOC";
	public static final String TABLA_T_FEDETRESP_NRO_DOC = "NRO_DOC";
	public static final String TABLA_T_FEDETRESP_CBT_DESDE = "CBT_DESDE";
	public static final String TABLA_T_FEDETRESP_CBT_HASTA = "CBT_HASTA";
	public static final String TABLA_T_FEDETRESP_FECHA_CBTE = "FECHA_CBTE";
	public static final String TABLA_T_FEDETRESP_RESULTADO = "RESULTADO";
	public static final String TABLA_T_FEDETRESP_CAE = "CAE";
	public static final String TABLA_T_FEDETRESP_FECHA_VTO = "FECHA_VTO";

	// Tabla de Respuesta comprobante local v1 Observaciones
	public static final String TABLA_T_OBSERVACIONES = "T_OBSERVACIONES";
	public static final String TABLA_T_OBSERVACIONES_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_T_OBSERVACIONES_PUNTO_VTA = "PUNTO_VTA";
	public static final String TABLA_T_OBSERVACIONES_CBT_DESDE = "CBT_DESDE";
	public static final String TABLA_T_OBSERVACIONES_CODE = "CODE";
	public static final String TABLA_T_OBSERVACIONES_MSG = "MSG";
	
	// Tabla de Respuesta comprobante local v1 Errores
	public static final String TABLA_T_ERRORES = "T_ERRORES";
	public static final String TABLA_T_ERRORES_CUIT = "CUIT";
	public static final String TABLA_T_ERRORES_TIPO_CBTE = "TIPO_CBTE";
	public static final String TABLA_T_ERRORES_PUNTO_VTA = "PUNTO_VTA";
	public static final String TABLA_T_ERRORES_CODE = "CODE";
	public static final String TABLA_T_ERRORES_MSG = "MSG";
	
	
}
