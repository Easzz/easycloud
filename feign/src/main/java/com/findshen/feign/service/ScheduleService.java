package com.findshen.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by shenxuan on 2018/11/5 21:59
 */
@FeignClient(value = "client1")
@Service
public interface ScheduleService {

	//需要使用RequestParam注解传参
	//或者用RequestBody,否则下端服务接收不到
	@GetMapping("/hi")
	String sayHi(@RequestParam(value = "name") String name);
}
