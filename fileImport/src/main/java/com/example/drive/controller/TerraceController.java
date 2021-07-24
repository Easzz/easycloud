package com.example.drive.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drive.config.R;
import com.example.drive.entity.Terrace;
import com.example.drive.mapper.TerraceMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/terrace")
public class TerraceController {

	@Autowired
	private TerraceMapper terraceMapper;



	@GetMapping("/getTerraceList")
	public R<List<Terrace>> getProjectList(Integer page, Integer limit, String terraceName) {

		if (page == null || limit == null) {
			page = 1;
			limit = Integer.MAX_VALUE;
		}

		IPage<Terrace> terraceIPage = terraceMapper.selectPage(new Page<>(page, limit), new QueryWrapper<Terrace>()
				.like(StringUtils.isNotBlank(terraceName), "terrace_name", terraceName)
				.orderByDesc("id"));
		return new R<>(terraceIPage.getRecords());
	}


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
