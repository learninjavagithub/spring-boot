package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringCloudM2ConfigServerGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM2ConfigServerGitApplication.class, args);
	}
}
