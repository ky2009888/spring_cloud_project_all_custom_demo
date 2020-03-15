package org.jliang.apps.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 支付的服务端
 *
 * @author Lenovo
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(value = "org.jliang.apps.cloud.dao")
public class SpringCloudPaymentMain8004 {
    /**
     * 主入口方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPaymentMain8004.class, args);
    }
}

