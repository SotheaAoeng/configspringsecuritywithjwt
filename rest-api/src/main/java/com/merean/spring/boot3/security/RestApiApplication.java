package com.merean.spring.boot3.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan("com.merean.spring.boot3.security.properties")
public class RestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApiApplication.class, args);
	}

//	@Bean
//	ApplicationRunner runner() {
//		return args -> {
//            System.out.println(PasswordUtils.encrypt("sothea"));
//        };
//	}

}
