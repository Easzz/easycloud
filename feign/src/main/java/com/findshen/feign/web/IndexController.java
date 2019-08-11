package com.findshen.feign.web;

import com.findshen.feign.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by shenxuan on 2018/11/5 22:02
 */
@RestController
public class IndexController {
	@Autowired
	ScheduleService scheduleService;

	@GetMapping("/hi")
	public String getHi(String name) {
		return scheduleService.sayHi(name);
	}
}
