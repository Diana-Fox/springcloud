package com.diana.springcloud.controller;

import com.diana.springcloud.config.GlobalConfig;
import com.diana.springcloud.entities.CommentResult;
import com.diana.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/create")
    public CommentResult create(Payment payment) {
        return restTemplate.postForObject(GlobalConfig.PAYMENT_URL + "/payment/create", payment, CommentResult.class);
    }
    @GetMapping("/consumer/{id}")
    public CommentResult getPayment(@PathVariable("id") Long id){
        return restTemplate.getForObject(GlobalConfig.PAYMENT_URL+"/payment/get/"+id,CommentResult.class);
    }
}
