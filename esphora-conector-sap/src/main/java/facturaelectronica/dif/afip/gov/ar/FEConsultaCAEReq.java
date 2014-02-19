
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FEConsultaCAEReq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEConsultaCAEReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cuit_emisor" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tipo_cbte" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="punto_vta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cbt_nro" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="imp_total" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="cae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_cbte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEConsultaCAEReq", propOrder = {
    "cuitEmisor",
    "tipoCbte",
    "puntoVta",
    "cbtNro",
    "impTotal",
    "cae",
    "fechaCbte"
})
public class FEConsultaCAEReq {

    @XmlElement(name = "cuit_emisor")
    protected long cuitEmisor;
    @XmlElement(name = "tipo_cbte")
    protected int tipoCbte;
    @XmlElement(name = "punto_vta")
    protected int puntoVta;
    @XmlElement(name = "cbt_nro")
    protected long cbtNro;
    @XmlElement(name = "imp_total")
    protected double impTotal;
    protected String cae;
    @XmlElement(name = "fecha_cbte")
    protected String fechaCbte;

    /**
     * Gets the value of the cuitEmisor property.
     * 
     */
    public long getCuitEmisor() {
        return cuitEmisor;
    }

    /**
     * Sets the value of the cuitEmisor property.
     * 
     */
    public void setCuitEmisor(long value) {
        this.cuitEmisor = value;
    }

    /**
     * Gets the value of the tipoCbte property.
     * 
     */
    public int getTipoCbte() {
        return tipoCbte;
    }

    /**
     * Sets the value of the tipoCbte property.
     * 
     */
    public void setTipoCbte(int value) {
        this.tipoCbte = value;
    }

    /**
     * Gets the value of the puntoVta property.
     * 
     */
    public int getPuntoVta() {
        return puntoVta;
    }

    /**
     * Sets the value of the puntoVta property.
     * 
     */
    public void setPuntoVta(int value) {
        this.puntoVta = value;
    }

    /**
     * Gets the value of the cbtNro property.
     * 
     */
    public long getCbtNro() {
        return cbtNro;
    }

    /**
     * Sets the value of the cbtNro property.
     * 
     */
    public void setCbtNro(long value) {
        this.cbtNro = value;
    }

    /**
     * Gets the value of the impTotal property.
     * 
     */
    public double getImpTotal() {
        return impTotal;
    }

    /**
     * Sets the value of the impTotal property.
     * 
     */
    public void setImpTotal(double value) {
        this.impTotal = value;
    }

    /**
     * Gets the value of the cae property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCae() {
        return cae;
    }

    /**
     * Sets the value of the cae property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCae(String value) {
        this.cae = value;
    }

    /**
     * Gets the value of the fechaCbte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCbte() {
        return fechaCbte;
    }

    /**
     * Sets the value of the fechaCbte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCbte(String value) {
        this.fechaCbte = value;
    }

}
