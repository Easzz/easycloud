package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.CaseType;
import com.example.caseProject.mapper.CaseTypeMapper;
import com.example.caseProject.service.CaseTypeService;
import org.springframework.stereotype.Service;

@Service
public class CaseTypeServiceImpl extends ServiceImpl<CaseTypeMapper, CaseType> implements CaseTypeService {
}
