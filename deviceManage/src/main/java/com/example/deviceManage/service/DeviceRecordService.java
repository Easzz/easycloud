package com.example.deviceManage.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.deviceManage.entity.Device;
import com.example.deviceManage.entity.DeviceRecord;

/**
 * @author findshen
 */
public interface DeviceRecordService extends IService<DeviceRecord> {

	IPage<DeviceRecord> selectPageVo(Page<DeviceRecord> objectPage, QueryWrapper<DeviceRecord> agree);

}
