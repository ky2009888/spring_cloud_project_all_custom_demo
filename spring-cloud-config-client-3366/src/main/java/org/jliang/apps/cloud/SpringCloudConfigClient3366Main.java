package org.jliang.apps.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Lenovo
 */
@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfigClient3366Main {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClient3366Main.class, args);
    }
}
