package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.CaseProject;
import com.example.caseProject.entity.PermissionUser;
import com.example.caseProject.mapper.CaseMapper;
import com.example.caseProject.mapper.PermissionUserMapper;
import com.example.caseProject.service.CaseService;
import com.example.caseProject.service.PermissionUserService;
import org.springframework.stereotype.Service;

@Service
public class PermissionUserServiceImpl extends ServiceImpl<PermissionUserMapper, PermissionUser> implements PermissionUserService {
	@Override
	public IPage<PermissionUser> selectPageVo(Page<PermissionUser> objectPage, QueryWrapper<PermissionUser> caseQueryWrapper) {
		return objectPage.setRecords(this.baseMapper.selectPaveVo(objectPage,caseQueryWrapper));
	}
}
