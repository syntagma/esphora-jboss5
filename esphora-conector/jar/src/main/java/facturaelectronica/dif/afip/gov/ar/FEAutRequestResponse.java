
package facturaelectronica.dif.afip.gov.ar;

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
 *         &lt;element name="FEAutRequestResult" type="{http://ar.gov.afip.dif.facturaelectronica/}FEResponse" minOccurs="0"/>
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
    "feAutRequestResult"
})
@XmlRootElement(name = "FEAutRequestResponse")
public class FEAutRequestResponse {

    @XmlElement(name = "FEAutRequestResult")
    protected FEResponse feAutRequestResult;

    /**
     * Gets the value of the feAutRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link FEResponse }
     *     
     */
    public FEResponse getFEAutRequestResult() {
        return feAutRequestResult;
    }

    /**
     * Sets the value of the feAutRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEResponse }
     *     
     */
    public void setFEAutRequestResult(FEResponse value) {
        this.feAutRequestResult = value;
    }

}
