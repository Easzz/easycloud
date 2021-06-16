package com.example.deviceManage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.deviceManage.entity.DeviceRecord;
import com.example.deviceManage.entity.DeviceType;
import com.example.deviceManage.mapper.DeviceRecordMapper;
import com.example.deviceManage.mapper.DeviceTypeMapper;
import com.example.deviceManage.service.DeviceRecordService;
import com.example.deviceManage.service.DeviceTypeService;
import org.springframework.stereotype.Service;

@Service
public class DeviceRecordServiceImpl extends ServiceImpl<DeviceRecordMapper, DeviceRecord> implements DeviceRecordService {
    @Override
    public IPage<DeviceRecord> selectPageVo(Page<DeviceRecord> objectPage, QueryWrapper<DeviceRecord> agree) {
        return objectPage.setRecords(this.baseMapper.selectPageVo(objectPage,agree));
    }
}
