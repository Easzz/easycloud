package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.CaseProject;
import com.example.caseProject.mapper.CaseMapper;
import com.example.caseProject.service.CaseService;
import org.springframework.stereotype.Service;

@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, CaseProject> implements CaseService {
	@Override
	public IPage<CaseProject> selectPageVo(Page<CaseProject> objectPage, QueryWrapper<CaseProject> caseQueryWrapper) {
		return objectPage.setRecords(this.baseMapper.selectPaveVo(objectPage,caseQueryWrapper));
	}
}
