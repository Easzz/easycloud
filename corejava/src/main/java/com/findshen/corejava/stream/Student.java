package com.findshen.corejava.stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by findshen on 2020/11/27 9:07
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	/**
	 * 学生姓名
	 */
	private String name;
	/**
	 * 科目
	 */
	private String subject;
	/**
	 * 成绩
	 */
	private Integer score;
}
