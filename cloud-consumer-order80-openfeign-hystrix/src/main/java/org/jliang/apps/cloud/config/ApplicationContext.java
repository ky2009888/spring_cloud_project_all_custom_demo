package org.jliang.apps.cloud.config;

import feign.Logger;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
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
     * @LoadBalanced 开启集群模式
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public Logger.Level levelLogger() {
        return Logger.Level.FULL;
    }
}
