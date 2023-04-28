package com.lekwacious.monitor_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MonitorAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorAppApplication.class, args);
	}
//
//	@Bean
//	public HttpExchangeRepository httpTraceRepository() {
//		System.out.println(new InMemoryHttpExchangeRepository().findAll());
//		return new InMemoryHttpExchangeRepository();
//	}
}
