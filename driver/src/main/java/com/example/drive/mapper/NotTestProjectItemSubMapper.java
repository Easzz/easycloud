package com.example.drive.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.drive.entity.NotTestProjectItemSub;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NotTestProjectItemSubMapper extends BaseMapper<NotTestProjectItemSub> {

	List<NotTestProjectItemSub> selectInfo(@Param("ew") QueryWrapper<NotTestProjectItemSub> projectItemSubQueryWrapper);
}
