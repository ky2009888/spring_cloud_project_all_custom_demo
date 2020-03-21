package org.jliang.apps.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lenovo
 */
@RestController
@RequestMapping("get")
public class GetPropertiesController {
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
