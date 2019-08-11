package com.findshen.eurekaclient.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shenxuan on 2018/11/5 21:09
 */
@RestController
public class IndexController {

	@Value("${server.port}")
	private String port;

	@RequestMapping("/hi")
	public String hi(String name) {
		return "hi " + name + ", i am from port:" + port;
	}
}
