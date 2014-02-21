package ar.com.syntagma.esphora.conector.factories;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropiedadesFactory {

	public static Properties getArchivoAmbiente() {
		InputStream is = null;
		Properties propiedades = new Properties();

		is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("/ambiente.properties");
		try {
			propiedades.load(is);
		} catch (IOException e) {
			throw new RuntimeException(
					"No se ha podido leer el archivo ambiente.properties", e);
		} catch (Exception e) {
			throw new RuntimeException(
					"No se ha podido leer el archivo ambiente.properties", e);
		}
		return propiedades;
	}

	public static Properties getConectorProperties() {
		InputStream is = null;
		String path = "";
		Properties propiedades = new Properties();

		String a = PropiedadesFactory.getArchivoAmbiente().getProperty(
				"ambiente");

		if (a.equals("test")) {
			path = "test/";
		}
		if (a.equals("produccion")) {
			path = "prod/";
		}

		String fileName = path + "conector.properties";
		is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(fileName);
		try {
			propiedades.load(is);
		} catch (IOException e) {
			throw new RuntimeException("No se ha podido leer el archivo "
					+ fileName, e);
		} catch (Exception e) {
			throw new RuntimeException("No se ha podido leer el archivo "
					+ fileName, e);
		}
		return propiedades;
	}

}
