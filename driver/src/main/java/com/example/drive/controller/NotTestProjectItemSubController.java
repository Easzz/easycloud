package com.example.drive.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.drive.config.R;
import com.example.drive.entity.NotTestProjectItemSub;
import com.example.drive.service.NotTestProjectItemSubService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/notTestProjectItemSub")
public class NotTestProjectItemSubController {


	@Autowired
	private NotTestProjectItemSubService notTestProjectItemSubService;



	@GetMapping("/list")
	public R<List<NotTestProjectItemSub>> getProjectList(Integer page, Integer limit, String projectName,
											   Long notTestTerraceId) {

		if (page == null || limit == null) {
			page = 1;
			limit = Integer.MAX_VALUE;
		}
		List<NotTestProjectItemSub> projectIPage=notTestProjectItemSubService.list(new QueryWrapper<NotTestProjectItemSub>()
//				.like(StringUtils.isNotBlank(projectName), "p.project_name", projectName)
				.eq(notTestTerraceId!=null,"not_test_terrace_id",notTestTerraceId)
				.eq("1",1)
//				.orderByAsc("p.project_name")
		);
//		IPage<Project> projectIPage = projectMapper.selectPage(new Page<>(page, limit), new QueryWrapper<Project>()
//				.like(StringUtils.isNotBlank(projectName), "project_name", projectName)
//				.orderByDesc("id"));
		return new R(projectIPage);
	}

//
//	@GetMapping("/getProjectByName")
//	public R<List<NotTestProject>> getFacilityList(String projectName) {
//
//		return new R<>(projectMapper.selectList(new QueryWrapper<NotTestProject>()
//				.like("project_name", projectName)
//		));
//	}

//
//	@GetMapping("/getDynamicHeader")
//	public R<List<String>> getDynamicHeader() {
//		List<String> list=new ArrayList<>();
//		List<NotTestTerrace> terraces = terraceMapper.selectList(null);
//		for (NotTestTerrace terrace : terraces) {
//			list.add(terrace.getTerraceName());
//		}
//		return R.ok(list);
//
//	}

//
//	@GetMapping("/getDynamicProject")
//	public R<List<Map<String,String>>> getDynamicProject() {
//
//		List<Map<String,String>> list=new ArrayList<>();
//
//		IPage<NotTestProject> projectIPage = projectService.selectListInfo(new Page(1, Integer.MAX_VALUE), new QueryWrapper<NotTestProject>());
//		List<NotTestProject> records = projectIPage.getRecords();
//
//		List<NotTestTerrace> terraces = terraceMapper.selectList(null);
//
//
//		for (NotTestProject record : records) {
//			Map<String,String> m=new LinkedHashMap<>();
//			if (StringUtils.isNotBlank(record.getTerraceName())){
//				for (NotTestTerrace terrace : terraces) {
//					if (terrace.getTerraceName().equalsIgnoreCase(record.getTerraceName())){
//						m.put(terrace.getTerraceName(),record.getProjectName());
//					} else {
//						m.put(terrace.getTerraceName(),"");
//					}
//				}
//				list.add(m);
//			}
//		}
//
//
//System.out.println(list);
//
//		return R.ok(list);
//
//	}

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
	private static Map<String, List<NotTestProjectItemSub>> sortByKey(Map<String, List<NotTestProjectItemSub>> map) {
		Map<String, List<NotTestProjectItemSub>> result = new LinkedHashMap<>(map.size());
		map.entrySet().stream()
				.sorted(Map.Entry.comparingByKey())
				.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}
//
//
//	@GetMapping("/getListByProjectId")
//	public R<List<NotTestProjectItem>> getFacilityList(Long projectId) {
////		List<ProjectItemSub> projectItems = projectItemMapper.buildList(projectId);
//
////		List<ProjectItemSub> projectItems = projectItemSubMapper.selectList(new QueryWrapper<ProjectItemSub>()
////				.eq("project_id", projectId)
////		);
//
//		List<NotTestProjectItemSub> projectItems = projectItemSubMapper.selectInfo(new QueryWrapper<NotTestProjectItemSub>()
//				.eq("s.project_id", projectId));
//
//
//		List<NotTestProjectItem> result = new ArrayList<>();
//
//		//首先根据设备分组
//		Map<String, List<NotTestProjectItemSub>> driveMap = projectItems.stream().collect(Collectors.groupingBy(NotTestProjectItemSub::getDriveName, Collectors.toList()));
//
//		Map<String, List<NotTestProjectItemSub>> driveMapSort = sortByKey(driveMap);
//
//
//		for (String s : driveMapSort.keySet()) {
//
//			List<NotTestProjectItemSub> projectItemSubs = driveMapSort.get(s);
//			Map<String, List<NotTestProjectItemSub>> manufacturerMap = projectItemSubs.stream().collect(Collectors.groupingBy(NotTestProjectItemSub::getManufacturer, Collectors.toList()));
//
//			//根据厂商分组
//			for (String manufacturerKey : manufacturerMap.keySet()) {
//				NotTestProjectItem item = new NotTestProjectItem();
//				item.setDriveName(s);
//
//				item.setManufacturer(manufacturerKey);
//
//				List<NotTestProjectItemSub> projectItemSubs1 = manufacturerMap.get(manufacturerKey);
//
//				String description = projectItemSubs1.get(0).getDescription();
//				String terraceName = projectItemSubs1.get(0).getTerraceName();
//				item.setTerraceName(terraceName);
//				if (StringUtils.isBlank(description)) {
//					item.setDescription("-");
//				} else {
//					item.setDescription(description);
//				}
//
//				//根据平台分组
//
//				Map<String, List<NotTestProjectItemSub>> platformMap = projectItemSubs1.stream().collect(Collectors.groupingBy(NotTestProjectItemSub::getPlatform, Collectors.toList()));
//
//				for (String platformKey : platformMap.keySet()) {
//
//					List<NotTestProjectItemSub> sub = platformMap.get(platformKey);
//
//					if ("win7".equalsIgnoreCase(platformKey)) {
//						item.setWin7SubList(sub);
//					}
//					if ("win10".equalsIgnoreCase(platformKey)) {
//						item.setWin10SubList(sub);
//					}
//					if ("win11".equalsIgnoreCase(platformKey)) {
//						item.setWin11SubList(sub);
//					}
//
//				}
//				result.add(item);
//
//			}
//
//
//		}
//
////		System.out.println(result);
//		return new R<>(result);
//	}


}
