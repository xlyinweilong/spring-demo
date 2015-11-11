package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import com.example.controller.*;

@SpringBootApplication
@EnableScheduling
public class DemoApplication{

//	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
//		SpringApplication.run(DemoApplication.class, args);
		SpringApplication.run(DemoApplication.class);
	}

//	@Override
//	public void run(String... strings) throws Exception {
//		RestTemplate restTemplate = new RestTemplate();
//		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
//		log.info(quote.toString());
//	}
}
