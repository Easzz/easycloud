package com.example.caseProject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.caseProject.entity.CaseProject;
import com.example.caseProject.entity.PermissionUser;

/**
 * @author findshen
 */
public interface PermissionUserService extends IService<PermissionUser> {

	IPage<PermissionUser> selectPageVo(Page<PermissionUser> objectPage, QueryWrapper<PermissionUser> caseQueryWrapper);
}
