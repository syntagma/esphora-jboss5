
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClsFEXResponse_PtoVenta complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClsFEXResponse_PtoVenta">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Pve_Nro" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Pve_Bloqueado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Pve_FchBaja" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsFEXResponse_PtoVenta", propOrder = {
    "pveNro",
    "pveBloqueado",
    "pveFchBaja"
})
public class ClsFEXResponsePtoVenta {

    @XmlElement(name = "Pve_Nro")
    protected short pveNro;
    @XmlElement(name = "Pve_Bloqueado")
    protected String pveBloqueado;
    @XmlElement(name = "Pve_FchBaja")
    protected String pveFchBaja;

    /**
     * Gets the value of the pveNro property.
     * 
     */
    public short getPveNro() {
        return pveNro;
    }

    /**
     * Sets the value of the pveNro property.
     * 
     */
    public void setPveNro(short value) {
        this.pveNro = value;
    }

    /**
     * Gets the value of the pveBloqueado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPveBloqueado() {
        return pveBloqueado;
    }

    /**
     * Sets the value of the pveBloqueado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPveBloqueado(String value) {
        this.pveBloqueado = value;
    }

    /**
     * Gets the value of the pveFchBaja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPveFchBaja() {
        return pveFchBaja;
    }

    /**
     * Sets the value of the pveFchBaja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPveFchBaja(String value) {
        this.pveFchBaja = value;
    }

}
