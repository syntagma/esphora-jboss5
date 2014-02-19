
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
 *         &lt;element name="FERecuperaQTYRequestResult" type="{http://ar.gov.afip.dif.facturaelectronica/}FERecuperaQTYResponse" minOccurs="0"/>
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
    "feRecuperaQTYRequestResult"
})
@XmlRootElement(name = "FERecuperaQTYRequestResponse")
public class FERecuperaQTYRequestResponse {

    @XmlElement(name = "FERecuperaQTYRequestResult")
    protected FERecuperaQTYResponse feRecuperaQTYRequestResult;

    /**
     * Gets the value of the feRecuperaQTYRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link FERecuperaQTYResponse }
     *     
     */
    public FERecuperaQTYResponse getFERecuperaQTYRequestResult() {
        return feRecuperaQTYRequestResult;
    }

    /**
     * Sets the value of the feRecuperaQTYRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FERecuperaQTYResponse }
     *     
     */
    public void setFERecuperaQTYRequestResult(FERecuperaQTYResponse value) {
        this.feRecuperaQTYRequestResult = value;
    }

}
