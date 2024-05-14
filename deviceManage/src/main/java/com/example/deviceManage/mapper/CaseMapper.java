package com.example.deviceManage.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.deviceManage.entity.Case;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CaseMapper extends BaseMapper<Case> {


	List<Case> selectPaveVo(Page<Case> objectPage,@Param("ew") QueryWrapper<Case> caseQueryWrapper);
}
