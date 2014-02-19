
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FEDetalleRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEDetalleRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipo_doc" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nro_doc" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tipo_cbte" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="punto_vta" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cbt_desde" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="cbt_hasta" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="imp_total" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="imp_tot_conc" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="imp_neto" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="impto_liq" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="impto_liq_rni" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="imp_op_ex" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fecha_cbte" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_serv_desde" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_serv_hasta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fecha_venc_pago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEDetalleRequest", propOrder = {
    "tipoDoc",
    "nroDoc",
    "tipoCbte",
    "puntoVta",
    "cbtDesde",
    "cbtHasta",
    "impTotal",
    "impTotConc",
    "impNeto",
    "imptoLiq",
    "imptoLiqRni",
    "impOpEx",
    "fechaCbte",
    "fechaServDesde",
    "fechaServHasta",
    "fechaVencPago"
})
public class FEDetalleRequest {

    @XmlElement(name = "tipo_doc")
    protected int tipoDoc;
    @XmlElement(name = "nro_doc")
    protected long nroDoc;
    @XmlElement(name = "tipo_cbte")
    protected int tipoCbte;
    @XmlElement(name = "punto_vta")
    protected int puntoVta;
    @XmlElement(name = "cbt_desde")
    protected long cbtDesde;
    @XmlElement(name = "cbt_hasta")
    protected long cbtHasta;
    @XmlElement(name = "imp_total")
    protected double impTotal;
    @XmlElement(name = "imp_tot_conc")
    protected double impTotConc;
    @XmlElement(name = "imp_neto")
    protected double impNeto;
    @XmlElement(name = "impto_liq")
    protected double imptoLiq;
    @XmlElement(name = "impto_liq_rni")
    protected double imptoLiqRni;
    @XmlElement(name = "imp_op_ex")
    protected double impOpEx;
    @XmlElement(name = "fecha_cbte")
    protected String fechaCbte;
    @XmlElement(name = "fecha_serv_desde")
    protected String fechaServDesde;
    @XmlElement(name = "fecha_serv_hasta")
    protected String fechaServHasta;
    @XmlElement(name = "fecha_venc_pago")
    protected String fechaVencPago;

    /**
     * Gets the value of the tipoDoc property.
     * 
     */
    public int getTipoDoc() {
        return tipoDoc;
    }

    /**
     * Sets the value of the tipoDoc property.
     * 
     */
    public void setTipoDoc(int value) {
        this.tipoDoc = value;
    }

    /**
     * Gets the value of the nroDoc property.
     * 
     */
    public long getNroDoc() {
        return nroDoc;
    }

    /**
     * Sets the value of the nroDoc property.
     * 
     */
    public void setNroDoc(long value) {
        this.nroDoc = value;
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
     * Gets the value of the cbtDesde property.
     * 
     */
    public long getCbtDesde() {
        return cbtDesde;
    }

    /**
     * Sets the value of the cbtDesde property.
     * 
     */
    public void setCbtDesde(long value) {
        this.cbtDesde = value;
    }

    /**
     * Gets the value of the cbtHasta property.
     * 
     */
    public long getCbtHasta() {
        return cbtHasta;
    }

    /**
     * Sets the value of the cbtHasta property.
     * 
     */
    public void setCbtHasta(long value) {
        this.cbtHasta = value;
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
     * Gets the value of the impTotConc property.
     * 
     */
    public double getImpTotConc() {
        return impTotConc;
    }

    /**
     * Sets the value of the impTotConc property.
     * 
     */
    public void setImpTotConc(double value) {
        this.impTotConc = value;
    }

    /**
     * Gets the value of the impNeto property.
     * 
     */
    public double getImpNeto() {
        return impNeto;
    }

    /**
     * Sets the value of the impNeto property.
     * 
     */
    public void setImpNeto(double value) {
        this.impNeto = value;
    }

    /**
     * Gets the value of the imptoLiq property.
     * 
     */
    public double getImptoLiq() {
        return imptoLiq;
    }

    /**
     * Sets the value of the imptoLiq property.
     * 
     */
    public void setImptoLiq(double value) {
        this.imptoLiq = value;
    }

    /**
     * Gets the value of the imptoLiqRni property.
     * 
     */
    public double getImptoLiqRni() {
        return imptoLiqRni;
    }

    /**
     * Sets the value of the imptoLiqRni property.
     * 
     */
    public void setImptoLiqRni(double value) {
        this.imptoLiqRni = value;
    }

    /**
     * Gets the value of the impOpEx property.
     * 
     */
    public double getImpOpEx() {
        return impOpEx;
    }

    /**
     * Sets the value of the impOpEx property.
     * 
     */
    public void setImpOpEx(double value) {
        this.impOpEx = value;
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

    /**
     * Gets the value of the fechaServDesde property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaServDesde() {
        return fechaServDesde;
    }

    /**
     * Sets the value of the fechaServDesde property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaServDesde(String value) {
        this.fechaServDesde = value;
    }

    /**
     * Gets the value of the fechaServHasta property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaServHasta() {
        return fechaServHasta;
    }

    /**
     * Sets the value of the fechaServHasta property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaServHasta(String value) {
        this.fechaServHasta = value;
    }

    /**
     * Gets the value of the fechaVencPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaVencPago() {
        return fechaVencPago;
    }

    /**
     * Sets the value of the fechaVencPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaVencPago(String value) {
        this.fechaVencPago = value;
    }

}
