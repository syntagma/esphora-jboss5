
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FEUltNroResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEUltNroResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nro" type="{http://ar.gov.afip.dif.facturaelectronica/}UltNroResponse" minOccurs="0"/>
 *         &lt;element name="RError" type="{http://ar.gov.afip.dif.facturaelectronica/}vError" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEUltNroResponse", propOrder = {
    "nro",
    "rError"
})
public class FEUltNroResponse {

    protected UltNroResponse nro;
    @XmlElement(name = "RError")
    protected VError rError;

    /**
     * Gets the value of the nro property.
     * 
     * @return
     *     possible object is
     *     {@link UltNroResponse }
     *     
     */
    public UltNroResponse getNro() {
        return nro;
    }

    /**
     * Sets the value of the nro property.
     * 
     * @param value
     *     allowed object is
     *     {@link UltNroResponse }
     *     
     */
    public void setNro(UltNroResponse value) {
        this.nro = value;
    }

    /**
     * Gets the value of the rError property.
     * 
     * @return
     *     possible object is
     *     {@link VError }
     *     
     */
    public VError getRError() {
        return rError;
    }

    /**
     * Sets the value of the rError property.
     * 
     * @param value
     *     allowed object is
     *     {@link VError }
     *     
     */
    public void setRError(VError value) {
        this.rError = value;
    }

}
