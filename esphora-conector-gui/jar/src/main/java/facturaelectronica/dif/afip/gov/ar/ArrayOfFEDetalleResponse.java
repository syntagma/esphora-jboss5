
package facturaelectronica.dif.afip.gov.ar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfFEDetalleResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfFEDetalleResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FEDetalleResponse" type="{http://ar.gov.afip.dif.facturaelectronica/}FEDetalleResponse" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfFEDetalleResponse", propOrder = {
    "feDetalleResponse"
})
public class ArrayOfFEDetalleResponse {

    @XmlElement(name = "FEDetalleResponse", nillable = true)
    protected List<FEDetalleResponse> feDetalleResponse;

    /**
     * Gets the value of the feDetalleResponse property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the feDetalleResponse property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFEDetalleResponse().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FEDetalleResponse }
     * 
     * 
     */
    public List<FEDetalleResponse> getFEDetalleResponse() {
        if (feDetalleResponse == null) {
            feDetalleResponse = new ArrayList<FEDetalleResponse>();
        }
        return this.feDetalleResponse;
    }

}
