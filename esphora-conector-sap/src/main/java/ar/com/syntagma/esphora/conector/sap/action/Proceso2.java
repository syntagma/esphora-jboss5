//package ar.com.syntagma.esphora.conector.sap.action;
//
//import ar.com.syntagma.esphora.conector.sap.control.SapControl;
//import ar.com.syntagma.esphora.conector.sap.parameter.SapParameter;
//
//import java.io.*;
//import java.util.*;
//
//public class Proceso {
//
//	public static void main(String args[]) {
//		Properties prop = new Properties();
//        try {
//            prop.load(new FileInputStream("pdm.properties"));
//            System.out.println(prop.getProperty("pathWS"));                                                                                               
//        }
//        catch(IOException e) {
//             System.out.println(e.getMessage());
//             return;
//        }
//
//		//System.out.println("PathWS: " + PropertiesFactory.getProperty("pathWS"));
//		// Lanzo en thread que escucha la llamada de SAP
//		int a = Integer.parseInt(PropertiesFactory.getProperty(prop.SERVER_AMOUNT));
//		for (int i = 1; i <= a; i++) {
//			SapControl.step2SimpleServer(SapParameter.SERVER_NAME + i);
//			System.out.println(i);
//		}
//
//	}
//
//}
