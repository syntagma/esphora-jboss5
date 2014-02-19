package ar.com.syntagma.esphora.test.ws.clientes;
/*
import org.testng.annotations.Test;

import fex.dif.afip.gov.ar.DummyResponse;
import fex.dif.afip.gov.ar.FEXResponseLastCMP;
import fex.dif.afip.gov.ar.FEXResponseLastID;

import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSFEX;
import ar.com.syntagma.esphora.conector.factories.ClienteFactory;



public class WsfexTest   {
	private long cuit = 30656760172L;

   @Test
   public void testFEXGetLast_ID() throws Exception {
	ClienteWSFEX ws = ClienteFactory.getClienteWSFEX(cuit);
	FEXResponseLastID dm = ws.FEXGetLast_ID();
	System.out.println("Error:" + dm.getFEXErr().getErrMsg());
	assert dm.getFEXErr().getErrMsg().equals("OK");
	System.out.println("Ultimo Id:" + dm.getFEXResultGet().getId());
   }
   
   @Test
   public void FEXGetLast_CMP() throws Exception {
	ClienteWSFEX ws = ClienteFactory.getClienteWSFEX(cuit);
	FEXResponseLastCMP dm = ws.FEXGetLast_CMP((short)1,(short)2);
	System.out.println("Error:" + dm.getFEXErr().getErrMsg());
	assert dm.getFEXErr().getErrMsg().equals("OK");
	System.out.println("Ultimo Comprobante:" + dm.getFEXResultLastCMP().getCbteNro());
   }

   
   @Test
   public void testFEDummy() throws Exception {
	ClienteWSFEX ws = ClienteFactory.getClienteWSFEX(cuit);
   	DummyResponse dm = ws.FEXDummy();
   	assert dm.getDbServer().equals("OK");
   	
   	System.out.println("Resultado:" + dm.getDbServer());
   }

}*/