
package ar.com.syntagma.esphora.conector.servicios;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "WsfexService", targetNamespace = "http://servicios.conector.esphora.syntagma.com.ar/", wsdlLocation = "http://127.0.0.1:8180/esphora-conector/ws/wsfex?wsdl")
public class WsfexService
    extends Service
{

    private final static URL WSFEXSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ar.com.syntagma.esphora.conector.servicios.WsfexService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = ar.com.syntagma.esphora.conector.servicios.WsfexService.class.getResource(".");
            url = new URL(baseUrl, "http://127.0.0.1:8180/esphora-conector/ws/wsfex?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://127.0.0.1:8180/esphora-conector/ws/wsfex?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        WSFEXSERVICE_WSDL_LOCATION = url;
    }

    public WsfexService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsfexService() {
        super(WSFEXSERVICE_WSDL_LOCATION, new QName("http://servicios.conector.esphora.syntagma.com.ar/", "WsfexService"));
    }

    /**
     * 
     * @return
     *     returns Wsfex
     */
    @WebEndpoint(name = "wsfexPort")
    public Wsfex getWsfexPort() {
        return super.getPort(new QName("http://servicios.conector.esphora.syntagma.com.ar/", "wsfexPort"), Wsfex.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Wsfex
     */
    @WebEndpoint(name = "wsfexPort")
    public Wsfex getWsfexPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicios.conector.esphora.syntagma.com.ar/", "wsfexPort"), Wsfex.class, features);
    }

}
