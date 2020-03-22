package org.jliang.apps.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * 功能描述:
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/3/22
 *
 * @author Lenovo
 */
@Component
@EnableBinding(Sink.class)
@Slf4j
public class ReceiveMessageController {
    /**
     * 获取端口号
     */
    @Value("${server.port}")
    private String serverPort;

    /**
     * 消息发送的方法
     *
     * @return SUCCESS
     */
    @StreamListener(Sink.INPUT)
    public void receiveMessage(Message<String> message) {
        log.info("端口号:{},接收到的消息:{}", serverPort, message.getPayload());
    }
}
