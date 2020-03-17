package org.jliang.apps.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单消费端
 *
 * @author Lenovo
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
@EnableFeignClients
public class CloudConsumerOrder80Openfeign {
    /**
     * 主启动类
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80Openfeign.class, args);
    }
}
