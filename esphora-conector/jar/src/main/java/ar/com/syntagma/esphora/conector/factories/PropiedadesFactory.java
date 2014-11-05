package ar.com.syntagma.esphora.conector.factories;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.dominio.enums.ServicioAfip;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;

public class PropiedadesFactory {

	public static Properties getArchivoPropiedadesWS(Ambiente a,
			ServicioAfip servicioAfip) throws ConectorException {
		InputStream is = null;
		String path = null;
		Properties propiedades = new Properties();

		if (a == Ambiente.TEST) {
			path = "test/";
		}

		if (a == Ambiente.PRODUCCION) {
			path = "prod/";
		}

		if (servicioAfip == ServicioAfip.WSFE) {
			path += "wsfe.properties";
		}
		if (servicioAfip == ServicioAfip.WSFEv1) {
			path += "wsfev1.properties";
		}
		if (servicioAfip == ServicioAfip.WSFEX) {
			path += "wsfex.properties";
		}
		if (servicioAfip == ServicioAfip.WSAA) {
			path += "wsaa.properties";
		}

		// is =
		// Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(path);

		try {
			propiedades.load(is);
		} catch (IOException e) {
			throw new ConectorException(99999,
					"No se ha podido leer el archivo " + path, e);
		} catch (Exception e) {
			throw new ConectorException(99999,
					"No se ha podido leer el archivo " + path, e);
		}
		return propiedades;
	}

	public static Properties getArchivoConector() throws ConectorException {
		InputStream is = null;
		Properties propiedades = new Properties();

		// is =
		// Thread.currentThread().getContextClassLoader().getResourceAsStream(
		// "ambiente.properties");
		is = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream("conector.properties");

		try {
			propiedades.load(is);
		} catch (IOException e) {
			throw new ConectorException(99999,
					"No se ha podido leer el archivo ambiente.properties", e);
		} catch (Exception e) {
			throw new ConectorException(99999,
					"No se ha podido leer el archivo ambiente.properties", e);
		}
		return propiedades;
	}

}
