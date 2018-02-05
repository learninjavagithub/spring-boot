package com.example.demo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.common.AuthenticationScheme;

@SpringBootApplication
public class SpringCloudM4SecureCliApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM4SecureCliApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println("starting cron job...");
		
		ResourceOwnerPasswordResourceDetails resourceDetails = new ResourceOwnerPasswordResourceDetails();
		// Since its a CLI we dont have a form so using a header
		resourceDetails.setClientAuthenticationScheme(AuthenticationScheme.header); 
		resourceDetails.setAccessTokenUri("http://localhost:9000/services/oauth/token");
		
		resourceDetails.setUsername("angry");
		resourceDetails.setPassword("bird");
		
		resourceDetails.setScope(Arrays.asList("price_read"));
		resourceDetails.setClientId("learninjava");
		resourceDetails.setClientSecret("learninjavasecret");
		
		OAuth2RestTemplate template = new OAuth2RestTemplate(resourceDetails);
		System.out.println("Token is : " + template.getAccessToken());
		
		String data = template.getForObject("http://localhost:9001/services/pricedata", String.class);
		
		System.out.println("Result : " + data);
	}
}
