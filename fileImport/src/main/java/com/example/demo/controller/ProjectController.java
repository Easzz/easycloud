package com.example.demo.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.config.R;
import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectItem;
import com.example.demo.entity.ProjectItemSub;
import com.example.demo.mapper.ProjectItemMapper;
import com.example.demo.mapper.ProjectItemSubMapper;
import com.example.demo.mapper.ProjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectItemMapper projectItemMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private ProjectItemSubMapper projectItemSubMapper;
	@Autowired
	private FileUploadConfig fileUploadConfig;


	@GetMapping("/getApi")
	public R getApi() {
	System.out.println(fileUploadConfig);
		return R.ok(fileUploadConfig);
	}

	@GetMapping("/save")
	public R save(Project project) {


		Integer count = projectMapper.selectCount(new QueryWrapper<Project>()
				.eq("project_name", project.getProjectName())
		);
		if (count > 0) {
			return R.failed("已存在重复记录");
		}

		project.insert();
		return R.ok();
	}

	@GetMapping("/saveItem")
	public R saveItem(ProjectItemSub projectItemSub) {

		//判断是否相同，相同则替换
		ProjectItemSub projectItemSubs = projectItemSub.selectOne(new QueryWrapper<ProjectItemSub>()
				.eq("project_id", projectItemSub.getProjectId())
				.eq("drive_name", projectItemSub.getDriveName())

				.eq("platform", projectItemSub.getPlatform()));

		projectItemSub.insert();

		return R.ok();
	}

	@GetMapping("/getProjectList")
	public R<List<Project>> getProjectList(Integer page, Integer limit, String projectName) {

		if (page == null || limit == null) {
			page = 1;
			limit = Integer.MAX_VALUE;
		}

		IPage<Project> projectIPage = projectMapper.selectPage(new Page<>(page, limit), new QueryWrapper<Project>()
				.like(StringUtils.isNotBlank(projectName), "project_name", projectName)
				.orderByDesc("id"));
		return new R<>(projectIPage.getRecords());
	}


	@GetMapping("/getProjectByName")
	public R<List<Project>> getFacilityList(String projectName) {

		return new R<>(projectMapper.selectList(new QueryWrapper<Project>()
				.like("project_name", projectName)
		));
	}

	@GetMapping("/getListByProjectId")
	public R<List<ProjectItem>> getFacilityList(Long projectId) {
//		List<ProjectItemSub> projectItems = projectItemMapper.buildList(projectId);

		List<ProjectItemSub> projectItems = projectItemSubMapper.selectList(new QueryWrapper<ProjectItemSub>()
				.eq("project_id", projectId)
		);


		List<ProjectItem> result = new ArrayList<>();

		//首先根据设备分组
		Map<String, List<ProjectItemSub>> collect = projectItems.stream().collect(Collectors.groupingBy(ProjectItemSub::getDriveName, Collectors.toList()));

		//根据平台分组

		for (String s : collect.keySet()) {
			ProjectItem item = new ProjectItem();
			item.setDriveName(s);

			List<ProjectItemSub> projectItemSubs = collect.get(s);
			Map<String, List<ProjectItemSub>> collect1 = projectItemSubs.stream().collect(Collectors.groupingBy(ProjectItemSub::getPlatform, Collectors.toList()));

			//根据平台分组
			for (String s1 : collect1.keySet()) {
				List<ProjectItemSub> projectItemSubs1 = collect1.get(s1);
				if (s1.equalsIgnoreCase("win7")) {
					item.setWin7SubList(projectItemSubs1);
				}
				if (s1.equalsIgnoreCase("win10")) {
					item.setWin10SubList(projectItemSubs1);
				}
			}

			result.add(item);
		}

		System.out.println(result);
		return new R<>(result);
	}


}
