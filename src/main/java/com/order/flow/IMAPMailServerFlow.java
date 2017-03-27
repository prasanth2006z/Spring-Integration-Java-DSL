package com.order.flow;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

public class IMAPMailServerFlow {
	
	
	
	
	/*	@Bean
	public IntegrationFlow ImapFlow() {
		return IntegrationFlows.from(
							Mail
							.imapIdleAdapter(
									"imap://xxxx:xxxx@gmail.com:993/INBOX"
									)
							.id("IMAP_Mail_Flow")
							.autoStartup(true)
							.javaMailProperties(p -> p
									.put("mail.debug", "true")
									//.put("mail.imap.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
									//.put("mail.imap.socketFactory.fallback", "false")
							   	    .put("mail.imaps.auth.plain.disable", "true")
							   	    .put("mail.imaps.auth.ntlm.disable", "true")
							   	    .put("mail.imaps.auth.gssapi.disable", "true")
							   	    .put("mail.imap.starttls.enable", "true")
							   	    .put("mail.imaps.socketFactory.port", "993")
						   )
					)
				
				.enrichHeaders(s -> s.headerExpressions(h -> h
						.put("subject", "payload.subject")
						.put("from", "payload.from[0].toString()")))
				
				.get();
	}*/
}
