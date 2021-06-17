package com.example.deviceManage.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.deviceManage.config.R;
import com.example.deviceManage.entity.DeviceRecord;
import com.example.deviceManage.service.DeviceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deviceRecord")
public class DeviceRecordController {

    @Autowired
    private DeviceRecordService deviceRecordService;

    @GetMapping("/list")
    public R<IPage<DeviceRecord>> list(Integer page, Integer limit,Integer agree,String type) {

        IPage<DeviceRecord> list = deviceRecordService.selectPageVo(new Page<>(page, limit), new QueryWrapper<DeviceRecord>()
                .eq(agree!=null,"r.agree",agree)
                .eq(type!=null,"type",type)
                .orderByDesc("d.type_name")
        );

        return R.ok(list);
    }


}
