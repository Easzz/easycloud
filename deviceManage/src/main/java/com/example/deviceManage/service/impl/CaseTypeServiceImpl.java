package com.example.deviceManage.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.deviceManage.entity.CaseType;
import com.example.deviceManage.mapper.CaseTypeMapper;
import com.example.deviceManage.service.CaseTypeService;
import org.springframework.stereotype.Service;

@Service
public class CaseTypeServiceImpl extends ServiceImpl<CaseTypeMapper, CaseType> implements CaseTypeService {
}
