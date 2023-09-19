package com.example.drive.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.drive.entity.NotTestProject;
import org.apache.ibatis.annotations.Param;

public interface NotTestProjectService extends IService<NotTestProject> {
    IPage<NotTestProject> selectListInfo(Page p, @Param("ew") QueryWrapper<NotTestProject> orderByDesc);
}
