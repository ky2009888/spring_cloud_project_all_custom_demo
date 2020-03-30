package org.jliang.apps.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述:
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/3/30
 *
 * @author Lenovo
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudSentinelService8401 {
    /**
     * 命令启动主方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSentinelService8401.class, args);
    }
}
