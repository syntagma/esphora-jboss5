
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FERequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FERequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Fecr" type="{http://ar.gov.afip.dif.facturaelectronica/}FECabeceraRequest" minOccurs="0"/>
 *         &lt;element name="Fedr" type="{http://ar.gov.afip.dif.facturaelectronica/}ArrayOfFEDetalleRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FERequest", propOrder = {
    "fecr",
    "fedr"
})
public class FERequest {

    @XmlElement(name = "Fecr")
    protected FECabeceraRequest fecr;
    @XmlElement(name = "Fedr")
    protected ArrayOfFEDetalleRequest fedr;

    /**
     * Gets the value of the fecr property.
     * 
     * @return
     *     possible object is
     *     {@link FECabeceraRequest }
     *     
     */
    public FECabeceraRequest getFecr() {
        return fecr;
    }

    /**
     * Sets the value of the fecr property.
     * 
     * @param value
     *     allowed object is
     *     {@link FECabeceraRequest }
     *     
     */
    public void setFecr(FECabeceraRequest value) {
        this.fecr = value;
    }

    /**
     * Gets the value of the fedr property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFEDetalleRequest }
     *     
     */
    public ArrayOfFEDetalleRequest getFedr() {
        return fedr;
    }

    /**
     * Sets the value of the fedr property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFEDetalleRequest }
     *     
     */
    public void setFedr(ArrayOfFEDetalleRequest value) {
        this.fedr = value;
    }

}
