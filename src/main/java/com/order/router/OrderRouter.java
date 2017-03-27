package com.order.router;

import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.Router;

import com.order.model.Order;

@MessageEndpoint
public class OrderRouter {

	@Router(inputChannel = "orderFlow.input")
	public String processOrder(Order order) {
		String result=null;
		if(order.getOrderType().equals("tea")) {
			result="teaChannel";
		}else {
			result="coffeeChannel";
		}
		return result;
	}
}
