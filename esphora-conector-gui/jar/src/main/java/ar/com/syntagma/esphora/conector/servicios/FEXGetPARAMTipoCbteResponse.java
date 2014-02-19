
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import fex.dif.afip.gov.ar.FEXResponseTipoCbte;


/**
 * <p>Java class for FEXGetPARAM_Tipo_CbteResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEXGetPARAM_Tipo_CbteResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ar.gov.afip.dif.fex/}FEXResponse_Tipo_Cbte" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEXGetPARAM_Tipo_CbteResponse", propOrder = {
    "_return"
})
public class FEXGetPARAMTipoCbteResponse {

    @XmlElement(name = "return")
    protected FEXResponseTipoCbte _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseTipoCbte }
     *     
     */
    public FEXResponseTipoCbte getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseTipoCbte }
     *     
     */
    public void setReturn(FEXResponseTipoCbte value) {
        this._return = value;
    }

}
