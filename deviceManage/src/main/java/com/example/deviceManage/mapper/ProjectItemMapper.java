package com.example.deviceManage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectItemMapper extends BaseMapper<ProjectItem> {

	List<ProjectItemSub> buildList(Long projectId);
}
