package org.jliang.apps.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 配置spring的bean实例
 */
@Configuration
public class GateWayConfig {
    /**
     * 定义bean实例
     *
     * @param routeLocatorBuilder 路由构建builder
     * @return
     */
    @Bean
    public RouteLocator custmonRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        RouteLocator baiduRoute = routes.route("go_to_baidu_route", r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return baiduRoute;
    }
}
