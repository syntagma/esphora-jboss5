
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import facturaelectronica.dif.afip.gov.ar.DummyResponse;


/**
 * <p>Java class for FEDummyResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEDummyResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ar.gov.afip.dif.facturaelectronica/}DummyResponse" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEDummyResponse", propOrder = {
    "_return"
})
public class FEDummyResponse {

    @XmlElement(name = "return")
    protected DummyResponse _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link DummyResponse }
     *     
     */
    public DummyResponse getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link DummyResponse }
     *     
     */
    public void setReturn(DummyResponse value) {
        this._return = value;
    }

}
