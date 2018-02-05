package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@ConfigurationProperties(prefix="config")
@RefreshScope
public class PriceController {

	@Value("${price}")
	String price;
	
	@Value("${start}")
	String start;
	
	@Value("${end}")
	String end;
	
	@Value("${count}")
	String count;
	
	@Value("${constring}")
	String constring;
	
	@RequestMapping("/price")
	public String getPrice(Model m) {
		
		m.addAttribute("priceamount", price);
		m.addAttribute("itemcount", count);
		m.addAttribute("starttime", start);
		m.addAttribute("constring", constring);
		
		return "priceview";
	}

}
