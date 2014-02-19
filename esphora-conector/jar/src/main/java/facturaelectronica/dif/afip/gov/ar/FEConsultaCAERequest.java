
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
 *         &lt;element name="argCAERequest" type="{http://ar.gov.afip.dif.facturaelectronica/}FEConsultaCAEReq" minOccurs="0"/>
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
    "argCAERequest"
})
@XmlRootElement(name = "FEConsultaCAERequest")
public class FEConsultaCAERequest {

    protected FEAuthRequest argAuth;
    protected FEConsultaCAEReq argCAERequest;

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
     * Gets the value of the argCAERequest property.
     * 
     * @return
     *     possible object is
     *     {@link FEConsultaCAEReq }
     *     
     */
    public FEConsultaCAEReq getArgCAERequest() {
        return argCAERequest;
    }

    /**
     * Sets the value of the argCAERequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEConsultaCAEReq }
     *     
     */
    public void setArgCAERequest(FEConsultaCAEReq value) {
        this.argCAERequest = value;
    }

}
