
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import facturaelectronica.dif.afip.gov.ar.FERequest;


/**
 * <p>Java class for FEAutRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEAutRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fer" type="{http://ar.gov.afip.dif.facturaelectronica/}FERequest" minOccurs="0"/>
 *         &lt;element name="cuit" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEAutRequest", propOrder = {
    "fer",
    "cuit"
})
public class FEAutRequest {

    protected FERequest fer;
    protected long cuit;

    /**
     * Gets the value of the fer property.
     * 
     * @return
     *     possible object is
     *     {@link FERequest }
     *     
     */
    public FERequest getFer() {
        return fer;
    }

    /**
     * Sets the value of the fer property.
     * 
     * @param value
     *     allowed object is
     *     {@link FERequest }
     *     
     */
    public void setFer(FERequest value) {
        this.fer = value;
    }

    /**
     * Gets the value of the cuit property.
     * 
     */
    public long getCuit() {
        return cuit;
    }

    /**
     * Sets the value of the cuit property.
     * 
     */
    public void setCuit(long value) {
        this.cuit = value;
    }

}
