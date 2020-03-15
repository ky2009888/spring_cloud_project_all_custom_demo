package org.jliang.apps.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.jliang.apps.cloud.entity.CommonResult;
import org.jliang.apps.cloud.entity.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Lenovo
 */
@RestController
@RequestMapping("order")
@Slf4j
public class OrderController {
    /**
     * 定义订单服务请求的基础路径
     * 单机版
     */
    //private static final String CLOUD_PROVIDER_PAYMENT_URL_BASE = "http://localhost:8001/payment/";
    /**
     * 定义订单服务请求的基础路径
     * 集群版
     */
    private static final String CLOUD_PROVIDER_PAYMENT_URL_BASE = "http://cloud-provider-payment/payment/";
    /**
     * 定义RestTemplate的句柄
     */
    @Resource
    private RestTemplate restTemplate;

    /**
     * 添加数据到数据库
     *
     * @param payment 支付对象
     * @return CommonResult<Payment> 请求响应对象
     */
    @PostMapping("orderPay")
    public CommonResult<Payment> addPayment(Payment payment) {
        return restTemplate.postForObject(CLOUD_PROVIDER_PAYMENT_URL_BASE + "addPayment", payment, CommonResult.class);
    }

    /**
     * 通过主键查询支付单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CommonResult<Payment> selectOne(Long id) {
        log.info("id:{}",id);
        return restTemplate.getForObject(CLOUD_PROVIDER_PAYMENT_URL_BASE + "selectOne?id="+id,  CommonResult.class);
    }
}
