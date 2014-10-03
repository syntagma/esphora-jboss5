public class WSTestFacturaLocal {
	
	
	/**
	 * @param args
	*/
	public static void main(String[] args) {
		
		
		/*WSFEProxy wsfe = new WSFEProxy();
		
		long cuit = 30629416249L;
		
		//Declaro la cabecera
		long id = 10L;
		int cantidadreg = 1;
		int presta_serv = 0;
		
		FECabeceraRequest cabecera = new FECabeceraRequest(id, cantidadreg, presta_serv);
		//Seteo los valores para detalles
		FEDetalleRequest[] detalles = new FEDetalleRequest[1]; 
		int tipo_doc = 80;
		long nro_doc = 30501036672L;
		int tipo_cbte = 1;
		int punto_vta = 23;
		long cbt_desde = 9;
		long cbt_hasta = 9;
		double imp_total = 0;
		double imp_tot_conc = 0;
		double imp_neto = 0;
		double impto_liq = 0;
		double impto_liq_rni = 0;
		double imp_op_ex = 0;
		String fecha_cbte = "20100728";
		String fecha_serv_desde = null;
		String fecha_serv_hasta = null;
		String fecha_venc_pago = null;//validar el dato si tiene q tener o no formato fecha
		FEDetalleRequest detalle = new FEDetalleRequest(tipo_doc, nro_doc, tipo_cbte, punto_vta, cbt_desde,
				cbt_hasta, imp_total, imp_tot_conc, imp_neto, impto_liq, impto_liq_rni, imp_op_ex, fecha_cbte,
				fecha_serv_desde, fecha_serv_hasta, fecha_venc_pago);
		detalles[0] = detalle;
		
		
		FERequest request = new FERequest();
		request.setFecr(cabecera);
		request.setFedr(detalles);
		
		FEResponse response = maker.sendFacturaLocal(request, cuit);
	
		System.out.println(response.getRError().getPerrmsg());
	*/
	}
	
	
}
