package org.jliang.apps.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.jliang.apps.cloud.entity.CommonResult;
import org.jliang.apps.cloud.entity.Payment;
import org.jliang.apps.cloud.service.PaymentFeignService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

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
    private static final String CLOUD_PROVIDER_PAYMENT_URL_BASE = "http://CLOUD-PROVIDER-HYSTRIX-PAYMENT/payment/";
    /**
     * 定义RestTemplate的句柄
     */
    @Resource
    private RestTemplate restTemplate;
    /**
     * 定义paymentFeignService句柄
     */
    @Resource
    private PaymentFeignService paymentFeignService;

    /**
     * 通过主键查询支付单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneWithFeign")
    public CommonResult<Payment> selectOneWithFeign(Long id) {
        log.info("selectOneWithFeign->id:{}", id);
        return paymentFeignService.selectOne(id);
    }

    /**
     * 通过主键查询支付单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneWithFeignH")
    @HystrixCommand(fallbackMethod = "selectOneWithFeignHBackup", groupKey = "selectOneBackupThread", threadPoolKey = "selectOneBackupThreadPoolKey",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public CommonResult<Payment> selectOneWithFeignH(Long id) {
        log.info("selectOneWithFeign->id:{}", id);
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return paymentFeignService.selectOne(id);
    }

    /**
     * 容错的时候使用的方法
     *
     * @param id 使用ID
     * @return CommonResult<Payment>
     */
    public CommonResult<Payment> selectOneWithFeignHBackup(Long id) {
        log.info("服务器繁忙,port:80----》消费端");
        return new CommonResult<Payment>(500, "服务器繁忙,port:80", new Payment());
    }

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
        log.info("id:{}", id);
        return restTemplate.getForObject(CLOUD_PROVIDER_PAYMENT_URL_BASE + "selectOne?id=" + id, CommonResult.class);
    }


    /**
     * 通过主键查询支付单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOneWithEntity")
    public CommonResult<Payment> selectOneWithEntity(Long id) {
        log.info("id:{}", id);
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(CLOUD_PROVIDER_PAYMENT_URL_BASE + "selectOne?id=" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return new CommonResult<Payment>(entity.getStatusCode().value(), "查询订单失败");
        }
    }
}
