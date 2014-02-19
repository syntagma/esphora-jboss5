
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import fev1.dif.afip.gov.ar.FECAEASinMovResponse;


/**
 * <p>Java class for FECAEASinMovimientoInformarResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FECAEASinMovimientoInformarResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ar.gov.afip.dif.FEV1/}FECAEASinMovResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FECAEASinMovimientoInformarResponse", propOrder = {
    "_return"
})
public class FECAEASinMovimientoInformarResponse {

    @XmlElement(name = "return")
    protected FECAEASinMovResponse _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link FECAEASinMovResponse }
     *     
     */
    public FECAEASinMovResponse getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link FECAEASinMovResponse }
     *     
     */
    public void setReturn(FECAEASinMovResponse value) {
        this._return = value;
    }

}
