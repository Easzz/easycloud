package com.example.drive.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.drive.entity.NotTestProjectItem;
import com.example.drive.entity.NotTestProjectItemSub;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotTestProjectItemMapper extends BaseMapper<NotTestProjectItem> {

	List<NotTestProjectItemSub> buildList(Long projectId);
}
