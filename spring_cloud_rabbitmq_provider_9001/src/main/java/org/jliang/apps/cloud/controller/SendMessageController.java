package org.jliang.apps.cloud.controller;

import org.jliang.apps.cloud.service.ImessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 功能描述:
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/3/22
 */
@RestController
@RequestMapping("provider")
public class SendMessageController {
    /**
     * 定义消息通道的句柄
     */
    @Resource
    private ImessageProvider imessageProvider;

    /**
     * 消息发送的方法
     *
     * @return SUCCESS
     */
    @GetMapping("send")
    public String sendMessage() {
        imessageProvider.send();
        return "SUCCESS";
    }
}
