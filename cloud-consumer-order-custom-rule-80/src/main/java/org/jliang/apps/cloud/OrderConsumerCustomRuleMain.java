package org.jliang.apps.cloud;

import lombok.extern.slf4j.Slf4j;
import org.jliang.apps.rules.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * 入口方法
 *
 * @author Lenovo
 * @RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = MySelfRule.class)
 * name：表示要访问的订单支付服务
 * configuration：定义访问的规则
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PROVIDER-PAYMENT", configuration = MySelfRule.class)
@Slf4j
public class OrderConsumerCustomRuleMain {
    /**
     * 主入口方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(OrderConsumerCustomRuleMain.class, args);
    }
}
