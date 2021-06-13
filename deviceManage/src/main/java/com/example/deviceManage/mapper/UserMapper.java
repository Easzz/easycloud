package com.example.deviceManage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.deviceManage.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
