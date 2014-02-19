
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClsFEX_LastCMP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClsFEX_LastCMP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Sign" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cuit" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Pto_venta" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Tipo_cbte" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsFEX_LastCMP", propOrder = {
    "token",
    "sign",
    "cuit",
    "ptoVenta",
    "tipoCbte"
})
public class ClsFEXLastCMP {

    @XmlElement(name = "Token")
    protected String token;
    @XmlElement(name = "Sign")
    protected String sign;
    @XmlElement(name = "Cuit")
    protected long cuit;
    @XmlElement(name = "Pto_venta")
    protected short ptoVenta;
    @XmlElement(name = "Tipo_cbte")
    protected short tipoCbte;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the sign property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSign() {
        return sign;
    }

    /**
     * Sets the value of the sign property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSign(String value) {
        this.sign = value;
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

    /**
     * Gets the value of the ptoVenta property.
     * 
     */
    public short getPtoVenta() {
        return ptoVenta;
    }

    /**
     * Sets the value of the ptoVenta property.
     * 
     */
    public void setPtoVenta(short value) {
        this.ptoVenta = value;
    }

    /**
     * Gets the value of the tipoCbte property.
     * 
     */
    public short getTipoCbte() {
        return tipoCbte;
    }

    /**
     * Sets the value of the tipoCbte property.
     * 
     */
    public void setTipoCbte(short value) {
        this.tipoCbte = value;
    }

}
