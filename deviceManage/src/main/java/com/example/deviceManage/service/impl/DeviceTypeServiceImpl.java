package com.example.deviceManage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.deviceManage.entity.DeviceType;
import com.example.deviceManage.mapper.DeviceTypeMapper;
import com.example.deviceManage.service.DeviceTypeService;
import org.springframework.stereotype.Service;

@Service
public class DeviceTypeServiceImpl   extends ServiceImpl<DeviceTypeMapper, DeviceType> implements DeviceTypeService {
}
