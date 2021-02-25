package com.diana.springcloud.payment.controller;

import com.diana.springcloud.entities.CommentResult;
import com.diana.springcloud.entities.Payment;
import com.diana.springcloud.payment.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommentResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);
        if (result > 0)
            return new CommentResult(200, "插入成功", result);
        return new CommentResult(500, "插入失败");
    }

    @GetMapping("/payment/get/{id}")
    public CommentResult getPaymentById(@PathVariable Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("*****插入结果：" + result);
        if (result != null)
            return new CommentResult(200, "查询成功", result);
        return new CommentResult(500, "查询失败，没有id为" + id + "的记录");
    }

}
