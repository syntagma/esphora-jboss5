
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
    "argAuth"
})
@XmlRootElement(name = "FERecuperaQTYRequest")
public class FERecuperaQTYRequest {

    protected FEAuthRequest argAuth;

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

}
