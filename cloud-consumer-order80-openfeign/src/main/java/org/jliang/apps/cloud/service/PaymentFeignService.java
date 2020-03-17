package org.jliang.apps.cloud.service;

import org.jliang.apps.cloud.entity.CommonResult;
import org.jliang.apps.cloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * feign的客户端调用服务端的接口类
 *
 * @author Lenovo
 */
@Component("paymentFeignService")
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {

    /**
     * 通过主键查询单条数据
     * 当使用feign传参数的时候,需要加上@RequestParam注解,否则对方服务无法识别参数
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/payment/selectOne")
    CommonResult<Payment> selectOne(@RequestParam(value = "id") Long id);
}
