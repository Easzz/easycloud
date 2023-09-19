package com.example.drive.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drive.config.R;
import com.example.drive.entity.NotTestTerrace;
import com.example.drive.entity.Project;
import com.example.drive.entity.Terrace;
import com.example.drive.mapper.NotTestTerraceMapper;
import com.example.drive.mapper.ProjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notTestTerrace")
public class NotTestTerraceController {

	@Autowired
	private NotTestTerraceMapper notTestTerraceMapper;

	@Autowired
	private ProjectMapper projectMapper;

	@GetMapping("/getNotTestTerraceAndProject")
	public R<List<NotTestTerrace>> getNotTestTerraceAndProject() {
		List<NotTestTerrace> terraces = notTestTerraceMapper.selectList(new QueryWrapper<NotTestTerrace>()
				.orderByAsc("terrace_name")
		);
		for (NotTestTerrace terrace : terraces) {
			List<Project> projectList = projectMapper.selectList(new QueryWrapper<Project>()
					.eq("terrace_id", terrace.getId())
					.orderByAsc("project_name")
			);
			terrace.setProjectList(projectList);
		}

		return new R<>(terraces);
	}

	@GetMapping("/getTerraceList")
	public R<IPage<NotTestTerrace>> getProjectList(Integer page, Integer limit, String terraceName) {

		if (page == null || limit == null) {
			page = 1;
			limit = Integer.MAX_VALUE;
		}

		IPage<NotTestTerrace> terraceIPage = notTestTerraceMapper.selectPage(new Page<>(page, limit), new QueryWrapper<NotTestTerrace>()
				.like(StringUtils.isNotBlank(terraceName), "terrace_name", terraceName)
				.orderByAsc("terrace_name"));
		return new R<>(terraceIPage);
	}


	@GetMapping("/save")
	public R save(Terrace platform) {

		Integer count = notTestTerraceMapper.selectCount(new QueryWrapper<NotTestTerrace>()
				.eq("terrace_name", platform.getTerraceName())
		);
		if (count > 0) {
			return R.failed("已存在重复记录");
		}

		platform.insert();
		return R.ok();
	}




}
