package org.jliang.apps.cloud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 实例的配置类
 *
 * @author Lenovo
 */
@Configuration
public class ApplicationContext {
    /**
     * 定义RestTemplate的实例
     *
     * @return RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
