import junit.framework.TestCase;

import ar.com.syntagma.esphora.conector.sap.proxy.WSFEv1Proxy;

import fev1.dif.afip.gov.ar.FECompConsultaResponse;


public class testGetLastCMPLocal extends TestCase {
	
	/**
	 * @param args
	 */
	public void testWsfev1() {
		WSFEv1Proxy wsfev1 = new WSFEv1Proxy();

		long cuit = 30629416249L;
		/*
		String s = Daemon.getPropertie("ptos_vta");
		
		String [] pto_vta = s.split(",");
		
		s = Daemon.getPropertie("tipos_cbte");
		System.out.println("s:" + s);
		
		String [] cbtes = s.split(",");
		
		s = Daemon.getPropertie("tipoFactura");
		
		if (s.equals("1")){
		for (int j = 0; j < pto_vta.length; j++) {
			for (int i = 0; i < cbtes.length; i++) {
				FERecuperaLastCMPResponse response = maker.getLastCMPLocal(
											Integer.parseInt(cbtes[i]), Integer.parseInt(pto_vta[j]), cuit);
				logger.info("pto_vta: " + pto_vta[j] +" tipo cbte: " + cbtes[i]+ " cbte_nro:" + response.getCbteNro());
			}
		}
		} else {
		for (int j = 0; j < pto_vta.length; j++) {
			for (int i = 0; i < cbtes.length; i++) {
				FEXResponseLast_CMP response = maker.getLastCMPExpo(
						 Short.parseShort(cbtes[i]), Short.parseShort(pto_vta[j]), cuit);
				logger.info("pto_vta: " + pto_vta[j] +" tipo cbte: " + cbtes[i]+ " cbte_nro:" + response.getFEXResult_LastCMP().getCbte_nro());
			}
		}
		}
		*/
		
		FECompConsultaResponse response = wsfev1.getComprobante(
				1,1,1, cuit);
		assertTrue(response.getErrors().getErr().get(0).getCode()==0);
		
		System.out.println("pto_vta: 1 tipo cbte: 1 cbte_nro:" + response.getResultGet().getCbteDesde() + " Fecha:" + response.getResultGet().getCbteFch());
	}

}
