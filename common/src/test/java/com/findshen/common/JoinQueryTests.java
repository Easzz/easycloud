package com.findshen.common;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.findshen.modules.bz.entity.Manager;
import com.findshen.modules.bz.entity.People;
import com.findshen.modules.bz.service.ManagerService;
import com.findshen.modules.bz.service.PeopleService;
import com.findshen.modules.bz.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * 多表联合查询测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class JoinQueryTests {

	@Autowired
	private StudentService studentService;

	@Autowired
	private PeopleService peopleService;

	@Autowired
	private ManagerService managerService;

	@Test
	public void insertTest() {
		Manager m = Manager.builder().name("管理者6").managerAge(12).build();
		managerService.save(m);

		People p1 = People.builder().age(2).name("p2").email("123@q.com").managerId(m.getId()).build();
		peopleService.save(p1);
	}

	/**
	 * 多表查询并分页排序
	 * 使用	${ew.customSqlSegment} 避免没有写条件报错
	 */
	@Test
	public void testQuery() {
		List<People> list = peopleService.lambdaQuery().eq(People::getAge, 1).list();
		list.forEach(System.out::print);

		Page<People> result = peopleService.selectVoList(new Page<>(1, 2), new QueryWrapper<People>()
				.ge("p.id", 1)
				.orderByDesc("p.id")
				.orderByAsc("m.id"));

		result.getRecords().forEach(System.out::println);


	}
//
//	/**
//	 * 多表查询
//	 */
//	@Test
//	public void testQuery4Lambda() {
//		Page<People> result4Lambda = peopleService.selectVoList4Lambda(new Page<>(1, 2),
//				new QueryWrapper<People>().lambda()
//						.ge(People::getId, 1));
//		result4Lambda.getRecords().forEach(System.out::println);
//	}


}
