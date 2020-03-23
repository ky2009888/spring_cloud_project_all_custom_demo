package org.jliang.apps.cloud.controller;

import org.jliang.apps.cloud.entity.CommonResult;
import org.jliang.apps.cloud.entity.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 功能描述:
 * 项目名称:spring_cloud_project_all_custom_demo
 * 创建日期:2020/3/23
 *
 * @author Lenovo
 */
@RequestMapping("order")
@RestController
public class OrderConsumerController {
    /**
     * 定义RestTemplate的句柄.
     */
    @Resource
    private RestTemplate restTemplate;
    /**
     * 定义服务的地址
     */
    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    /**
     * @return
     */
    @GetMapping("selectOne")
    public CommonResult<Payment> queryOrderById(Long id) {
        ResponseEntity<CommonResult> result = restTemplate.getForEntity(serviceUrl + "/payment/selectOne?id=" + id, CommonResult.class);
        int resultCode = result.getStatusCode().value();
        if (resultCode == 200) {
            CommonResult commonResult = result.getBody();
            return commonResult;
        }
        return new CommonResult<>(resultCode, "查询失败");
    }
}
