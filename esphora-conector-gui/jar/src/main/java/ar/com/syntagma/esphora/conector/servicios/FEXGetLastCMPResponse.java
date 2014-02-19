
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import fex.dif.afip.gov.ar.FEXResponseLastCMP;


/**
 * <p>Java class for FEXGetLast_CMPResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEXGetLast_CMPResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ar.gov.afip.dif.fex/}FEXResponseLast_CMP" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEXGetLast_CMPResponse", propOrder = {
    "_return"
})
public class FEXGetLastCMPResponse {

    @XmlElement(name = "return")
    protected FEXResponseLastCMP _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseLastCMP }
     *     
     */
    public FEXResponseLastCMP getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseLastCMP }
     *     
     */
    public void setReturn(FEXResponseLastCMP value) {
        this._return = value;
    }

}
