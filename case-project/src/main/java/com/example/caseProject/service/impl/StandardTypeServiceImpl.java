package com.example.caseProject.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.caseProject.entity.StandardType;
import com.example.caseProject.mapper.StandardTypeMapper;
import com.example.caseProject.service.StandardTypeService;
import org.springframework.stereotype.Service;

@Service
public class StandardTypeServiceImpl extends ServiceImpl<StandardTypeMapper, StandardType> implements StandardTypeService {
}
