
package facturaelectronica.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FEResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FecResp" type="{http://ar.gov.afip.dif.facturaelectronica/}FECabeceraResponse" minOccurs="0"/>
 *         &lt;element name="FedResp" type="{http://ar.gov.afip.dif.facturaelectronica/}ArrayOfFEDetalleResponse" minOccurs="0"/>
 *         &lt;element name="RError" type="{http://ar.gov.afip.dif.facturaelectronica/}vError" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEResponse", propOrder = {
    "fecResp",
    "fedResp",
    "rError"
})
public class FEResponse {

    @XmlElement(name = "FecResp")
    protected FECabeceraResponse fecResp;
    @XmlElement(name = "FedResp")
    protected ArrayOfFEDetalleResponse fedResp;
    @XmlElement(name = "RError")
    protected VError rError;

    /**
     * Gets the value of the fecResp property.
     * 
     * @return
     *     possible object is
     *     {@link FECabeceraResponse }
     *     
     */
    public FECabeceraResponse getFecResp() {
        return fecResp;
    }

    /**
     * Sets the value of the fecResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link FECabeceraResponse }
     *     
     */
    public void setFecResp(FECabeceraResponse value) {
        this.fecResp = value;
    }

    /**
     * Gets the value of the fedResp property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfFEDetalleResponse }
     *     
     */
    public ArrayOfFEDetalleResponse getFedResp() {
        return fedResp;
    }

    /**
     * Sets the value of the fedResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfFEDetalleResponse }
     *     
     */
    public void setFedResp(ArrayOfFEDetalleResponse value) {
        this.fedResp = value;
    }

    /**
     * Gets the value of the rError property.
     * 
     * @return
     *     possible object is
     *     {@link VError }
     *     
     */
    public VError getRError() {
        return rError;
    }

    /**
     * Sets the value of the rError property.
     * 
     * @param value
     *     allowed object is
     *     {@link VError }
     *     
     */
    public void setRError(VError value) {
        this.rError = value;
    }

}
