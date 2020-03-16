package org.jliang.apps.rules;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义规则类
 *
 * @author Lenovo
 */
@Configuration
public class MySelfRule {
    /**
     * 实例化rlue规则
     *
     * @return IRule
     */
    @Bean
    public IRule myRule() {
        //定义为随机分配模式
        return new RandomRule();
    }
}
