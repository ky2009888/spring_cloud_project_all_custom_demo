package org.jliang.apps.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * payment 启动类
 *
 * @author Lenovo
 */
@SpringBootApplication
@MapperScan("org.jliang.apps.cloud.dao")
@EnableEurekaClient
@EnableDiscoveryClient
public class SpringCloudPaymentMain8001 {
    /**
     * spring boot 主启动类
     *
     * @param args 命令行入参
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPaymentMain8001.class, args);
    }
}
