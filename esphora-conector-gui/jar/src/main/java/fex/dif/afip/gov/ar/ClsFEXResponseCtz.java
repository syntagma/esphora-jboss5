
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClsFEXResponse_Ctz complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClsFEXResponse_Ctz">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Mon_ctz" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Mon_fecha" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsFEXResponse_Ctz", propOrder = {
    "monCtz",
    "monFecha"
})
public class ClsFEXResponseCtz {

    @XmlElement(name = "Mon_ctz")
    protected double monCtz;
    @XmlElement(name = "Mon_fecha")
    protected String monFecha;

    /**
     * Gets the value of the monCtz property.
     * 
     */
    public double getMonCtz() {
        return monCtz;
    }

    /**
     * Sets the value of the monCtz property.
     * 
     */
    public void setMonCtz(double value) {
        this.monCtz = value;
    }

    /**
     * Gets the value of the monFecha property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMonFecha() {
        return monFecha;
    }

    /**
     * Sets the value of the monFecha property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMonFecha(String value) {
        this.monFecha = value;
    }

}
