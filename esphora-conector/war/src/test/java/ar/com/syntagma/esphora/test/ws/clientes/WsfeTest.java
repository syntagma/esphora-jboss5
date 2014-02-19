package ar.com.syntagma.esphora.test.ws.clientes;
/*
import org.testng.annotations.Test;

import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSFE;
import ar.com.syntagma.esphora.conector.factories.ClienteFactory;
import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEReq;
import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEResponse;
import facturaelectronica.dif.afip.gov.ar.FERecuperaLastCMPResponse;
import facturaelectronica.dif.afip.gov.ar.FERecuperaQTYResponse;
import facturaelectronica.dif.afip.gov.ar.FEUltNroResponse;


public class WsfeTest    {
	private long cuit = 30656760172L;

   @Test
   public void testFERecuperaLastCMP() throws Exception {
	ClienteWSFE ws = ClienteFactory.getClienteWSFE(cuit);
	FERecuperaLastCMPResponse dm = ws.FERecuperaLastCMPRequest(1,2);
	//assert ((Integer) dm.getCbteNro()).equals(2) ;
	assert dm.getRError().getPerrmsg().equals("OK");
	System.out.println("Ultimo Comprobante:" + dm.getCbteNro() ); 
   }
   

   @Test
   public void testFEUltNro() throws Exception {
	ClienteWSFE ws = ClienteFactory.getClienteWSFE(cuit);
   	FEUltNroResponse dm = ws.FEUltNroRequest();
	assert dm.getRError().getPerrmsg().equals("OK");
	System.out.println("Ultimo Numero:" + dm.getNro().getValue());
   }
   
   @Test
   public void testFERecuperaQTY() throws Exception {
	ClienteWSFE ws = ClienteFactory.getClienteWSFE(cuit);
   	FERecuperaQTYResponse dm = ws.FERecuperaQTYRequest();
	assert dm.getRError().getPerrmsg().equals("OK");
	System.out.println("Cantidad:" + dm.getQty().getValue());
    }   

   @Test
   public void testFEConsultaCAE() throws Exception {
	ClienteWSFE ws = ClienteFactory.getClienteWSFE(cuit);
   	FEConsultaCAEReq argCAERequest = new FEConsultaCAEReq();
   	argCAERequest.setCae("123");
   	
	FEConsultaCAEResponse dm = ws.FEConsultaCAERequest(argCAERequest);
	System.out.println(dm.getRError().getPerrmsg());
	System.out.println(dm.getRError().getPercode());
	//assert dm.getRError().getPerrmsg().equals("OK");
    assert true; 
   }      
   
}*/