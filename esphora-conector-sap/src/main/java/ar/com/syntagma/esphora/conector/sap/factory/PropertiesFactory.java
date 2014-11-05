package ar.com.syntagma.esphora.conector.sap.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFactory {

	public static String getProperty(String key) {
		// TODO Capturar Excepciones
		Properties properties = new Properties();
		InputStream is;
		try {
			is = Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("pdm.properties");
			properties.load(is);
			is.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}
