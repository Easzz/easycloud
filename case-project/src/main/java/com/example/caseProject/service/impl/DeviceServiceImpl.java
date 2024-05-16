package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.Device;
import com.example.caseProject.mapper.DeviceMapper;
import com.example.caseProject.service.DeviceService;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
	@Override
	public IPage<Device> selectPageVo(Page<Device> objectPage, QueryWrapper<Device> eq) {
		return objectPage.setRecords(this.baseMapper.selectPageVo(objectPage,eq));
	}
}
