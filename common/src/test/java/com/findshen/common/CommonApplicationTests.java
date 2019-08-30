package com.findshen.common;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.findshen.modules.bz.dao.PeopleDao;
import com.findshen.modules.bz.entity.People;
import com.findshen.modules.bz.entity.Student;
import com.findshen.modules.bz.service.PeopleService;
import com.findshen.modules.bz.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CommonApplicationTests {


	@Autowired
	private StudentService studentService;
	@Autowired
	private PeopleService peopleService;

	@Resource
	private PeopleDao peopleDao;

	@Test
	public void insert() {
		Student studentEntity = Student.builder().age(1).studentName("mik").build();
		studentService.save(studentEntity);
	}

	/**
	 * 查询单条记录
	 */
	@Test
	public void getOne() {
        /*
        SELECT id,name,age,email,manager_id,create_time FROM people WHERE age > ? ;
        2.x 版本 查询出多条-报错。
        3.x service封装过
        (Caused by: org.apache.ibatis.exceptions.TooManyResultsException: Expected one result (or null) to be returned by selectOne(), but found: 2)
         */
		//People people = peopleService.getOne(Wrappers.<People>lambdaQuery().gt(People::getAge, 20));
		//People age1 = peopleDao.selectOne(new QueryWrapper<People>().gt("age", 20));
		People age = peopleService.getOne(new QueryWrapper<People>().gt("age", 5));
		log.info(" IService getOne - " + age);
	}

	@Test
	public void getOne2() {
        /*
        SELECT id,name,age,email,manager_id,create_time FROM people WHERE age > ?
        查询出多条-警告
        (WARNWarn: execute Method There are  2 results.)
         */
		People people = peopleService.getOne(Wrappers.<People>lambdaQuery().gt(People::getAge, 20), false);
		log.info(" IService getOne2 - " + people);

		peopleService.getOne(new QueryWrapper<People>().lambda().gt(People::getAge, 20));

		People age = peopleService.getOne(new QueryWrapper<People>().gt("age", 20));
		log.info("queryWrapper return " + age);
	}

	/**
	 * 使用select只查询指定字段
	 */
	@Test
	public void selectTest() {
		QueryWrapper<People> queryWrapper = new QueryWrapper<>();
        /*

        SELECT id,name,age,email FROM people WHERE age IN (?,?,?,?) limit 1
         */
		queryWrapper.in("age", Arrays.asList(30, 31, 34, 18)).last("limit 1")
				.select(People.class, info -> !info.getColumn().equals("create_time") && !info.getColumn().equals("manager_id"));

		List<People> peopleList = peopleService.list(queryWrapper);
		peopleList.forEach(System.out::print);
	}

	/**
	 * 复杂查询
	 */
	@Test
	public void selectLambda2() {
		LambdaQueryWrapper<People> peopleLambdaQueryWrapper = new LambdaQueryWrapper<>();
		//查询姓名以d开头的，并且年龄小于40或者邮箱不为空
        /*
        SELECT id,name,age,email,manager_id,create_time FROM people WHERE name LIKE ? AND ( age < ? OR email IS NOT NULL )
         */
		peopleLambdaQueryWrapper.likeRight(People::getName, "d").and(lqw -> lqw.lt(People::getAge, 40).or()
				.isNotNull(People::getEmail));



		List<People> list = peopleService.list(peopleLambdaQueryWrapper);
		list.forEach(System.out::println);

		IPage<People> d = peopleService.lambdaQuery()
				.likeRight(People::getName, "d")
				.and(eq -> eq.lt(People::getAge, 40).or().isNotNull(People::getEmail))
				.page(new Page<>(1, 2));
		d.getRecords().forEach(System.out::println);

	}

	/**
	 * 拼接sql
	 * SELECT id,name,age,email,manager_id,create_time FROM bz_people WHERE DATE_FORMAT(create_time,'%Y-%m-%d')=?
	 */
	@Test
	public void applyTest() {
		//拼接sql
		List<People> list = peopleService.lambdaQuery().apply("DATE_FORMAT(create_time,'%Y-%m-%d')={0}", "2019-07-09").list();
		list.forEach(System.out::println);
	}

	/**
	 * 批量保存
	 */
	@Test
	public void saveBatch() {
		People people1 = People.builder().name("batch1").age(19).email("792171677@qq.com").build();
		People people2 = People.builder().name("batch2").age(20).email("792171678@qq.com").build();

        /*
        DEBUG==>  Preparing: INSERT INTO people ( name, age, email ) VALUES ( ?, ?, ? )
        DEBUG==> Parameters: batch1(String), 19(Integer), 792171677@qq.com(String)
        DEBUG==> Parameters: batch2(String), 20(Integer), 792171678@qq.com(String)
         */
		List<People> peopleList = Arrays.asList(people1, people2);
		boolean saveBatch = peopleService.saveBatch(peopleList);
		log.info(" IService saveBatch - " + saveBatch);
	}

	/**
	 * 链式查询
	 */
	@Test
	public void chain() {
        /*
        SELECT id,name,age,email,manager_id,create_time FROM people WHERE age > ? AND name LIKE ?
         */
		List<People> list = peopleService.lambdaQuery().gt(People::getAge, 10).select(People::getAge, People::getId).list();
		IPage<People> page = peopleService.page(new Page<>(1, 2), Wrappers.<People>lambdaQuery().gt(1 == 1, People::getAge, 7));


		List<People> peopleList = peopleService.lambdaQuery().gt(People::getAge, 10).like(People::getName, "d").list();
		peopleList.forEach(System.out::println);
		list.forEach(System.out::println);
	}

	/**
	 * 链式更新
	 */
	@Test
	public void chain2() {
        /*
        UPDATE people SET age=? WHERE age = ?
         */
		boolean update = peopleService.lambdaUpdate().eq(People::getAge, 20).set(People::getAge, 22).update();

		log.info(" lambdaUpdate - " + update);
	}

	/**
	 * 更新字段为null值
	 */
	@Test
	public void updateNull() {

		peopleService.lambdaUpdate().eq(People::getId, "1").set(People::getAge, null).update();

	}


	/**
	 * 链式删除
	 */
	@Test
	public void chain3() {
        /*
        DELETE FROM people WHERE age = ?
         */
		boolean remove = peopleService.lambdaUpdate().eq(People::getAge, 22).remove();
		log.info(" lambdaUpdate - " + remove);
	}


}
