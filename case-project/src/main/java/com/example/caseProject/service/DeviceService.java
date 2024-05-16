package com.example.caseProject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.caseProject.entity.Device;

/**
 * @author findshen
 */
public interface DeviceService extends IService<Device> {

	IPage<Device> selectPageVo(Page<Device> objectPage, QueryWrapper<Device> eq);
}
