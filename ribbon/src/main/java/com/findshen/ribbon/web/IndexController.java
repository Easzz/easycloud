package com.findshen.ribbon.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by shenxuan on 2018/11/5 21:35
 */
@RestController
public class IndexController {
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/hi")
	public String hiServer(String name) {
		return restTemplate.getForObject("http://client1/hi?name=" + name, String.class);
	}
}
