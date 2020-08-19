package cn.it1995.server;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import java.util.Properties;

@EnableWs
@Configuration
public class SoapServerConfig {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext){

        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "it1995")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema){

        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("IT1995Port");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTransportUri("http://it1995.cn/webservice");
        wsdl11Definition.setSchema(schema);

        //为动态生成的wsdl添加soap action
        Properties soapActions = new Properties();
        soapActions.setProperty("getTest", "http://it1995.cn/getTestRequest");
        wsdl11Definition.setSoapActions(soapActions);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema it1995Schema(){

        return new SimpleXsdSchema(new ClassPathResource("xsd/MyData.xsd"));
    }
}
