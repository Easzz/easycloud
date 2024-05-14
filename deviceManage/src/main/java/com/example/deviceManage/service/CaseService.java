package com.example.deviceManage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.deviceManage.entity.Case;

/**
 * @author findshen
 */
public interface CaseService extends IService<Case> {

	IPage<Case> selectPageVo(Page<Case> objectPage, QueryWrapper<Case> caseQueryWrapper);
}
