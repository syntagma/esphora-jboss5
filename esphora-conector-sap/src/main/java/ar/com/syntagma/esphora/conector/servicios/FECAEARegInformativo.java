
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import fev1.dif.afip.gov.ar.FECAEARequest;


/**
 * <p>Java class for FECAEARegInformativo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FECAEARegInformativo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feCAEARegInfReq" type="{http://ar.gov.afip.dif.FEV1/}FECAEARequest" minOccurs="0"/>
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
@XmlType(name = "FECAEARegInformativo", propOrder = {
    "feCAEARegInfReq",
    "cuit"
})
public class FECAEARegInformativo {

    protected FECAEARequest feCAEARegInfReq;
    protected long cuit;

    /**
     * Gets the value of the feCAEARegInfReq property.
     * 
     * @return
     *     possible object is
     *     {@link FECAEARequest }
     *     
     */
    public FECAEARequest getFeCAEARegInfReq() {
        return feCAEARegInfReq;
    }

    /**
     * Sets the value of the feCAEARegInfReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link FECAEARequest }
     *     
     */
    public void setFeCAEARegInfReq(FECAEARequest value) {
        this.feCAEARegInfReq = value;
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
