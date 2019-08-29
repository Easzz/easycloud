package com.findshen.modules.bz.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.findshen.modules.bz.dao.PeopleDao;
import com.findshen.modules.bz.entity.People;
import com.findshen.modules.bz.service.PeopleService;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleDao, People> implements PeopleService {
	@Override
	public Page<People> selectVoList(Page<People> peoplePage, QueryWrapper<People> peopleQueryWrapper) {
		String customSqlSegment = peopleQueryWrapper.getCustomSqlSegment();
		System.out.println("customSqlSegment" + customSqlSegment);
		return peoplePage.setRecords(this.baseMapper.selectVoList(peoplePage, peopleQueryWrapper));
	}

	@Override
	public Page<People> selectVoList4Lambda(Page<People> peoplePage, LambdaQueryWrapper<People> lambda) {
		return peoplePage.setRecords(this.baseMapper.selectVoList4Lambda(peoplePage, lambda));
	}
}
