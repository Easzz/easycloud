package com.example.drive.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.drive.config.R;
import com.example.drive.entity.Terrace;
import com.example.drive.mapper.TerraceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/terrace")
public class TerraceController {

	@Autowired
	private TerraceMapper terraceMapper;


	@GetMapping("/save")
	public R save(Terrace platform) {


		Integer count = terraceMapper.selectCount(new QueryWrapper<Terrace>()
				.eq("terrace_name", platform.getTerraceName())
		);
		if (count > 0) {
			return R.failed("已存在重复记录");
		}

		platform.insert();
		return R.ok();
	}




}
