package com.example.demo.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectItem;
import com.example.demo.entity.ProjectItemSub;
import com.example.demo.mapper.ProjectItemMapper;
import com.example.demo.mapper.ProjectMapper;
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

	@GetMapping("/save")
	public void getFacilityList(Project project) {
		project.insert();
	}

	@GetMapping("/saveItem")
	public void getFacilityList(ProjectItem projectItem) {

	}

	@GetMapping("/getProjectByName")
	public List<Project> getFacilityList(String projectName) {

		return projectMapper.selectList(new QueryWrapper<Project>()
				.like("project_name", projectName)
		);
	}

	@GetMapping("/getListByProjectId")
	public List<ProjectItem> getFacilityList(Long projectId) {
		List<ProjectItemSub> projectItems = projectItemMapper.buildList(projectId);

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
		return result;
	}


}
