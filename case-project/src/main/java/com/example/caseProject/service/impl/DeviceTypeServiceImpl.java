package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.DeviceType;
import com.example.caseProject.mapper.DeviceTypeMapper;
import com.example.caseProject.service.DeviceTypeService;
import org.springframework.stereotype.Service;

@Service
public class DeviceTypeServiceImpl   extends ServiceImpl<DeviceTypeMapper, DeviceType> implements DeviceTypeService {
}
