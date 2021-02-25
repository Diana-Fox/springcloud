package com.diana.springcloud.payment.service.impl;


import com.diana.springcloud.entities.Payment;
import com.diana.springcloud.payment.dao.PaymentDao;
import com.diana.springcloud.payment.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(@Param("id") Long id) {

        return paymentDao.getPaymentById(id);
    }
}
