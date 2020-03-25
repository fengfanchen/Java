package com.email.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "mail")
public class EmailConfig {

    @Value("${mail.mailFrom}")
    private String mailMailFrom;

    @Value("${mail.domainName}")
    private String mailDomainName;
}
