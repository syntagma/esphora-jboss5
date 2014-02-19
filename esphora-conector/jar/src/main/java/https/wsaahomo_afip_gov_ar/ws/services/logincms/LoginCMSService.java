
package https.wsaahomo_afip_gov_ar.ws.services.logincms;

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
@WebServiceClient(name = "LoginCMSService", targetNamespace = "https://wsaahomo.afip.gov.ar/ws/services/LoginCms", wsdlLocation = "https://wsaahomo.afip.gov.ar/ws/services/LoginCms?WSDL")
public class LoginCMSService
    extends Service
{

    private final static URL LOGINCMSSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(https.wsaahomo_afip_gov_ar.ws.services.logincms.LoginCMSService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = https.wsaahomo_afip_gov_ar.ws.services.logincms.LoginCMSService.class.getResource(".");
            url = new URL(baseUrl, "https://wsaahomo.afip.gov.ar/ws/services/LoginCms?WSDL");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'https://wsaahomo.afip.gov.ar/ws/services/LoginCms?WSDL', retrying as a local file");
            logger.warning(e.getMessage());
        }
        LOGINCMSSERVICE_WSDL_LOCATION = url;
    }

    public LoginCMSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public LoginCMSService() {
        super(LOGINCMSSERVICE_WSDL_LOCATION, new QName("https://wsaahomo.afip.gov.ar/ws/services/LoginCms", "LoginCMSService"));
    }

    /**
     * 
     * @return
     *     returns LoginCMS
     */
    @WebEndpoint(name = "LoginCms")
    public LoginCMS getLoginCms() {
        return super.getPort(new QName("https://wsaahomo.afip.gov.ar/ws/services/LoginCms", "LoginCms"), LoginCMS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns LoginCMS
     */
    @WebEndpoint(name = "LoginCms")
    public LoginCMS getLoginCms(WebServiceFeature... features) {
        return super.getPort(new QName("https://wsaahomo.afip.gov.ar/ws/services/LoginCms", "LoginCms"), LoginCMS.class, features);
    }

}
