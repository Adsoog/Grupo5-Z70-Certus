package com.codeusingjava.InfoManager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RefreshScope
public class InfoManagerApplication {

	///@Autowired
	///@Lazy
	///private RestTemplate template;

	///@Value("${infoByAuthorities.infourl}")
	///private String geturl;

	///@GetMapping("/getcatagories")
	///public List<String> getCatagories() {
	///	List<String> catagory = template.getForObject(geturl, List.class);
	///	return catagory;
	///}

	public static void main(String[] args) {
		SpringApplication.run(InfoManagerApplication.class, args);
	}

	///@Bean
	///public RestTemplate template() {
	///	return new RestTemplate();
	///}

}
