package com.findshen.corejava.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by findshen on 2020/11/27 9:05
 */
public class MapTest {

	/**
	 * map merge合并操作。
	 * 如果key不存在，则将新的值赋予到key。如果key已存在，则更新该key所对应的value
	 */
	@Test
	public void testMerge() {
		List<Student> list = new ArrayList<>();
		Student s = new Student("张三", "语文", 13);
		Student s1 = new Student("张三", "数学", 12);
		Student s2 = new Student("张三", "英语", 15);
		list.add(s);
		list.add(s1);
		list.add(s2);

		Student s3 = new Student("李四", "语文", 13);
		Student s4 = new Student("李四", "数学", 12);
		Student s5 = new Student("李四", "英语", 16);
		list.add(s3);
		list.add(s4);
		list.add(s5);

		Map<String, Integer> m = new HashMap<>();
		list.forEach(stu -> m.merge(stu.getName(), stu.getScore(), (t, k) -> {
			return t + k;
		}));
		System.out.println(m);

	}

}
