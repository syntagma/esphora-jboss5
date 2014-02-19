
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
 *         &lt;element name="FEXDummyResult" type="{http://ar.gov.afip.dif.fex/}DummyResponse" minOccurs="0"/>
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
    "fexDummyResult"
})
@XmlRootElement(name = "FEXDummyResponse")
public class FEXDummyResponse {

    @XmlElement(name = "FEXDummyResult")
    protected DummyResponse fexDummyResult;

    /**
     * Gets the value of the fexDummyResult property.
     * 
     * @return
     *     possible object is
     *     {@link DummyResponse }
     *     
     */
    public DummyResponse getFEXDummyResult() {
        return fexDummyResult;
    }

    /**
     * Sets the value of the fexDummyResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DummyResponse }
     *     
     */
    public void setFEXDummyResult(DummyResponse value) {
        this.fexDummyResult = value;
    }

}
