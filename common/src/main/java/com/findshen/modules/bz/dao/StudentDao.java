/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.findshen.modules.bz.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.findshen.modules.bz.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 系统用户
 *
 * @author Mark sunlightcs@gmail.com
 */
@Mapper
public interface StudentDao extends BaseMapper<StudentEntity> {
	
}
