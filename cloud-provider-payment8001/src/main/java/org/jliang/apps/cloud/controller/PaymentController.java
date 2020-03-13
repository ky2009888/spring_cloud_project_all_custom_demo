package org.jliang.apps.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.jliang.apps.cloud.entity.CommonResult;
import org.jliang.apps.cloud.entity.Payment;
import org.jliang.apps.cloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public CommonResult<Payment> selectOne(Long id) {
        log.info("查询数据成功");
        Payment payment = this.paymentService.queryById(id);
        if (payment != null) {
            return new CommonResult<Payment>(200, "查询成功", payment);
        } else {
            return new CommonResult<Payment>(200, "未查询到主键" + id + "对应的数据", payment);
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
            return new CommonResult<Payment>(200, "添加数据成功", paymentResult);
        } else {
            return new CommonResult<Payment>(404, "添加数据失败", paymentResult);
        }

    }
}