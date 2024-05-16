package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.DeviceRecord;
import com.example.caseProject.mapper.DeviceRecordMapper;
import com.example.caseProject.service.DeviceRecordService;
import org.springframework.stereotype.Service;

@Service
public class DeviceRecordServiceImpl extends ServiceImpl<DeviceRecordMapper, DeviceRecord> implements DeviceRecordService {
    @Override
    public IPage<DeviceRecord> selectPageVo(Page<DeviceRecord> objectPage, QueryWrapper<DeviceRecord> agree) {
        return objectPage.setRecords(this.baseMapper.selectPageVo(objectPage,agree));
    }
}
