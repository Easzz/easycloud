package com.example.caseProject.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.caseProject.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
