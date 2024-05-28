package com.example.caseProject.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.caseProject.entity.Standard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StandardMapper extends BaseMapper<Standard> {


	List<Standard> selectPaveVo(Page<Standard> objectPage, @Param("ew") QueryWrapper<Standard> caseQueryWrapper);
}
