
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
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "WsfeService", targetNamespace = "http://servicios.conector.esphora.syntagma.com.ar/", wsdlLocation = "http://127.0.0.1:8080/esphora-conector/ws/wsfe?wsdl")
public class WsfeService
    extends Service
{

    private final static URL WSFESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(ar.com.syntagma.esphora.conector.servicios.WsfeService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = ar.com.syntagma.esphora.conector.servicios.WsfeService.class.getResource(".");
            url = new URL(baseUrl, "http://127.0.0.1:8080/esphora-conector/ws/wsfe?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://127.0.0.1:8080/esphora-conector/ws/wsfe?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        WSFESERVICE_WSDL_LOCATION = url;
    }

    public WsfeService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsfeService() {
        super(WSFESERVICE_WSDL_LOCATION, new QName("http://servicios.conector.esphora.syntagma.com.ar/", "WsfeService"));
    }

    /**
     * 
     * @return
     *     returns Wsfe
     */
    @WebEndpoint(name = "wsfePort")
    public Wsfe getWsfePort() {
        return super.getPort(new QName("http://servicios.conector.esphora.syntagma.com.ar/", "wsfePort"), Wsfe.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Wsfe
     */
    @WebEndpoint(name = "wsfePort")
    public Wsfe getWsfePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://servicios.conector.esphora.syntagma.com.ar/", "wsfePort"), Wsfe.class, features);
    }

}
