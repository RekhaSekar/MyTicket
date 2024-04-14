package com.ticket.myticket.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ticket.myticket.Util.JWTUtil;

@Configuration
public class TicketConfiguration {

	@Bean
	Filter getFilter() {
		return new MyFilter();
	}
}
