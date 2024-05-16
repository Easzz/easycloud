package com.example.caseProject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.caseProject.entity.CaseProject;

/**
 * @author findshen
 */
public interface CaseService extends IService<CaseProject> {

	IPage<CaseProject> selectPageVo(Page<CaseProject> objectPage, QueryWrapper<CaseProject> caseQueryWrapper);
}
