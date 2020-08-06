
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
 *         &lt;element name="theCityCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="theUserID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "theCityCode",
    "theUserID"
})
@XmlRootElement(name = "getWeather")
public class GetWeather {

    protected String theCityCode;
    protected String theUserID;

    /**
     * Gets the value of the theCityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheCityCode() {
        return theCityCode;
    }

    /**
     * Sets the value of the theCityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheCityCode(String value) {
        this.theCityCode = value;
    }

    /**
     * Gets the value of the theUserID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheUserID() {
        return theUserID;
    }

    /**
     * Sets the value of the theUserID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheUserID(String value) {
        this.theUserID = value;
    }

}
