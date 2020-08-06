
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
 *         &lt;element name="getCountryCityByIpResult" type="{http://WebXml.com.cn/}ArrayOfString" minOccurs="0"/>
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
    "getCountryCityByIpResult"
})
@XmlRootElement(name = "getCountryCityByIpResponse")
public class GetCountryCityByIpResponse {

    protected ArrayOfString getCountryCityByIpResult;

    /**
     * Gets the value of the getCountryCityByIpResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfString }
     *     
     */
    public ArrayOfString getGetCountryCityByIpResult() {
        return getCountryCityByIpResult;
    }

    /**
     * Sets the value of the getCountryCityByIpResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfString }
     *     
     */
    public void setGetCountryCityByIpResult(ArrayOfString value) {
        this.getCountryCityByIpResult = value;
    }

}
