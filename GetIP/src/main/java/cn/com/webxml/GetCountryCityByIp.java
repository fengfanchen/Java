
package cn.com.webxml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="theIpAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "theIpAddress"
})
@XmlRootElement(name = "getCountryCityByIp")
public class GetCountryCityByIp {

    protected String theIpAddress;

    /**
     * Gets the value of the theIpAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheIpAddress() {
        return theIpAddress;
    }

    /**
     * Sets the value of the theIpAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheIpAddress(String value) {
        this.theIpAddress = value;
    }

}
