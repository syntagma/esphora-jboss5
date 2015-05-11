package ar.com.syntagma.esphora.conector.factories;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class PropiedadesFactory {

    public static Properties getArchivoAmbiente() {
        Properties propiedades = new Properties();

        String path = System.getProperty("jboss.server.config.url") + "ambiente.properties";
        try {
            propiedades.load(new URL(path).openStream()); //new FileInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException("No se ha podido leer el archivo ambiente.properties", e);
        } catch (Exception e) {
            throw new RuntimeException("No se ha podido leer el archivo ambiente.properties", e);
        }
        return propiedades;
    }

    public static Properties getConectorProperties() {
        Properties propiedades = new Properties();

        String path = System.getProperty("jboss.server.config.url") + "ambiente.properties";

        String a = PropiedadesFactory.getArchivoAmbiente().getProperty(
                "ambiente");

        if (a.equals("test")) {
            path = path + "test/";
        }
        if (a.equals("produccion")) {
            path = path + "prod/";
        }

        String fileName = path + "conector.properties";

        try {
            propiedades.load(new URL(fileName).openStream()); //new FileInputStream(path));
        } catch (IOException e) {
            throw new RuntimeException("No se ha podido leer el archivo ambiente.properties", e);
        } catch (Exception e) {
            throw new RuntimeException("No se ha podido leer el archivo ambiente.properties", e);
        }
        return propiedades;

    }
}