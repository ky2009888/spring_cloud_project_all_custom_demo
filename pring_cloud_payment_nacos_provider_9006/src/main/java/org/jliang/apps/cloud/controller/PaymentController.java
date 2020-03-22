package org.jliang.apps.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.jliang.apps.cloud.entity.CommonResult;
import org.jliang.apps.cloud.entity.Payment;
import org.jliang.apps.cloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2020-03-13 10:24:56
 */
@RestController
@RequestMapping("payment")
@Slf4j
public class PaymentController {
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;
    /**
     * 定义端口号
     */
    @Value("${server.port}")
    private String port;
    /**
     * 服务发现和注册.
     */
    @Resource
    private DiscoveryClient discoveryClient;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CommonResult<Payment> selectOne(Long id) {
        log.info("查询数据成功");
        Payment payment = this.paymentService.queryById(id);
        //timeOutShow();
        log.info("数据查询结束了");
        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功,port:" + port, payment);
        } else {
            return new CommonResult<Payment>(200, "未查询到主键" + id + "对应的数据,port:" + port, payment);
        }
    }

    /**
     * 请求超时的方法
     */
    private void timeOutShow() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.error("请求超时了:{}", e);
        }
    }

    /**
     * 添加数据到数据库
     *
     * @param payment 支付对象
     * @return CommonResult<Payment> 请求响应对象
     */
    @PostMapping("addPayment")
    public CommonResult<Payment> addPayment(Payment payment) {
        log.info("插入数据成功");
        Payment paymentResult = this.paymentService.insert(payment);
        if (paymentResult.getId() > 0) {
            return new CommonResult<Payment>(200, "添加数据成功,port:" + port, paymentResult);
        } else {
            return new CommonResult<Payment>(404, "添加数据失败,port:" + port, paymentResult);
        }
    }

    /**
     * 返回服务发现的信息
     *
     * @return Object
     */
    @GetMapping("discoveryInfo")
    public Object discoveryInfo() {
        List<String> services = discoveryClient.getServices();
        for (String element : services
        ) {
            log.info("****************element:{}", element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");
        for (ServiceInstance service : instances
        ) {
            log.info("{},{},{},{},{}", service.getHost(), service.getInstanceId(), service.getUri(), service.getPort(), service.getScheme());
        }
        return discoveryClient;
    }
}