package com.example.demo;

import org.springframework.core.annotation.Order;

public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public void placeOrder(){
        paymentService.processPayment(504.00);
    }
}
