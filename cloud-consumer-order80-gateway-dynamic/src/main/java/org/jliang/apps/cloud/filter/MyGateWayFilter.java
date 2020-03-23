package org.jliang.apps.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 定义过滤器
 *
 * @author Lenovo
 */
@Component("myGateWayFilter")
@Slf4j
public class MyGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("我已经进入自定义的过滤器了");
        String id = exchange.getRequest().getQueryParams().getFirst("id");
        log.info("我是在过滤器中id={}", id);
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
