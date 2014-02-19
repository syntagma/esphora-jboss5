
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClsFEXResponse_Tipo_Cbte complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClsFEXResponse_Tipo_Cbte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Cbte_Id" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Cbte_Ds" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cbte_vig_desde" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Cbte_vig_hasta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsFEXResponse_Tipo_Cbte", propOrder = {
    "cbteId",
    "cbteDs",
    "cbteVigDesde",
    "cbteVigHasta"
})
public class ClsFEXResponseTipoCbte {

    @XmlElement(name = "Cbte_Id")
    protected short cbteId;
    @XmlElement(name = "Cbte_Ds")
    protected String cbteDs;
    @XmlElement(name = "Cbte_vig_desde")
    protected String cbteVigDesde;
    @XmlElement(name = "Cbte_vig_hasta")
    protected String cbteVigHasta;

    /**
     * Gets the value of the cbteId property.
     * 
     */
    public short getCbteId() {
        return cbteId;
    }

    /**
     * Sets the value of the cbteId property.
     * 
     */
    public void setCbteId(short value) {
        this.cbteId = value;
    }

    /**
     * Gets the value of the cbteDs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCbteDs() {
        return cbteDs;
    }

    /**
     * Sets the value of the cbteDs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCbteDs(String value) {
        this.cbteDs = value;
    }

    /**
     * Gets the value of the cbteVigDesde property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCbteVigDesde() {
        return cbteVigDesde;
    }

    /**
     * Sets the value of the cbteVigDesde property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCbteVigDesde(String value) {
        this.cbteVigDesde = value;
    }

    /**
     * Gets the value of the cbteVigHasta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCbteVigHasta() {
        return cbteVigHasta;
    }

    /**
     * Sets the value of the cbteVigHasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCbteVigHasta(String value) {
        this.cbteVigHasta = value;
    }

}
