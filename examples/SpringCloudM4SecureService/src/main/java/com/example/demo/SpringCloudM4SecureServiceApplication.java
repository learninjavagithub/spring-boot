package com.example.demo;

import java.util.ArrayList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableResourceServer
public class SpringCloudM4SecureServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM4SecureServiceApplication.class, args);
	}

	@RequestMapping("/pricedata")
	public ArrayList<Price> getPriceData() {

		Price p1 = new Price("INR", "1", "12500");
		Price p2 = new Price("USD", "65", "46500");
		Price p3 = new Price("EUR", "55", "2500");

		ArrayList<Price> prices = new ArrayList<Price>();
		prices.add(p1);
		prices.add(p2);
		prices.add(p3);

		return prices;
	}

	public class Price {

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
}
