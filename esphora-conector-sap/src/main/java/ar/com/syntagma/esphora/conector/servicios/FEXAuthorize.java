
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import fex.dif.afip.gov.ar.ClsFEXRequest;


/**
 * <p>Java class for FEXAuthorize complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEXAuthorize">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cmp" type="{http://ar.gov.afip.dif.fex/}ClsFEXRequest" minOccurs="0"/>
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
@XmlType(name = "FEXAuthorize", propOrder = {
    "cmp",
    "cuit"
})
public class FEXAuthorize {

    protected ClsFEXRequest cmp;
    protected long cuit;

    /**
     * Gets the value of the cmp property.
     * 
     * @return
     *     possible object is
     *     {@link ClsFEXRequest }
     *     
     */
    public ClsFEXRequest getCmp() {
        return cmp;
    }

    /**
     * Sets the value of the cmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsFEXRequest }
     *     
     */
    public void setCmp(ClsFEXRequest value) {
        this.cmp = value;
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
