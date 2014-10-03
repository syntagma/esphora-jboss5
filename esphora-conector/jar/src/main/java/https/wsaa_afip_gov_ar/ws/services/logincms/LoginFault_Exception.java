
package https.wsaa_afip_gov_ar.ws.services.logincms;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebFault(name = "fault", targetNamespace = "https://wsaa.afip.gov.ar/ws/services/LoginCms")
public class LoginFault_Exception
    extends Exception
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2853973938834087085L;
	/**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private LoginFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public LoginFault_Exception(String message, LoginFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public LoginFault_Exception(String message, LoginFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: https.wsaa_afip_gov_ar.ws.services.logincms.LoginFault
     */
    public LoginFault getFaultInfo() {
        return faultInfo;
    }

}
