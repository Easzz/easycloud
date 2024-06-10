package com.example.caseProject.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.caseProject.entity.CaseProject;
import com.example.caseProject.entity.PermissionUser;
import com.example.caseProject.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PermissionUserMapper extends BaseMapper<PermissionUser> {
    List<PermissionUser> selectPaveVo(Page<PermissionUser> objectPage, @Param("ew") QueryWrapper<PermissionUser> caseQueryWrapper);
}
