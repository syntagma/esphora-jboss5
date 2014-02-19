
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FERecuperaQTYResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FERecuperaQTYResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="qty" type="{http://ar.gov.afip.dif.facturaelectronica/}FERecuperaQTY" minOccurs="0"/>
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
@XmlType(name = "FERecuperaQTYResponse", propOrder = {
    "qty",
    "rError"
})
public class FERecuperaQTYResponse {

    protected FERecuperaQTY qty;
    @XmlElement(name = "RError")
    protected VError rError;

    /**
     * Gets the value of the qty property.
     * 
     * @return
     *     possible object is
     *     {@link FERecuperaQTY }
     *     
     */
    public FERecuperaQTY getQty() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     * @param value
     *     allowed object is
     *     {@link FERecuperaQTY }
     *     
     */
    public void setQty(FERecuperaQTY value) {
        this.qty = value;
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
