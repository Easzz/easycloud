package com.example.deviceManage.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.deviceManage.entity.DeviceRecord;
import com.example.deviceManage.entity.DeviceType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeviceRecordMapper extends BaseMapper<DeviceRecord> {

    List<DeviceRecord> selectPageVo(Page<DeviceRecord> objectPage, @Param("ew") QueryWrapper<DeviceRecord> agree);
}
