package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.Standard;
import com.example.caseProject.mapper.StandardMapper;
import com.example.caseProject.service.StandardService;
import org.springframework.stereotype.Service;

@Service
public class StandardServiceImpl extends ServiceImpl<StandardMapper, Standard> implements StandardService {
	@Override
	public IPage<Standard> selectPageVo(Page<Standard> objectPage, QueryWrapper<Standard> caseQueryWrapper) {
		return objectPage.setRecords(this.baseMapper.selectPaveVo(objectPage,caseQueryWrapper));
	}
}
