package ar.com.syntagma.esphora.conector.helper;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import javax.xml.namespace.QName;

public class ServicePropertiesHelper {
	private static String NOMBRE_ARCHIVO = "cliente-conector.properties";
	private static String CONECTOR_URL = "http://127.0.0.1:8080/esphora-conector/ws/";
	private static String SERVICE_NAMESPACE = "http://servicios.conector.esphora.syntagma.com.ar/";
	private static String SERVICE_NAME_WSFEV1 = "Wsfev1Service";
	private static String SERVICE_NAME_WSFE = "WsfevService";
	private static String SERVICE_NAME_WSFEX = "WsfexService";
		
	private static String getWsdlUrl(String servicio) {
		return getProperty("conector.url",CONECTOR_URL)+servicio+"?wsdl";
	}
	
	private static String getServiceNamespace() {
		return getProperty("service.namespace",SERVICE_NAMESPACE);
	}
	
	private static String getServiceName(String servicio) {
		if (servicio.equals("wsfev1")) {
			return getProperty("service.wsfev1.name",SERVICE_NAME_WSFEV1);
		}
		if (servicio.equals("wsfe")) {
			return getProperty("service.wsfe.name",SERVICE_NAME_WSFE);
		}
		if (servicio.equals("wsfex")) {
			return getProperty("service.wsfex.name",SERVICE_NAME_WSFEX);
		}
		return null;
		
	}
	
	public static URL getURL(String servicio) {
		try {
			return new URL(getWsdlUrl(servicio));
		} catch (MalformedURLException e) {
			return null;
		}
	}
		
	public static QName getQName(String servicio) {
		return new QName(getServiceNamespace(), getServiceName(servicio));
	}
		
	private static String getProperty(String property, String defaultValue) {
		Properties propRti = null;
		InputStream is = null;
		try {
			/*Si el nombre es nulo, se lanza una excepcion que atrapamos*/
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream(NOMBRE_ARCHIVO);
			
			/*Si es NULL es porque no existe el archivo*/
			
			propRti = new Properties();
		
			propRti.load(is);
			
			return propRti.getProperty(property, defaultValue);			
		} catch (Exception e) {			
			return defaultValue;
		}
	}
}
