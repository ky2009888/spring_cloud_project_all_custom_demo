package org.jliang.apps.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述:
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/3/22
 *
 * @author Lenovo
 */
@SpringBootApplication
@MapperScan("org.jliang.apps.cloud.dao")
@EnableDiscoveryClient
public class SpringCloudPaymentNacosProviderMain9005 {
    /**
     * spring boot 主启动类
     *
     * @param args 命令行入参
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudPaymentNacosProviderMain9005.class, args);
    }
}
