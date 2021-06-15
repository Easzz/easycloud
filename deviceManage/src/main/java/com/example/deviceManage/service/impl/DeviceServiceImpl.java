package com.example.deviceManage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.deviceManage.entity.Device;
import com.example.deviceManage.mapper.DeviceMapper;
import com.example.deviceManage.service.DeviceService;
import org.springframework.stereotype.Service;

@Service
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements DeviceService {
	@Override
	public IPage<Device> selectPageVo(Page<Device> objectPage, QueryWrapper<Device> eq) {
		return objectPage.setRecords(this.baseMapper.selectPageVo(objectPage,eq));
	}
}
