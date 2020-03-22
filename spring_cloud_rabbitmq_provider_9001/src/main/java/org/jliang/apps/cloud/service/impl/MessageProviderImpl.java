package org.jliang.apps.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.jliang.apps.cloud.service.ImessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 功能描述: 消息的生产者
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/3/22
 *
 * @author Lenovo
 */
@EnableBinding(Source.class)
@Slf4j
@Component("imessageProvider")
public class MessageProviderImpl implements ImessageProvider {
    /**
     * 定义消息的管道句柄.
     */
    @Resource
    private MessageChannel output;

    /**
     * 发送消息
     *
     * @return String
     */
    @Override
    public String send() {
        String id = IdUtil.simpleUUID();
        boolean send = output.send(MessageBuilder.withPayload(id).build());
        log.info("发送的结果:{},发送的内容:{}", send, id);
        return null;
    }
}
