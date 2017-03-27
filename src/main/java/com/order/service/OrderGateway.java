package com.order.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

import com.order.model.Order;


@MessagingGateway
public interface OrderGateway {
	@Gateway(requestChannel = "orderFlow.input")
	void order(Order order);
}
