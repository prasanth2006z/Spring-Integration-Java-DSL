package com.order.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.stereotype.Component;

import com.order.model.Order;
import com.order.router.OrderRouter;
import com.order.service.CoffeeService;
import com.order.service.TeaService;

@Component
@EnableIntegration
@IntegrationComponentScan
public class GenericRouterFlow {

	@Autowired
	OrderRouter orderRouter;
	
	@Autowired
	TeaService teaService;
	
	@Autowired
	CoffeeService coffeeService;
	
	@Autowired
	DirectChannel coffeeChannel;
	
	@Autowired
	DirectChannel teaChannel;

	@Autowired
	DirectChannel smtpChannel;
	


	
	/*@Bean
	public IntegrationFlow orderFlow() {
		return f->f.gateway("Order.input")
				.route(orderRouter, "processOrder",
						m -> m.subFlowMapping("tea",
								sf -> sf.channel(teaChannel).publishSubscribeChannel(
										c -> c.subscribe(sub -> sub.handle(teaService, "makeTea"))))
								.subFlowMapping("coffee",
										sf -> sf.channel(coffeeChannel)
												.publishSubscribeChannel(c -> c
														.subscribe(sub -> sub.handle(coffeeService, "makeCoffee"))
														.subscribe(sub -> sub.handle(coffeeService, "makeCoffee1"))))
				)
				
				.transform((Order order) -> order.toString())
				.routeToRecipients(r -> r.recipient(smtpChannel))
				;
				
	}*/
	
	
	@Bean
	public IntegrationFlow orderFlow() {
		return IntegrationFlows.from("Order.input")
				.route(orderRouter, "processOrder",
						m -> m.subFlowMapping("tea",
								sf -> sf.channel(teaChannel).publishSubscribeChannel(
										c -> c.subscribe(sub -> sub.handle(teaService, "makeTea"))))
								.subFlowMapping("coffee",
										sf -> sf.channel(coffeeChannel)
												.publishSubscribeChannel(c -> c
														.subscribe(sub -> sub.handle(coffeeService, "makeCoffee"))
														.subscribe(sub -> sub
																.transform((Order order) -> order.toString())
																.routeToRecipients(r -> r.recipient(smtpChannel))
																)
														)		
										)
				)
				.get()
				;
	}
}
