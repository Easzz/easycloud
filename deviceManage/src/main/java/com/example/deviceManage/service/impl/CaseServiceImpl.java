package com.example.deviceManage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.deviceManage.entity.Case;
import com.example.deviceManage.mapper.CaseMapper;
import com.example.deviceManage.service.CaseService;
import org.springframework.stereotype.Service;

@Service
public class CaseServiceImpl extends ServiceImpl<CaseMapper, Case> implements CaseService {
	@Override
	public IPage<Case> selectPageVo(Page<Case> objectPage, QueryWrapper<Case> caseQueryWrapper) {
		return objectPage.setRecords(this.baseMapper.selectPaveVo(objectPage,caseQueryWrapper));
	}
}
