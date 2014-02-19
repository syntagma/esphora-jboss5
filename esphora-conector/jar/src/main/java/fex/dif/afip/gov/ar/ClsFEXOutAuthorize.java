
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClsFEXOutAuthorize complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClsFEXOutAuthorize">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Cuit" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Tipo_cbte" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Punto_vta" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Cbte_nro" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="Cae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fch_venc_Cae" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Fch_cbte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Resultado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Reproceso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Motivos_Obs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsFEXOutAuthorize", propOrder = {
    "id",
    "cuit",
    "tipoCbte",
    "puntoVta",
    "cbteNro",
    "cae",
    "fchVencCae",
    "fchCbte",
    "resultado",
    "reproceso",
    "motivosObs"
})
public class ClsFEXOutAuthorize {

    @XmlElement(name = "Id")
    protected long id;
    @XmlElement(name = "Cuit")
    protected long cuit;
    @XmlElement(name = "Tipo_cbte")
    protected short tipoCbte;
    @XmlElement(name = "Punto_vta")
    protected short puntoVta;
    @XmlElement(name = "Cbte_nro")
    protected long cbteNro;
    @XmlElement(name = "Cae")
    protected String cae;
    @XmlElement(name = "Fch_venc_Cae")
    protected String fchVencCae;
    @XmlElement(name = "Fch_cbte")
    protected String fchCbte;
    @XmlElement(name = "Resultado")
    protected String resultado;
    @XmlElement(name = "Reproceso")
    protected String reproceso;
    @XmlElement(name = "Motivos_Obs")
    protected String motivosObs;

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

    /**
     * Gets the value of the puntoVta property.
     * 
     */
    public short getPuntoVta() {
        return puntoVta;
    }

    /**
     * Sets the value of the puntoVta property.
     * 
     */
    public void setPuntoVta(short value) {
        this.puntoVta = value;
    }

    /**
     * Gets the value of the cbteNro property.
     * 
     */
    public long getCbteNro() {
        return cbteNro;
    }

    /**
     * Sets the value of the cbteNro property.
     * 
     */
    public void setCbteNro(long value) {
        this.cbteNro = value;
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
     * Gets the value of the fchVencCae property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchVencCae() {
        return fchVencCae;
    }

    /**
     * Sets the value of the fchVencCae property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchVencCae(String value) {
        this.fchVencCae = value;
    }

    /**
     * Gets the value of the fchCbte property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFchCbte() {
        return fchCbte;
    }

    /**
     * Sets the value of the fchCbte property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFchCbte(String value) {
        this.fchCbte = value;
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
     * Gets the value of the motivosObs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotivosObs() {
        return motivosObs;
    }

    /**
     * Sets the value of the motivosObs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotivosObs(String value) {
        this.motivosObs = value;
    }

}
