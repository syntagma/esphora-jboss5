
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
 *         &lt;element name="FEConsultaCAERequestResult" type="{http://ar.gov.afip.dif.facturaelectronica/}FEConsultaCAEResponse" minOccurs="0"/>
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
    "feConsultaCAERequestResult"
})
@XmlRootElement(name = "FEConsultaCAERequestResponse")
public class FEConsultaCAERequestResponse {

    @XmlElement(name = "FEConsultaCAERequestResult")
    protected FEConsultaCAEResponse feConsultaCAERequestResult;

    /**
     * Gets the value of the feConsultaCAERequestResult property.
     * 
     * @return
     *     possible object is
     *     {@link FEConsultaCAEResponse }
     *     
     */
    public FEConsultaCAEResponse getFEConsultaCAERequestResult() {
        return feConsultaCAERequestResult;
    }

    /**
     * Sets the value of the feConsultaCAERequestResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEConsultaCAEResponse }
     *     
     */
    public void setFEConsultaCAERequestResult(FEConsultaCAEResponse value) {
        this.feConsultaCAERequestResult = value;
    }

}
