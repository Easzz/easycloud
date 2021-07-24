package com.example.drive.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drive.config.R;
import com.example.drive.entity.Project;
import com.example.drive.entity.ProjectItem;
import com.example.drive.entity.ProjectItemSub;
import com.example.drive.mapper.ProjectItemMapper;
import com.example.drive.mapper.ProjectItemSubMapper;
import com.example.drive.mapper.ProjectMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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


	@GetMapping("/info")
	public R info(Long projectId) {

		IPage<Project> projectIPage=projectMapper.selectListInfo(new Page<>(1, 1),new QueryWrapper<Project>()
				.eq( "p.id", projectId)
				.orderByDesc("p.id"));

		return R.ok(projectIPage.getRecords().get(0));
	}

	@GetMapping("/save")
	public R save(Project project) {

		Integer count = projectMapper.selectCount(new QueryWrapper<Project>()
				.eq("project_name", project.getProjectName())
				.eq("terrace_id", project.getTerraceId())
		);
		if (count > 0) {
			return R.failed("已存在重复记录");
		}

		project.insert();
		return R.ok();
	}

	@GetMapping("/saveItem")
	public R saveItem(ProjectItemSub projectItemSub) {

		Project project = projectMapper.selectById(projectItemSub.getProjectId());
		projectItemSub.setTerraceId(project.getTerraceId());


		//判断是否相同，相同则替换
		ProjectItemSub dbItem = projectItemSub.selectOne(new QueryWrapper<ProjectItemSub>()
				.eq("project_id", projectItemSub.getProjectId())
				.eq(projectItemSub.getTerraceId() != null, "terrace_id", projectItemSub.getTerraceName())
				.eq("drive_name", projectItemSub.getDriveName())
				.eq("manufacturer", projectItemSub.getManufacturer())
				.eq("platform", projectItemSub.getPlatform()));



		if (dbItem != null) {
			projectItemSub.setId(dbItem.getId());
			projectItemSubMapper.updateById(projectItemSub);
			return R.ok();
		}




		projectItemSub.insert();
		return R.ok();
	}

	@GetMapping("/getProjectList")
	public R<List<Project>> getProjectList(Integer page, Integer limit, String projectName) {

		if (page == null || limit == null) {
			page = 1;
			limit = Integer.MAX_VALUE;
		}
		IPage<Project> projectIPage=projectMapper.selectListInfo(new Page<>(page, limit),new QueryWrapper<Project>()
				.like(StringUtils.isNotBlank(projectName), "project_name", projectName)
				.orderByDesc("p.id"));
//		IPage<Project> projectIPage = projectMapper.selectPage(new Page<>(page, limit), new QueryWrapper<Project>()
//				.like(StringUtils.isNotBlank(projectName), "project_name", projectName)
//				.orderByDesc("id"));
		return new R<>(projectIPage.getRecords());
	}


	@GetMapping("/getProjectByName")
	public R<List<Project>> getFacilityList(String projectName) {

		return new R<>(projectMapper.selectList(new QueryWrapper<Project>()
				.like("project_name", projectName)
		));
	}


	/**
	 * map 按 key 升序排序
	 */
	private static Map<String, List<ProjectItemSub>> sortByKey(Map<String, List<ProjectItemSub>> map) {
		Map<String, List<ProjectItemSub>> result = new LinkedHashMap<>(map.size());
		map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}


	@GetMapping("/getListByProjectId")
	public R<List<ProjectItem>> getFacilityList(Long projectId) {
//		List<ProjectItemSub> projectItems = projectItemMapper.buildList(projectId);

//		List<ProjectItemSub> projectItems = projectItemSubMapper.selectList(new QueryWrapper<ProjectItemSub>()
//				.eq("project_id", projectId)
//		);

		List<ProjectItemSub> projectItems = projectItemSubMapper.selectInfo(new QueryWrapper<ProjectItemSub>()
				.eq("s.project_id", projectId));


		List<ProjectItem> result = new ArrayList<>();

		//首先根据设备分组
		Map<String, List<ProjectItemSub>> driveMap = projectItems.stream().collect(Collectors.groupingBy(ProjectItemSub::getDriveName, Collectors.toList()));

		Map<String, List<ProjectItemSub>> driveMapSort = sortByKey(driveMap);


		for (String s : driveMapSort.keySet()) {

			List<ProjectItemSub> projectItemSubs = driveMapSort.get(s);
			Map<String, List<ProjectItemSub>> manufacturerMap = projectItemSubs.stream().collect(Collectors.groupingBy(ProjectItemSub::getManufacturer, Collectors.toList()));

			//根据厂商分组
			for (String manufacturerKey : manufacturerMap.keySet()) {
				ProjectItem item = new ProjectItem();
				item.setDriveName(s);

				item.setManufacturer(manufacturerKey);

				List<ProjectItemSub> projectItemSubs1 = manufacturerMap.get(manufacturerKey);

				String description = projectItemSubs1.get(0).getDescription();
				String terraceName = projectItemSubs1.get(0).getTerraceName();
				item.setTerraceName(terraceName);
				if (StringUtils.isBlank(description)) {
					item.setDescription("-");
				} else {
					item.setDescription(description);
				}

				//根据平台分组

				Map<String, List<ProjectItemSub>> platformMap = projectItemSubs1.stream().collect(Collectors.groupingBy(ProjectItemSub::getPlatform, Collectors.toList()));

				for (String platformKey : platformMap.keySet()) {

					List<ProjectItemSub> sub = platformMap.get(platformKey);

					if ("win7".equalsIgnoreCase(platformKey)) {
						item.setWin7SubList(sub);
					}
					if ("win10".equalsIgnoreCase(platformKey)) {
						item.setWin10SubList(sub);
					}

				}
				result.add(item);

			}


		}

//		System.out.println(result);
		return new R<>(result);
	}


}
