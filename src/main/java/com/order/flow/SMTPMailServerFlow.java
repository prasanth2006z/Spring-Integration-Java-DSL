package com.order.flow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.mail.Mail;
import org.springframework.stereotype.Component;

@Component
@EnableIntegration
@IntegrationComponentScan
public class SMTPMailServerFlow {
	
	@Autowired
	DirectChannel smtpChannel;
	
	@Bean
	public IntegrationFlow sendMailFlow() {
	    return IntegrationFlows.from(smtpChannel)
	    		.enrichHeaders(
	    				Mail.headers()
	    				.subjectFunction(m->"Email SUbj")
	    				.from("prasanth2006z@gmail.com")
	    				.toFunction(m -> new String[] { "prasanth2006z@gmail.com" }))
	            .handle(
	            		Mail.outboundAdapter("smtp.gmail.com")
	                            .port(587)
	                            .credentials("xxxx", "xxxx")
	                            .protocol("smtp")
	                            .javaMailProperties(p -> p
	                            		.put("mail.debug", "true")
	                            		.put("mail.smtps.auth", "true")
	                            		.put("mail.smtp.starttls.enable", "true")
	                            		), e -> e.id("SMTPOutBoundMailChannel")
	                            )
	            				.get();
	}
}
