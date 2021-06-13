package com.example.deviceManage.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.deviceManage.entity.Device;
import com.example.deviceManage.entity.DeviceType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceTypeMapper extends BaseMapper<DeviceType> {

}
