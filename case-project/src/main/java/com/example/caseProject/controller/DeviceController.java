package com.example.caseProject.controller;
/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.example.caseProject.config.R;
import com.example.caseProject.entity.Device;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/device")
public class DeviceController {



	@PostMapping("/save")
	public R save(Device device) {


		device.insert();
		return R.ok();
	}


}
