
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
 *         &lt;element name="FEXGetLast_IDResult" type="{http://ar.gov.afip.dif.fex/}FEXResponse_LastID" minOccurs="0"/>
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
    "fexGetLastIDResult"
})
@XmlRootElement(name = "FEXGetLast_IDResponse")
public class FEXGetLastIDResponse {

    @XmlElement(name = "FEXGetLast_IDResult")
    protected FEXResponseLastID fexGetLastIDResult;

    /**
     * Gets the value of the fexGetLastIDResult property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseLastID }
     *     
     */
    public FEXResponseLastID getFEXGetLastIDResult() {
        return fexGetLastIDResult;
    }

    /**
     * Sets the value of the fexGetLastIDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseLastID }
     *     
     */
    public void setFEXGetLastIDResult(FEXResponseLastID value) {
        this.fexGetLastIDResult = value;
    }

}
