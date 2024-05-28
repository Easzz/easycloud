package com.example.caseProject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.caseProject.entity.Standard;

/**
 * @author findshen
 */
public interface StandardService extends IService<Standard> {

	IPage<Standard> selectPageVo(Page<Standard> objectPage, QueryWrapper<Standard> caseQueryWrapper);
}
