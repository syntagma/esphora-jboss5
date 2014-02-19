package ar.com.syntagma.esphora.conector.sap.factory;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import ar.com.syntagma.esphora.conector.servicios.WsfeService;
import ar.com.syntagma.esphora.conector.servicios.Wsfev1Service;
import ar.com.syntagma.esphora.conector.servicios.WsfexService;

public class WSFactory {
	private static URL wsdlLocation = null;
	private static QName serviceName = null;
	
	public static WsfeService createWSFE (){

		//LLeno el servicio WSFE
		serviceName = new QName("http://servicios.conector.esphora.syntagma.com.ar/",
				"WsfeService");
		try {
			wsdlLocation = new URL(ar.com.syntagma.esphora.conector.servicios.WsfeService.class.getResource("."), PropertiesFactory.getProperty("pathWS")+"wsfe?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new WsfeService(wsdlLocation,serviceName);

	}

	public static WsfexService createWSFEX (){
		//LLeno el servicio WSFEX
		serviceName = new QName("http://servicios.conector.esphora.syntagma.com.ar/",
				"WsfexService");
		try {
			wsdlLocation = new URL(ar.com.syntagma.esphora.conector.servicios.WsfexService.class.getResource("."), PropertiesFactory.getProperty("pathWS")+"wsfex?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new WsfexService(wsdlLocation,serviceName);	
	}

	public static Wsfev1Service createWSFEv1 (){
		//LLeno el servicio WSFEv1
		serviceName = new QName("http://servicios.conector.esphora.syntagma.com.ar/",
				"Wsfev1Service");
		try {
			wsdlLocation = new URL(ar.com.syntagma.esphora.conector.servicios.WsfexService.class.getResource("."), PropertiesFactory.getProperty("pathWS")+"wsfev1?wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return new Wsfev1Service(wsdlLocation,serviceName);	
	}
}
