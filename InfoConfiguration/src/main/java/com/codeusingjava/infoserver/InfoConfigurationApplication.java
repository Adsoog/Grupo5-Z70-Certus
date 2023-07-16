package com.codeusingjava.infoserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class InfoConfigurationApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoConfigurationApplication.class, args);
	}
}
