
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="FEXAuthorizeResult" type="{http://ar.gov.afip.dif.fex/}FEXResponseAuthorize" minOccurs="0"/>
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
    "fexAuthorizeResult"
})
@XmlRootElement(name = "FEXAuthorizeResponse")
public class FEXAuthorizeResponse {

    @XmlElement(name = "FEXAuthorizeResult")
    protected FEXResponseAuthorize fexAuthorizeResult;

    /**
     * Gets the value of the fexAuthorizeResult property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseAuthorize }
     *     
     */
    public FEXResponseAuthorize getFEXAuthorizeResult() {
        return fexAuthorizeResult;
    }

    /**
     * Sets the value of the fexAuthorizeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseAuthorize }
     *     
     */
    public void setFEXAuthorizeResult(FEXResponseAuthorize value) {
        this.fexAuthorizeResult = value;
    }

}
