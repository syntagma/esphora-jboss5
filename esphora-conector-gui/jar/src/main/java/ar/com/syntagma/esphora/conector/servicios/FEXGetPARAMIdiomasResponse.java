
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import fex.dif.afip.gov.ar.FEXResponseIdi;


/**
 * <p>Java class for FEXGetPARAM_IdiomasResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEXGetPARAM_IdiomasResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ar.gov.afip.dif.fex/}FEXResponse_Idi" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEXGetPARAM_IdiomasResponse", propOrder = {
    "_return"
})
public class FEXGetPARAMIdiomasResponse {

    @XmlElement(name = "return")
    protected FEXResponseIdi _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseIdi }
     *     
     */
    public FEXResponseIdi getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseIdi }
     *     
     */
    public void setReturn(FEXResponseIdi value) {
        this._return = value;
    }

}
