package com.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.core.Pollers;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;

import com.order.router.OrderRouter;
import com.order.service.CoffeeService;
import com.order.service.TeaService;

@Configuration
@EnableIntegration
@IntegrationComponentScan
@ComponentScan(basePackages = "com.order")
public class AppConfig {

	@Bean
	public TeaService teaService() {
		return new TeaService();
	}

	@Bean
	public OrderRouter orderRouter() {
		return new OrderRouter();
	}

	@Bean
	public CoffeeService coffeeService() {
		return new CoffeeService();
	}

	@Bean
	public DirectChannel teaChannel() {
		return new DirectChannel();
	}

	@Bean
	public DirectChannel coffeeChannel() {
		return new DirectChannel();
	}

	@Bean(name = PollerMetadata.DEFAULT_POLLER)
	public PollerMetadata poller() {
		return Pollers.fixedDelay(1000).get();
	}

	@Bean
	public DirectChannel smtpChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public DirectChannel imapChannel() {
		return new DirectChannel();
	}
	
	@Bean
	public MessageChannel defaultOutputChannel() {
		return new QueueChannel();
	}


}
