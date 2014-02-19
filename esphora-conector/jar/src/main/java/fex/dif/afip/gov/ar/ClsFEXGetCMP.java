
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClsFEXGetCMP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClsFEXGetCMP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Tipo_cbte" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Punto_vta" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Cbte_nro" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClsFEXGetCMP", propOrder = {
    "tipoCbte",
    "puntoVta",
    "cbteNro"
})
public class ClsFEXGetCMP {

    @XmlElement(name = "Tipo_cbte")
    protected short tipoCbte;
    @XmlElement(name = "Punto_vta")
    protected short puntoVta;
    @XmlElement(name = "Cbte_nro")
    protected long cbteNro;

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

}
