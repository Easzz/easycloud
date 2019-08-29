
package com.findshen.modules.bz.dao;

import com.baomidou.mybatisplus.annotation.SqlParser;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.findshen.modules.bz.entity.People;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PeopleDao extends BaseMapper<People> {

	@SqlParser(filter = true)
	List<People> selectVoList(Page<People> peoplePage,@Param(Constants.WRAPPER) QueryWrapper<People> peopleQueryWrapper);

	List<People> selectVoList4Lambda(Page<People> peoplePage, @Param(Constants.WRAPPER)LambdaQueryWrapper<People> lambda);
}
