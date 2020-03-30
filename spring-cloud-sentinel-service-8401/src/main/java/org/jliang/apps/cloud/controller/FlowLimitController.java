package org.jliang.apps.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述:限流测试
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/3/30
 *
 * @author Lenovo
 */
@RestController
@RequestMapping("flow")
public class FlowLimitController {
    /**
     * A方法测试
     *
     * @return testA--------------------------------
     */
    @GetMapping("testA")
    public String testA() {
        return "testA--------------------------------";
    }

    /**
     * B方法测试
     *
     * @return testB--------------------------------
     */
    @GetMapping("testB")
    public String testB() {
        return "testB--------------------------------";
    }
}
