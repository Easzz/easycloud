package com.example.drive.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.drive.entity.ProjectItemSub;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectItemSubMapper extends BaseMapper<ProjectItemSub> {

	List<ProjectItemSub> selectInfo(@Param("ew") QueryWrapper<ProjectItemSub> projectItemSubQueryWrapper);
}
