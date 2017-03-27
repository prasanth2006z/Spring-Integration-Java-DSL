package com.order.service;

import org.springframework.messaging.Message;

import com.order.model.Order;

public class TeaService {
	public void makeTea(Message<Order> orderMsg) {
		Order ord=orderMsg.getPayload();
		System.out.println("Order is =====>"+ord.getOrderName());
	} 
}
