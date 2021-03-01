package cn.it1995.config;

import cn.it1995.properties.TestServiceProperties;
import cn.it1995.service.TestService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(TestService.class)
@ConditionalOnProperty(name = "test-config.enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(TestServiceProperties.class)
public class TestServiceAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public TestService testService(TestServiceProperties testServiceProperties){

        return new TestService(testServiceProperties.getHost(), testServiceProperties.getPort());
    }
}
