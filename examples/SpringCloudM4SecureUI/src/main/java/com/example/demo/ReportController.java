package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter {

	@Autowired
	private OAuth2ClientContext clientContext;
	
	@Autowired
	public OAuth2RestTemplate oauth2RestTemplate;
	
	@RequestMapping("/")
	public String loadHome() {
		return "home";
	}
	
	@RequestMapping("/reports")
	public String loadReports(Model model) {
		
		OAuth2AccessToken t = clientContext.getAccessToken();
		System.out.println("Token :" + t);
		
		ResponseEntity<ArrayList<Price>> prices = oauth2RestTemplate.exchange("http://localhost:9001/services/pricedata", 
				HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<Price>>() {});
		
		model.addAttribute("prices", prices.getBody());
		
		return "reports";
	}
	
	public static class Price {

		public String currency;
		public String conversionRate;
		public String amount;

		public Price() {
		}

		public Price(String currency, String conversionRate, String amount) {

			this.currency = currency;
			this.conversionRate = conversionRate;
			this.amount = amount;
		}
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
				.antMatchers("/", "/login**")
				.permitAll()
			.anyRequest()
				.authenticated();
	}
}
