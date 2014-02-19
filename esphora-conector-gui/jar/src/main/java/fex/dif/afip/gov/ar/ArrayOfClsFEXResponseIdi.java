
package fex.dif.afip.gov.ar;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfClsFEXResponse_Idi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfClsFEXResponse_Idi">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ClsFEXResponse_Idi" type="{http://ar.gov.afip.dif.fex/}ClsFEXResponse_Idi" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfClsFEXResponse_Idi", propOrder = {
    "clsFEXResponseIdi"
})
public class ArrayOfClsFEXResponseIdi {

    @XmlElement(name = "ClsFEXResponse_Idi", nillable = true)
    protected List<ClsFEXResponseIdi> clsFEXResponseIdi;

    /**
     * Gets the value of the clsFEXResponseIdi property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clsFEXResponseIdi property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClsFEXResponseIdi().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClsFEXResponseIdi }
     * 
     * 
     */
    public List<ClsFEXResponseIdi> getClsFEXResponseIdi() {
        if (clsFEXResponseIdi == null) {
            clsFEXResponseIdi = new ArrayList<ClsFEXResponseIdi>();
        }
        return this.clsFEXResponseIdi;
    }

}
