package org.jliang.apps.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 网关项目的启动类
 *
 * @author Lenovo
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConsumerOrder80GatewayMain {
    /**
     * 主启动方法
     *
     * @param args 命令行入参
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80GatewayMain.class, args);
    }
}
