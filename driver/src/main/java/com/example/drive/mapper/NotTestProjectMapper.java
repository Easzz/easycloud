package com.example.drive.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.drive.entity.NotTestProject;
import com.example.drive.entity.Project;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NotTestProjectMapper extends BaseMapper<NotTestProject> {

	List<NotTestProject> selectListInfo(Page p, @Param("ew") QueryWrapper<NotTestProject> orderByDesc);

	Project selectInfo(@Param("notTestProjectId") Long notTestProjectId);
}
