package com.example.drive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.drive.entity.Project;
import com.example.drive.mapper.ProjectMapper;
import com.example.drive.service.ProjectService;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl extends ServiceImpl<ProjectMapper, Project> implements ProjectService {
    @Override
    public IPage<Project> selectListInfo(Page p, QueryWrapper<Project> orderByDesc) {
        return p.setRecords(this.baseMapper.selectListInfo(p,orderByDesc));
    }
}
