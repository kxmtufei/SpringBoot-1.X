package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringbootResttemplateApplication {
//	一个日志记录器，将输出发送到日志(本例中的控制台)。
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringbootResttemplateApplication.class);
//	一个RestTemplate，它使用Jackson JSON处理库来处理传入的数据。
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
//	CommandLineRunner在启动时运行RestTemplate(并因此获取我们的引用)。
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception{
		return args ->{
			Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			LOGGER.warn(quote.toString());
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootResttemplateApplication.class, args);
	}

}
