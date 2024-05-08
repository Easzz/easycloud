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
import org.apache.commons.lang.StringUtils;
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
	public R<IPage<DeviceRecord>> list(Integer page, Integer limit,Integer deviceTypeId, Integer agree, String type, Long userId, Integer showType) {
		//showType=1 已借出 || 归还审核中

		IPage<DeviceRecord> list = deviceRecordService.selectPageVo(new Page<>(page, limit), new QueryWrapper<DeviceRecord>()
				.eq(agree != null, "r.agree", agree)
				.eq(StringUtils.isNotBlank(type), "type", type)
				.eq(deviceTypeId != null, "d.type_id", deviceTypeId)
//				.and(showType != null && showType == 1, e -> e.eq("type", "已借出")
//						.or()
//						.eq("type", "归还审核中")
//						.or()
//						.eq("type", "借出审核中")
//				)
				.eq(userId!=null,"r.user_id", userId)
				.orderByAsc("d.type_name","d.device_number")
		);

		return R.ok(list);
	}


}
