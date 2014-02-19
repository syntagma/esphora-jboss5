
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
 *         &lt;element name="FERecuperaLastCMPRequestResult" type="{http://ar.gov.afip.dif.facturaelectronica/}FERecuperaLastCMPResponse" minOccurs="0"/>
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
    "feRecuperaLastCMPRequestResult"
})
@XmlRootElement(name = "FERecuperaLastCMPRequestResponse")
public class FERecuperaLastCMPRequestResponse {

    @XmlElement(name = "FERecuperaLastCMPRequestResult")
    protected FERecuperaLastCMPResponse feRecuperaLastCMPRequestResult;

    /**
     * Gets the value of the feRecuperaLastCMPRequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link FERecuperaLastCMPResponse }
     *     
     */
    public FERecuperaLastCMPResponse getFERecuperaLastCMPRequestResult() {
        return feRecuperaLastCMPRequestResult;
    }

    /**
     * Sets the value of the feRecuperaLastCMPRequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FERecuperaLastCMPResponse }
     *     
     */
    public void setFERecuperaLastCMPRequestResult(FERecuperaLastCMPResponse value) {
        this.feRecuperaLastCMPRequestResult = value;
    }

}
