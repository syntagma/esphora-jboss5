
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="argAuth" type="{http://ar.gov.afip.dif.facturaelectronica/}FEAuthRequest" minOccurs="0"/>
 *         &lt;element name="argTCMP" type="{http://ar.gov.afip.dif.facturaelectronica/}FELastCMPtype" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "argAuth",
    "argTCMP"
})
@XmlRootElement(name = "FERecuperaLastCMPRequest")
public class FERecuperaLastCMPRequest {

    protected FEAuthRequest argAuth;
    protected FELastCMPtype argTCMP;

    /**
     * Gets the value of the argAuth property.
     * 
     * @return
     *     possible object is
     *     {@link FEAuthRequest }
     *     
     */
    public FEAuthRequest getArgAuth() {
        return argAuth;
    }

    /**
     * Sets the value of the argAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEAuthRequest }
     *     
     */
    public void setArgAuth(FEAuthRequest value) {
        this.argAuth = value;
    }

    /**
     * Gets the value of the argTCMP property.
     * 
     * @return
     *     possible object is
     *     {@link FELastCMPtype }
     *     
     */
    public FELastCMPtype getArgTCMP() {
        return argTCMP;
    }

    /**
     * Sets the value of the argTCMP property.
     * 
     * @param value
     *     allowed object is
     *     {@link FELastCMPtype }
     *     
     */
    public void setArgTCMP(FELastCMPtype value) {
        this.argTCMP = value;
    }

}
