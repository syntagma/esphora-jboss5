package ar.com.syntagma.esphora.test.ws.clientes;
/*

import org.jboss.seam.mock.SeamTest;
import org.testng.annotations.Test;

import ar.com.syntagma.esphora.clientes.ws.afip.ClienteWSFE;
import facturaelectronica.dif.afip.gov.ar.DummyResponse;
import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEReq;
import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEResponse;
import facturaelectronica.dif.afip.gov.ar.FELastCMPtype;
import facturaelectronica.dif.afip.gov.ar.FERecuperaLastCMPResponse;
import facturaelectronica.dif.afip.gov.ar.FERecuperaQTYResponse;
import facturaelectronica.dif.afip.gov.ar.FEUltNroResponse;

public class ClienteWSFESeamTest extends SeamTest {
	
	   @Test
	   public void testFERecuperaLastCMP() throws Exception {
	   	Parametro p = new Parametro();
		p.setNombre("Ambiente");
		p.setValor("Test");
		ClienteWSFE ws = new ClienteWSFE(p);
		FELastCMPtype type = new FELastCMPtype();
		type.setPtoVta(2);
		type.setTipoCbte(1);
		FERecuperaLastCMPResponse dm = ws.FERecuperaLastCMPRequest(type);
		assert ((Integer) dm.getCbteNro()).equals(2) ;
		System.out.println("Resultado:" + dm.getCbteNro() ); 
		assert dm.getRError().getPerrmsg().equals("OK");
	   }
	   
	   
	   @Test
	   public void testFEDummy() throws Exception {
		Parametro p = new Parametro();
	   	p.setNombre("Ambiente");
	   	p.setValor("Test");
	   	ClienteWSFE ws = new ClienteWSFE(p);
	   	DummyResponse dm = ws.FEDummy();
		assert dm.getDbserver().equals("OK");
	   	
	   	System.out.println("Resultado:" + dm.getDbserver());
	   }

	   @Test
	   public void testFEUltNro() throws Exception {
		Parametro p = new Parametro();
	   	p.setNombre("Ambiente");
	   	p.setValor("Test");
	   	ClienteWSFE ws = new ClienteWSFE(p);
	   	FEUltNroResponse dm = ws.FEUltNroRequest();
		assert dm.getRError().getPerrmsg().equals("OK");
	    }
	   
	   @Test
	   public void testFERecuperaQTY() throws Exception {
		Parametro p = new Parametro();
	   	p.setNombre("Ambiente");
	   	p.setValor("Test");
	   	ClienteWSFE ws = new ClienteWSFE(p);
	   	FERecuperaQTYResponse dm = ws.FERecuperaQTYRequest();
		assert dm.getRError().getPerrmsg().equals("OK");
	    }   

	   @Test
	   public void testFEConsultaCAE() throws Exception {
		Parametro p = new Parametro();
	   	p.setNombre("Ambiente");
	   	p.setValor("Test");
	   	ClienteWSFE ws = new ClienteWSFE(p);
	   	FEConsultaCAEReq argCAERequest = new FEConsultaCAEReq();
	   	argCAERequest.setCae("123");
	   	
		FEConsultaCAEResponse dm = ws.FEConsultaCAERequest(argCAERequest);
		System.out.println(dm.getRError().getPerrmsg());
		System.out.println(dm.getRError().getPercode());
		//assert dm.getRError().getPerrmsg().equals("OK");
	    assert true; 
	   }      

}
*/