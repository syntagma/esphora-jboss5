

import org.apache.log4j.Logger;

/**
 * Esta clase testea el envio de un comprobante al WS de Syntagma
 *  
 * 25/06/2010
 * @author E. Balan
 *
 */

public class WSTest {
	
	final static Logger logger = Logger.getLogger(WSTest.class);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*
		Date aux = new Date();
		aux.setTime(3600000);
		System.out.println(aux);

		
		for (long i = 5; i < 6; i++) {
			WSFEXProxy wsfex = new WSFEXProxy();
			long id = i;
			String fecha_cbte = "20100722";
			short tipo_cbte = 19;
			short punto_vta = 27;
			long cbte_nro = 1;
			short tipo_expo = 1;
			String permiso_existente = "N"; 
			Permiso [] permisos =  null; 
			short dst_cmp = 225;
			String cliente = "pdmTest"; 
			long cuit_pais_cliente = 55000000034L;
			String domicilio_cliente = "Dire cliente";
			String id_impositivo = "";
			String moneda_Id = "PES";
			double moneda_ctz = 1;
			String obs_comerciales = "Prueba";
			double imp_total = 45;
			String obs = "Test";
			CmpAsoc cmps_asoc;
			String forma_pago = "cta corriente"; 
			String incoterms = "FOB";
			String incoterms_Ds = "Montevideo"; 
			short idioma_cbte = 1;
			//Items
			String pro_cod = "02655000AB";
			String pro_ds = "Test";
			double pro_qty = 10;
	        int pro_umed = 1;
	        double pro_precio_uni = 4.5;
	        double pro_total_item = 45;
			//Item item = new Item(pro_cod, pro_ds, pro_qty, pro_umed, pro_precio_uni, pro_total_item);
			//Item [] items = new Item [1];
			//items[0] = item;
			long cuit = 30629416249L;
			/*		
			ClsFEXRequest request = new ClsFEXRequest(
					id, fecha_cbte, tipo_cbte, punto_vta, cbte_nro, tipo_expo, permiso_existente, 
					permisos, dst_cmp, cliente, cuit_pais_cliente, domicilio_cliente, id_impositivo, 
					moneda_Id, moneda_ctz, obs_comerciales, imp_total, obs, cmps_asoc, forma_pago, 
					incoterms, incoterms_Ds, idioma_cbte, items);
	    	FEXResponseAuthorize response = wsfex.sendComprobante(request, cuit);
	    	
	    	System.out.println(id);
	    	System.out.println(response.getFEXErr().getErrMsg());
	    	String pepe = "a";
	    	pepe ="b";
	    	
		}
		*/
		}
	

}
