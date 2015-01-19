package ar.com.syntagma.esphora.conector.factories;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import ar.com.syntagma.esphora.conector.dominio.enums.Ambiente;
import ar.com.syntagma.esphora.conector.dominio.enums.ServicioAfip;
import ar.com.syntagma.esphora.conector.exceptions.ConectorException;

public class PropiedadesFactory {

    public static Properties getArchivoPropiedadesWS(Ambiente a, ServicioAfip servicioAfip) throws ConectorException {

        String path = System.getProperty("jboss.server.config.url");
        Properties propiedades = new Properties();

        if (a == Ambiente.TEST) {
            path += "test/";
        }

        if (a == Ambiente.PRODUCCION) {
            path += "prod/";
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


        try {
            propiedades.load(new URL(path).openStream()); //new FileInputStream(path));
        } catch (IOException e) {
            throw new ConectorException(99999, "No se ha podido leer el archivo " + path, e);
        } catch (Exception e) {
            throw new ConectorException(99999, "No se ha podido leer el archivo " + path, e);
        }
        return propiedades;
    }

    public static Properties getArchivoAmbiente() throws ConectorException {
        Properties propiedades = new Properties();

        String path = System.getProperty("jboss.server.config.url") + "ambiente.properties";
        try {
            propiedades.load(new URL(path).openStream()); //new FileInputStream(path));
        } catch (IOException e) {
            throw new ConectorException(99999, "No se ha podido leer el archivo ambiente.properties", e);
        } catch (Exception e) {
            throw new ConectorException(99999, "No se ha podido leer el archivo ambiente.properties", e);
        }
        return propiedades;
    }

    public static Properties getArchivoCuit(Ambiente a, long cuit) throws ConectorException {
        String path = System.getProperty("jboss.server.config.url");
        Properties propiedades = new Properties();

        if (a == Ambiente.TEST) {
            path = path + "test/";
        }

        if (a == Ambiente.PRODUCCION) {
            path = path + "prod/";
        }
        String fileName = path + cuit + ".properties";
        try {
            propiedades.load(new URL(fileName).openStream()); //new FileInputStream(path));
        } catch (IOException e) {
            throw new ConectorException(99999, "No se ha podido leer el archivo " + fileName, e);
        } catch (Exception e) {
            throw new ConectorException(99999, "No se ha podido leer el archivo " + fileName, e);
        }
        return propiedades;
    }

}
