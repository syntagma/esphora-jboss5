
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Item complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Item">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pro_codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pro_ds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pro_qty" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Pro_umed" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Pro_precio_uni" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Pro_total_item" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Item", propOrder = {
    "proCodigo",
    "proDs",
    "proQty",
    "proUmed",
    "proPrecioUni",
    "proTotalItem"
})
public class Item {

    @XmlElement(name = "Pro_codigo")
    protected String proCodigo;
    @XmlElement(name = "Pro_ds")
    protected String proDs;
    @XmlElement(name = "Pro_qty")
    protected double proQty;
    @XmlElement(name = "Pro_umed")
    protected int proUmed;
    @XmlElement(name = "Pro_precio_uni")
    protected double proPrecioUni;
    @XmlElement(name = "Pro_total_item")
    protected double proTotalItem;

    /**
     * Gets the value of the proCodigo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProCodigo() {
        return proCodigo;
    }

    /**
     * Sets the value of the proCodigo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProCodigo(String value) {
        this.proCodigo = value;
    }

    /**
     * Gets the value of the proDs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProDs() {
        return proDs;
    }

    /**
     * Sets the value of the proDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProDs(String value) {
        this.proDs = value;
    }

    /**
     * Gets the value of the proQty property.
     * 
     */
    public double getProQty() {
        return proQty;
    }

    /**
     * Sets the value of the proQty property.
     * 
     */
    public void setProQty(double value) {
        this.proQty = value;
    }

    /**
     * Gets the value of the proUmed property.
     * 
     */
    public int getProUmed() {
        return proUmed;
    }

    /**
     * Sets the value of the proUmed property.
     * 
     */
    public void setProUmed(int value) {
        this.proUmed = value;
    }

    /**
     * Gets the value of the proPrecioUni property.
     * 
     */
    public double getProPrecioUni() {
        return proPrecioUni;
    }

    /**
     * Sets the value of the proPrecioUni property.
     * 
     */
    public void setProPrecioUni(double value) {
        this.proPrecioUni = value;
    }

    /**
     * Gets the value of the proTotalItem property.
     * 
     */
    public double getProTotalItem() {
        return proTotalItem;
    }

    /**
     * Sets the value of the proTotalItem property.
     * 
     */
    public void setProTotalItem(double value) {
        this.proTotalItem = value;
    }

}
