package com.example.drive.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.drive.entity.NotTestProject;
import com.example.drive.mapper.NotTestProjectMapper;
import com.example.drive.service.NotTestProjectService;
import org.springframework.stereotype.Service;

@Service
public class NotTestProjectServiceImpl extends ServiceImpl<NotTestProjectMapper, NotTestProject> implements NotTestProjectService {
    @Override
    public IPage<NotTestProject> selectListInfo(Page p, QueryWrapper<NotTestProject> orderByDesc) {
        return p.setRecords(this.baseMapper.selectListInfo(p,orderByDesc));
    }
}
