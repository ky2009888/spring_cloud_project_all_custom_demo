package org.jliang.apps.cloud.service;

import org.jliang.apps.cloud.entity.CommonResult;
import org.jliang.apps.cloud.entity.Payment;

/**
 * fallback 实现方法
 *
 * @author Lenovo
 */
public class PaymentFeignServiceImpl implements PaymentFeignService {
    /**
     * 通过主键查询单条数据
     * 当使用feign传参数的时候,需要加上@RequestParam注解,否则对方服务无法识别参数
     *
     * @param id 主键
     * @return 单条数据
     */
    @Override
    public CommonResult<Payment> selectOne(Long id) {
        return new CommonResult<Payment>(500, "全局方法:服务器繁忙,port:80", new Payment());
    }
}
