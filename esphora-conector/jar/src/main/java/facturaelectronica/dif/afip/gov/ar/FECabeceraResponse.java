
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FECabeceraResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FECabeceraResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="cuit" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="fecha_cae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantidadreg" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="resultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="motivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="reproceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="presta_serv" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FECabeceraResponse", propOrder = {
    "id",
    "cuit",
    "fechaCae",
    "cantidadreg",
    "resultado",
    "motivo",
    "reproceso",
    "prestaServ"
})
public class FECabeceraResponse {

    protected long id;
    protected long cuit;
    @XmlElement(name = "fecha_cae")
    protected String fechaCae;
    protected int cantidadreg;
    protected String resultado;
    protected String motivo;
    protected String reproceso;
    @XmlElement(name = "presta_serv")
    protected int prestaServ;

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
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
     * Gets the value of the fechaCae property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCae() {
        return fechaCae;
    }

    /**
     * Sets the value of the fechaCae property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCae(String value) {
        this.fechaCae = value;
    }

    /**
     * Gets the value of the cantidadreg property.
     * 
     */
    public int getCantidadreg() {
        return cantidadreg;
    }

    /**
     * Sets the value of the cantidadreg property.
     * 
     */
    public void setCantidadreg(int value) {
        this.cantidadreg = value;
    }

    /**
     * Gets the value of the resultado property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResultado() {
        return resultado;
    }

    /**
     * Sets the value of the resultado property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResultado(String value) {
        this.resultado = value;
    }

    /**
     * Gets the value of the motivo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Sets the value of the motivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivo(String value) {
        this.motivo = value;
    }

    /**
     * Gets the value of the reproceso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReproceso() {
        return reproceso;
    }

    /**
     * Sets the value of the reproceso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReproceso(String value) {
        this.reproceso = value;
    }

    /**
     * Gets the value of the prestaServ property.
     * 
     */
    public int getPrestaServ() {
        return prestaServ;
    }

    /**
     * Sets the value of the prestaServ property.
     * 
     */
    public void setPrestaServ(int value) {
        this.prestaServ = value;
    }

}
