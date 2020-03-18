package org.jliang.apps.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单查询的消费端
 *
 * @author Lenovo
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker
public class CloudConsumerOrder80OpenfeignHystrixMain {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80OpenfeignHystrixMain.class, args);
    }
}
