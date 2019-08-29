package com.findshen.common;

import com.findshen.modules.bz.entity.People;
import com.findshen.modules.bz.service.ManagerService;
import com.findshen.modules.bz.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 乐观锁测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OptLockerTests {

	@Autowired
	private PeopleService peopleService;

	@Autowired
	private ManagerService managerService;

	@Test
	public void insertTestSuccess() {
		People people = People.builder().age(10).name("乐观锁测试").version(1).build();
		peopleService.save(people);

		people = new People();
		people.setId(people.getId());
		people.setVersion(1);
		people.setAge(11);
		boolean result = peopleService.updateById(people);
		System.out.println(result);

	}


}
