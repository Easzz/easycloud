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
import com.example.drive.entity.Terrace;
import com.example.drive.mapper.ProjectItemMapper;
import com.example.drive.mapper.ProjectItemSubMapper;
import com.example.drive.mapper.ProjectMapper;
import com.example.drive.mapper.TerraceMapper;
import com.example.drive.service.ProjectService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectItemMapper projectItemMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private ProjectItemSubMapper projectItemSubMapper;
	@Autowired
	private FileUploadConfig fileUploadConfig;
	@Autowired
	private TerraceMapper terraceMapper;


	@GetMapping("/getApi")
	public R getApi() {
		System.out.println(fileUploadConfig);
		return R.ok(fileUploadConfig);
	}


	@GetMapping("/info")
	public R info(Long projectId) {

		IPage<Project> projectIPage=projectService.selectListInfo(new Page<>(1, 1),new QueryWrapper<Project>()
				.eq( "p.id", projectId)
				.orderByDesc("p.project_name"));

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
	public R<Page> getProjectList(Integer page, Integer limit, String projectName,
										   Long terraceId) {

		if (page == null || limit == null) {
			page = 1;
			limit = Integer.MAX_VALUE;
		}
		IPage<Project> projectIPage=projectService.selectListInfo(new Page<>(page, limit),new QueryWrapper<Project>()
				.like(StringUtils.isNotBlank(projectName), "p.project_name", projectName)
				.eq(terraceId!=null,"p.terrace_id",terraceId)
				.orderByAsc("p.project_name"));
//		IPage<Project> projectIPage = projectMapper.selectPage(new Page<>(page, limit), new QueryWrapper<Project>()
//				.like(StringUtils.isNotBlank(projectName), "project_name", projectName)
//				.orderByDesc("id"));
		return new R(projectIPage);
	}


	@GetMapping("/getProjectByName")
	public R<List<Project>> getFacilityList(String projectName) {

		return new R<>(projectMapper.selectList(new QueryWrapper<Project>()
				.like("project_name", projectName)
		));
	}


	@GetMapping("/getDynamicHeader")
	public R<List<String>> getDynamicHeader() {
		List<String> list=new ArrayList<>();
		List<Terrace> terraces = terraceMapper.selectList(null);
		for (Terrace terrace : terraces) {
			list.add(terrace.getTerraceName());
		}
		return R.ok(list);

	}


	@GetMapping("/getDynamicProject")
	public R<List<Map<String,String>>> getDynamicProject() {

		List<Map<String,String>> list=new ArrayList<>();

		IPage<Project> projectIPage = projectService.selectListInfo(new Page(1, Integer.MAX_VALUE), new QueryWrapper<Project>());
		List<Project> records = projectIPage.getRecords();

		List<Terrace> terraces = terraceMapper.selectList(null);


		for (Project record : records) {
			Map<String,String> m=new LinkedHashMap<>();
			if (StringUtils.isNotBlank(record.getTerraceName())){
				for (Terrace terrace : terraces) {
					if (terrace.getTerraceName().equalsIgnoreCase(record.getTerraceName())){
						m.put(terrace.getTerraceName(),record.getProjectName());
					} else {
						m.put(terrace.getTerraceName(),"");
					}
				}
				list.add(m);
			}
		}


System.out.println(list);

		return R.ok(list);

	}

		public static void main(String[] args) {
//			List<List<String>> data = Stream.of(
//					Stream.of("1", "2", "3").collect(Collectors.toList()),
//					Stream.of("1", "2", "3", "4", "5").collect(Collectors.toList()),
//					Stream.of("1", "2", "3", "7").collect(Collectors.toList())
//			).collect(Collectors.toList());
//
//			int length = data.stream().mapToInt(a -> a.size()).max().orElse(0);
//
//			List<List<String>> result = IntStream.range(0, length).mapToObj(i -> {
//				return data.stream().map(a -> a.size() > i ? a.get(i) : null).collect(Collectors.toList());
//			}).collect(Collectors.toList());
//
//			result.forEach(one -> {
//				one.forEach(s -> System.out.printf("%7s", s));
//				System.out.println();
//			});
			List<Map<String,String>> data=new ArrayList<>();
			Map<String,String> m=new HashMap<>();
			m.put("a","");
			m.put("b","");
			m.put("c","1");

			data.add(m);
			m=new HashMap<>();
			m.put("a","");
			m.put("b","项目1");
			m.put("c","");
			data.add(m);
			m=new HashMap<>();
			m.put("a","111");
			m.put("b","");
			m.put("c","");
			data.add(m);
			m=new LinkedHashMap<>();
			m.put("a","");
			m.put("b","");
			m.put("c","项目3");
			data.add(m);
			System.out.println(data);

			data.forEach(e->{
				for (String s : e.keySet()) {
					if (StringUtils.isBlank(e.get(s))){

					}
				}


			});


			String[] str1 = {"Hello","world","java"};
			String[] str2 = {"Veriable","syntax","interator"};
			int str1Length = str1.length;
			int str2length = str2.length;

			str1 = Arrays.copyOf(str1, str1Length+str2length);//数组扩容
			System.arraycopy(str2, 0, str1, str1Length, str2length);
			System.out.println(Arrays.toString(str1));


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
