package org.jliang.apps.cloud.service;

/**
 * 功能描述:消息生产者案例
 * 项目名称:spring_cloud_project_all_custom_demo
 *
 * @author lenovo
 * 创建日期:2020/3/22
 */
public interface ImessageProvider {
    /**
     * 发送消息
     *
     * @return String
     */
    String send();
}
