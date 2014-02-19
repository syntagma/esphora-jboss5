
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FECabeceraRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FECabeceraRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="cantidadreg" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlType(name = "FECabeceraRequest", propOrder = {
    "id",
    "cantidadreg",
    "prestaServ"
})
public class FECabeceraRequest {

    protected long id;
    protected int cantidadreg;
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
