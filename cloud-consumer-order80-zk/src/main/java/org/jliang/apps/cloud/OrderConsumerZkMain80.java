package org.jliang.apps.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * OrderConsumer的zookeeper客户端案例
 *
 * @author Lenovo
 */
@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class OrderConsumerZkMain80 {
    /**
     * 主入口方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerZkMain80.class, args);
    }
}
