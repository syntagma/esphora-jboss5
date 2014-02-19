
package ar.com.syntagma.esphora.conector.servicios;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import fex.dif.afip.gov.ar.FEXResponseCheckPermiso;


/**
 * <p>Java class for FEXCheck_PermisoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FEXCheck_PermisoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="return" type="{http://ar.gov.afip.dif.fex/}FEXResponse_CheckPermiso" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FEXCheck_PermisoResponse", propOrder = {
    "_return"
})
public class FEXCheckPermisoResponse {

    @XmlElement(name = "return")
    protected FEXResponseCheckPermiso _return;

    /**
     * Gets the value of the return property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseCheckPermiso }
     *     
     */
    public FEXResponseCheckPermiso getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseCheckPermiso }
     *     
     */
    public void setReturn(FEXResponseCheckPermiso value) {
        this._return = value;
    }

}
