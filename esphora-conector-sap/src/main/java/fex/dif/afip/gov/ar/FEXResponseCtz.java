
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FEXResponse_Ctz complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEXResponse_Ctz">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FEXResultGet" type="{http://ar.gov.afip.dif.fex/}ClsFEXResponse_Ctz" minOccurs="0"/>
 *         &lt;element name="FEXErr" type="{http://ar.gov.afip.dif.fex/}ClsFEXErr" minOccurs="0"/>
 *         &lt;element name="FEXEvents" type="{http://ar.gov.afip.dif.fex/}ClsFEXEvents" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEXResponse_Ctz", propOrder = {
    "fexResultGet",
    "fexErr",
    "fexEvents"
})
public class FEXResponseCtz {

    @XmlElement(name = "FEXResultGet")
    protected ClsFEXResponseCtz fexResultGet;
    @XmlElement(name = "FEXErr")
    protected ClsFEXErr fexErr;
    @XmlElement(name = "FEXEvents")
    protected ClsFEXEvents fexEvents;

    /**
     * Gets the value of the fexResultGet property.
     * 
     * @return
     *     possible object is
     *     {@link ClsFEXResponseCtz }
     *     
     */
    public ClsFEXResponseCtz getFEXResultGet() {
        return fexResultGet;
    }

    /**
     * Sets the value of the fexResultGet property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsFEXResponseCtz }
     *     
     */
    public void setFEXResultGet(ClsFEXResponseCtz value) {
        this.fexResultGet = value;
    }

    /**
     * Gets the value of the fexErr property.
     * 
     * @return
     *     possible object is
     *     {@link ClsFEXErr }
     *     
     */
    public ClsFEXErr getFEXErr() {
        return fexErr;
    }

    /**
     * Sets the value of the fexErr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsFEXErr }
     *     
     */
    public void setFEXErr(ClsFEXErr value) {
        this.fexErr = value;
    }

    /**
     * Gets the value of the fexEvents property.
     * 
     * @return
     *     possible object is
     *     {@link ClsFEXEvents }
     *     
     */
    public ClsFEXEvents getFEXEvents() {
        return fexEvents;
    }

    /**
     * Sets the value of the fexEvents property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsFEXEvents }
     *     
     */
    public void setFEXEvents(ClsFEXEvents value) {
        this.fexEvents = value;
    }

}
