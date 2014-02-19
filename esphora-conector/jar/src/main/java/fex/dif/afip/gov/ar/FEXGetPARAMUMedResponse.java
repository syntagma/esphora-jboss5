
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
 *         &lt;element name="FEXGetPARAM_UMedResult" type="{http://ar.gov.afip.dif.fex/}FEXResponse_Umed" minOccurs="0"/>
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
    "fexGetPARAMUMedResult"
})
@XmlRootElement(name = "FEXGetPARAM_UMedResponse")
public class FEXGetPARAMUMedResponse {

    @XmlElement(name = "FEXGetPARAM_UMedResult")
    protected FEXResponseUmed fexGetPARAMUMedResult;

    /**
     * Gets the value of the fexGetPARAMUMedResult property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseUmed }
     *     
     */
    public FEXResponseUmed getFEXGetPARAMUMedResult() {
        return fexGetPARAMUMedResult;
    }

    /**
     * Sets the value of the fexGetPARAMUMedResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseUmed }
     *     
     */
    public void setFEXGetPARAMUMedResult(FEXResponseUmed value) {
        this.fexGetPARAMUMedResult = value;
    }

}
