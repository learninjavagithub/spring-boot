package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class SpringCloudM3TaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudM3TaskApplication.class, args);
	}
	
	@Bean
	public PriceProcessingTask priceProcessingTask() {
		
		return new PriceProcessingTask();
	}
	
	public class PriceProcessingTask implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			
			if (null != args) {
				System.out.println("parameters length "+args.length);
				
				String price = args[1];
				String taskId = args[2];
				String amount = args[3];
				
				System.out.println("Price is : " + price + ", Task Id is : " + taskId + ", Amount is : " + amount);
			}
			
		}
		
		
	}
}
