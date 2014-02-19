
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import fex.dif.afip.gov.ar.ClsFEXGetCMP;


/**
 * <p>Java class for FEXGetCMP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEXGetCMP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cmp" type="{http://ar.gov.afip.dif.fex/}ClsFEXGetCMP" minOccurs="0"/>
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
@XmlType(name = "FEXGetCMP", propOrder = {
    "cmp",
    "cuit"
})
public class FEXGetCMP {

    protected ClsFEXGetCMP cmp;
    protected long cuit;

    /**
     * Gets the value of the cmp property.
     * 
     * @return
     *     possible object is
     *     {@link ClsFEXGetCMP }
     *     
     */
    public ClsFEXGetCMP getCmp() {
        return cmp;
    }

    /**
     * Sets the value of the cmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsFEXGetCMP }
     *     
     */
    public void setCmp(ClsFEXGetCMP value) {
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
