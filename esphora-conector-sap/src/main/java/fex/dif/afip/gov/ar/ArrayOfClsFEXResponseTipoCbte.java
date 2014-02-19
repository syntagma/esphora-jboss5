
package fex.dif.afip.gov.ar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClsFEXResponse_Tipo_Cbte complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsFEXResponse_Tipo_Cbte">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClsFEXResponse_Tipo_Cbte" type="{http://ar.gov.afip.dif.fex/}ClsFEXResponse_Tipo_Cbte" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsFEXResponse_Tipo_Cbte", propOrder = {
    "clsFEXResponseTipoCbte"
})
public class ArrayOfClsFEXResponseTipoCbte {

    @XmlElement(name = "ClsFEXResponse_Tipo_Cbte", nillable = true)
    protected List<ClsFEXResponseTipoCbte> clsFEXResponseTipoCbte;

    /**
     * Gets the value of the clsFEXResponseTipoCbte property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsFEXResponseTipoCbte property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsFEXResponseTipoCbte().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsFEXResponseTipoCbte }
     * 
     * 
     */
    public List<ClsFEXResponseTipoCbte> getClsFEXResponseTipoCbte() {
        if (clsFEXResponseTipoCbte == null) {
            clsFEXResponseTipoCbte = new ArrayList<ClsFEXResponseTipoCbte>();
        }
        return this.clsFEXResponseTipoCbte;
    }

}
