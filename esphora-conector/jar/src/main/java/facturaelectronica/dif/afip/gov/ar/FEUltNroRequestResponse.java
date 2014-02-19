
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
 *         &lt;element name="FEUltNroRequestResult" type="{http://ar.gov.afip.dif.facturaelectronica/}FEUltNroResponse" minOccurs="0"/>
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
    "feUltNroRequestResult"
})
@XmlRootElement(name = "FEUltNroRequestResponse")
public class FEUltNroRequestResponse {

    @XmlElement(name = "FEUltNroRequestResult")
    protected FEUltNroResponse feUltNroRequestResult;

    /**
     * Gets the value of the feUltNroRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link FEUltNroResponse }
     *     
     */
    public FEUltNroResponse getFEUltNroRequestResult() {
        return feUltNroRequestResult;
    }

    /**
     * Sets the value of the feUltNroRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEUltNroResponse }
     *     
     */
    public void setFEUltNroRequestResult(FEUltNroResponse value) {
        this.feUltNroRequestResult = value;
    }

}
