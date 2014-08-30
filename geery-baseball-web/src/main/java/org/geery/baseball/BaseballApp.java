package org.geery.baseball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class BaseballApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(BaseballApp.class, args);
	}

}
