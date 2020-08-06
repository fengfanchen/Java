
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
 *         &lt;element name="getVersionTimeResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getVersionTimeResult"
})
@XmlRootElement(name = "getVersionTimeResponse")
public class GetVersionTimeResponse {

    protected String getVersionTimeResult;

    /**
     * Gets the value of the getVersionTimeResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetVersionTimeResult() {
        return getVersionTimeResult;
    }

    /**
     * Sets the value of the getVersionTimeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetVersionTimeResult(String value) {
        this.getVersionTimeResult = value;
    }

}
