package org.jliang.apps.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述:
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/3/23
 *
 * @author Lenovo
 */
@SpringBootApplication
@EnableDiscoveryClient(autoRegister = true)
@Slf4j
public class CloudConsumerCrderNacos80 {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerCrderNacos80.class, args);
    }
}
