
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
 *         &lt;element name="FEXGetPARAM_MONResult" type="{http://ar.gov.afip.dif.fex/}FEXResponse_Mon" minOccurs="0"/>
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
    "fexGetPARAMMONResult"
})
@XmlRootElement(name = "FEXGetPARAM_MONResponse")
public class FEXGetPARAMMONResponse {

    @XmlElement(name = "FEXGetPARAM_MONResult")
    protected FEXResponseMon fexGetPARAMMONResult;

    /**
     * Gets the value of the fexGetPARAMMONResult property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseMon }
     *     
     */
    public FEXResponseMon getFEXGetPARAMMONResult() {
        return fexGetPARAMMONResult;
    }

    /**
     * Sets the value of the fexGetPARAMMONResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseMon }
     *     
     */
    public void setFEXGetPARAMMONResult(FEXResponseMon value) {
        this.fexGetPARAMMONResult = value;
    }

}
