package com.order.service;

import org.springframework.messaging.Message;

import com.order.model.Order;

public class CoffeeService {

	public void makeCoffee(Message<Order> orderMsg) {
		System.out.println("Order is =====>"+orderMsg.getPayload().getOrderName());
	}
	
	public void makeCoffee1(Message<Order> orderMsg) {
		System.out.println("New Order is =====>"+orderMsg.getPayload().getOrderName());
	}
}
