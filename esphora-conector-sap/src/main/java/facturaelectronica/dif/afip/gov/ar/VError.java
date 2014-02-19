
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vError complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vError">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="percode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="perrmsg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vError", propOrder = {
    "percode",
    "perrmsg"
})
public class VError {

    protected int percode;
    protected String perrmsg;

    /**
     * Gets the value of the percode property.
     * 
     */
    public int getPercode() {
        return percode;
    }

    /**
     * Sets the value of the percode property.
     * 
     */
    public void setPercode(int value) {
        this.percode = value;
    }

    /**
     * Gets the value of the perrmsg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPerrmsg() {
        return perrmsg;
    }

    /**
     * Sets the value of the perrmsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPerrmsg(String value) {
        this.perrmsg = value;
    }

}
