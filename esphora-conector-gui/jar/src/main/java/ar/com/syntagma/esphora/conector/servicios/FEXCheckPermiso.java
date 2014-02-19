
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FEXCheck_Permiso complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEXCheck_Permiso">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idPermiso" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dstMerc" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "FEXCheck_Permiso", propOrder = {
    "idPermiso",
    "dstMerc",
    "cuit"
})
public class FEXCheckPermiso {

    protected String idPermiso;
    protected int dstMerc;
    protected long cuit;

    /**
     * Gets the value of the idPermiso property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdPermiso() {
        return idPermiso;
    }

    /**
     * Sets the value of the idPermiso property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdPermiso(String value) {
        this.idPermiso = value;
    }

    /**
     * Gets the value of the dstMerc property.
     * 
     */
    public int getDstMerc() {
        return dstMerc;
    }

    /**
     * Sets the value of the dstMerc property.
     * 
     */
    public void setDstMerc(int value) {
        this.dstMerc = value;
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
