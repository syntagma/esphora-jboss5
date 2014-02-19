
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
 *         &lt;element name="FEXGetPARAM_Tipo_CbteResult" type="{http://ar.gov.afip.dif.fex/}FEXResponse_Tipo_Cbte" minOccurs="0"/>
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
    "fexGetPARAMTipoCbteResult"
})
@XmlRootElement(name = "FEXGetPARAM_Tipo_CbteResponse")
public class FEXGetPARAMTipoCbteResponse {

    @XmlElement(name = "FEXGetPARAM_Tipo_CbteResult")
    protected FEXResponseTipoCbte fexGetPARAMTipoCbteResult;

    /**
     * Gets the value of the fexGetPARAMTipoCbteResult property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseTipoCbte }
     *     
     */
    public FEXResponseTipoCbte getFEXGetPARAMTipoCbteResult() {
        return fexGetPARAMTipoCbteResult;
    }

    /**
     * Sets the value of the fexGetPARAMTipoCbteResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseTipoCbte }
     *     
     */
    public void setFEXGetPARAMTipoCbteResult(FEXResponseTipoCbte value) {
        this.fexGetPARAMTipoCbteResult = value;
    }

}
