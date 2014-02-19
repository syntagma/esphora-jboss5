
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Cmp_asoc complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Cmp_asoc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CBte_tipo" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="Cbte_punto_vta" type="{http://www.w3.org/2001/XMLSchema}short"/>
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
@XmlType(name = "Cmp_asoc", propOrder = {
    "cBteTipo",
    "cbtePuntoVta",
    "cbteNro"
})
public class CmpAsoc {

    @XmlElement(name = "CBte_tipo")
    protected short cBteTipo;
    @XmlElement(name = "Cbte_punto_vta")
    protected short cbtePuntoVta;
    @XmlElement(name = "Cbte_nro")
    protected long cbteNro;

    /**
     * Gets the value of the cBteTipo property.
     * 
     */
    public short getCBteTipo() {
        return cBteTipo;
    }

    /**
     * Sets the value of the cBteTipo property.
     * 
     */
    public void setCBteTipo(short value) {
        this.cBteTipo = value;
    }

    /**
     * Gets the value of the cbtePuntoVta property.
     * 
     */
    public short getCbtePuntoVta() {
        return cbtePuntoVta;
    }

    /**
     * Sets the value of the cbtePuntoVta property.
     * 
     */
    public void setCbtePuntoVta(short value) {
        this.cbtePuntoVta = value;
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
