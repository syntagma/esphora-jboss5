package ar.com.syntagma.esphora.conector.sap.action;

import ar.com.syntagma.esphora.conector.sap.control.SapControl;
import ar.com.syntagma.esphora.conector.sap.factory.PropertiesFactory;
import ar.com.syntagma.esphora.conector.sap.parameter.SapParameter;


public class Proceso {

	public static void main(String args[]) {
		System.out.println("PathWS: " + PropertiesFactory.getProperty("pathWS"));
		// Lanzo en thread que escucha la llamada de SAP
		int a = Integer.parseInt(PropertiesFactory.getProperty(SapParameter.SERVER_AMOUNT));
		for (int i = 1; i <= a; i++) {
			SapControl.step2SimpleServer(SapParameter.SERVER_NAME + i);
			System.out.println(i);
		}

	}

}
