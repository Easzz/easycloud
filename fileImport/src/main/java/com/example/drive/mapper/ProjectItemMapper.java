package com.example.drive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.drive.entity.ProjectItem;
import com.example.drive.entity.ProjectItemSub;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProjectItemMapper extends BaseMapper<ProjectItem> {

	List<ProjectItemSub> buildList(Long projectId);
}
