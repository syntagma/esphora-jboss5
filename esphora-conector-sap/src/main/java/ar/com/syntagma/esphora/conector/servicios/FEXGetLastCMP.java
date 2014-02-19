
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FEXGetLast_CMP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEXGetLast_CMP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoComprobante" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="puntoVenta" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="cuit" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEXGetLast_CMP", propOrder = {
    "tipoComprobante",
    "puntoVenta",
    "cuit"
})
public class FEXGetLastCMP {

    protected short tipoComprobante;
    protected short puntoVenta;
    protected long cuit;

    /**
     * Gets the value of the tipoComprobante property.
     * 
     */
    public short getTipoComprobante() {
        return tipoComprobante;
    }

    /**
     * Sets the value of the tipoComprobante property.
     * 
     */
    public void setTipoComprobante(short value) {
        this.tipoComprobante = value;
    }

    /**
     * Gets the value of the puntoVenta property.
     * 
     */
    public short getPuntoVenta() {
        return puntoVenta;
    }

    /**
     * Sets the value of the puntoVenta property.
     * 
     */
    public void setPuntoVenta(short value) {
        this.puntoVenta = value;
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

}
