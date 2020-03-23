package org.jliang.apps.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述:
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/3/23
 */
@RestController
@RequestMapping("get")
@RefreshScope
public class NacosClientController {
    /**
     * 定义信息
     */
    @Value("${config.info}")
    private String configInfo;

    /**
     * 获取configInfo的信息
     *
     * @return configInfo
     */
    @GetMapping("gtProper")
    public String getProper() {
        return configInfo;
    }
}
