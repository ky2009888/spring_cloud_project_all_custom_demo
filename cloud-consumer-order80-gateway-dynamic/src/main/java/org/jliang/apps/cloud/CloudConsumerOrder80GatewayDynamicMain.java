package org.jliang.apps.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * spring gateway 动态路由
 *
 * @author Lenovo
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConsumerOrder80GatewayDynamicMain {
    /**
     * 主入口方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerOrder80GatewayDynamicMain.class,args);
    }
}
