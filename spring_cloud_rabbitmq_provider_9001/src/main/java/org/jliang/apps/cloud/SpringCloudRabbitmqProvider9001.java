package org.jliang.apps.cloud;

/**
 * @author Lenovo
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 订单消费端
 *
 * @author Lenovo
 */
@SpringBootApplication
@Slf4j
@EnableEurekaClient
public class SpringCloudRabbitmqProvider9001 {
    /**
     * 主启动类
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRabbitmqProvider9001.class, args);
    }
}
