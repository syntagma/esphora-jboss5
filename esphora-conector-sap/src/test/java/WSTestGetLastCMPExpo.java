

import org.testng.annotations.Test;

import ar.com.syntagma.esphora.conector.sap.proxy.WSFEXProxy;
import fex.dif.afip.gov.ar.FEXResponseLastCMP;

@Test
public class WSTestGetLastCMPExpo {

	/**
	 * @param args
	 */
	@Test
	public static void main(String[] args) {
		WSFEXProxy wsfex = new WSFEXProxy();
		
		long cuit = 30629416249L;
		short tipo_cbte = 1;
		short pto_vta = 1;
		
		FEXResponseLastCMP response = wsfex.getLastCMPExpo(tipo_cbte, pto_vta, cuit);
		
		
		
		System.out.println(response.getFEXErr().getErrCode());
		
	}

}
