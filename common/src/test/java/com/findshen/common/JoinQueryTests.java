package com.findshen.common;

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
		Manager m = Manager.builder().name("管理者5").managerAge(12).build();
		managerService.save(m);

		People p1 = People.builder().age(1).name("p1").email("123@q.com").managerId(m.getId()).build();
		peopleService.save(p1);
	}

	@Test
	public void testQuery() {
		List<People> list = peopleService.lambdaQuery().eq(People::getAge, 1).list();
		list.forEach(System.out::print);
	}


}
