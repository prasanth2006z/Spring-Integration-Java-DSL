package com.order;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.order.model.Order;
import com.order.service.OrderGateway;

/**
 * Hello world!
 *
 */
public class App 
{
	public void read() {
		
		Order order=new Order();
		order.setOrderId(1);
		order.setOrderName("Order is Coffee");
		order.setOrderType("coffee");
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
		OrderGateway orderGateway=context.getBean(OrderGateway.class);
		orderGateway.order(order);
	}

	public static void main(String[] args) {
		new App().read();
	}
}
