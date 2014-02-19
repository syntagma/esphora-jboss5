
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import facturaelectronica.dif.afip.gov.ar.FEConsultaCAEReq;


/**
 * <p>Java class for FEConsultaCAERequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEConsultaCAERequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FEConsultaCAEReq" type="{http://ar.gov.afip.dif.facturaelectronica/}FEConsultaCAEReq" minOccurs="0"/>
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
@XmlType(name = "FEConsultaCAERequest", propOrder = {
    "feConsultaCAEReq",
    "cuit"
})
public class FEConsultaCAERequest {

    @XmlElement(name = "FEConsultaCAEReq")
    protected FEConsultaCAEReq feConsultaCAEReq;
    protected long cuit;

    /**
     * Gets the value of the feConsultaCAEReq property.
     * 
     * @return
     *     possible object is
     *     {@link FEConsultaCAEReq }
     *     
     */
    public FEConsultaCAEReq getFEConsultaCAEReq() {
        return feConsultaCAEReq;
    }

    /**
     * Sets the value of the feConsultaCAEReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEConsultaCAEReq }
     *     
     */
    public void setFEConsultaCAEReq(FEConsultaCAEReq value) {
        this.feConsultaCAEReq = value;
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
