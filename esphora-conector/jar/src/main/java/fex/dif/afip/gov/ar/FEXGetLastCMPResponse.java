
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
 *         &lt;element name="FEXGetLast_CMPResult" type="{http://ar.gov.afip.dif.fex/}FEXResponseLast_CMP" minOccurs="0"/>
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
    "fexGetLastCMPResult"
})
@XmlRootElement(name = "FEXGetLast_CMPResponse")
public class FEXGetLastCMPResponse {

    @XmlElement(name = "FEXGetLast_CMPResult")
    protected FEXResponseLastCMP fexGetLastCMPResult;

    /**
     * Gets the value of the fexGetLastCMPResult property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseLastCMP }
     *     
     */
    public FEXResponseLastCMP getFEXGetLastCMPResult() {
        return fexGetLastCMPResult;
    }

    /**
     * Sets the value of the fexGetLastCMPResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseLastCMP }
     *     
     */
    public void setFEXGetLastCMPResult(FEXResponseLastCMP value) {
        this.fexGetLastCMPResult = value;
    }

}
