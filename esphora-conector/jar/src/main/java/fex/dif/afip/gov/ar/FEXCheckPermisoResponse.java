
package fex.dif.afip.gov.ar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FEXCheck_PermisoResult" type="{http://ar.gov.afip.dif.fex/}FEXResponse_CheckPermiso" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "fexCheckPermisoResult"
})
@XmlRootElement(name = "FEXCheck_PermisoResponse")
public class FEXCheckPermisoResponse {

    @XmlElement(name = "FEXCheck_PermisoResult")
    protected FEXResponseCheckPermiso fexCheckPermisoResult;

    /**
     * Gets the value of the fexCheckPermisoResult property.
     * 
     * @return
     *     possible object is
     *     {@link FEXResponseCheckPermiso }
     *     
     */
    public FEXResponseCheckPermiso getFEXCheckPermisoResult() {
        return fexCheckPermisoResult;
    }

    /**
     * Sets the value of the fexCheckPermisoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link FEXResponseCheckPermiso }
     *     
     */
    public void setFEXCheckPermisoResult(FEXResponseCheckPermiso value) {
        this.fexCheckPermisoResult = value;
    }

}
