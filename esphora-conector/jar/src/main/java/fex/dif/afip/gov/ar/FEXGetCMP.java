
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Auth" type="{http://ar.gov.afip.dif.fex/}ClsFEXAuthRequest" minOccurs="0"/>
 *         &lt;element name="Cmp" type="{http://ar.gov.afip.dif.fex/}ClsFEXGetCMP" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "auth",
    "cmp"
})
@XmlRootElement(name = "FEXGetCMP")
public class FEXGetCMP {

    @XmlElement(name = "Auth")
    protected ClsFEXAuthRequest auth;
    @XmlElement(name = "Cmp")
    protected ClsFEXGetCMP cmp;

    /**
     * Gets the value of the auth property.
     * 
     * @return
     *     possible object is
     *     {@link ClsFEXAuthRequest }
     *     
     */
    public ClsFEXAuthRequest getAuth() {
        return auth;
    }

    /**
     * Sets the value of the auth property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClsFEXAuthRequest }
     *     
     */
    public void setAuth(ClsFEXAuthRequest value) {
        this.auth = value;
    }

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

}
