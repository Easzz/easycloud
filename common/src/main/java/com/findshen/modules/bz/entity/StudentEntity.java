/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.findshen.modules.bz.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 学生表
 */
@Data
@TableName("bz_student")
public class StudentEntity extends Model<StudentEntity> {
	@TableId
	private Long id;
	@NotBlank(message="参数名不能为空")
	private String studentName;
	private Integer age;

	@TableLogic
	private Boolean valid;
	private Date gmtCreate;
	private Date gmtModified;


}
