package com.example.deviceManage.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.deviceManage.config.R;
import com.example.deviceManage.entity.AuditVo;
import com.example.deviceManage.entity.Device;
import com.example.deviceManage.entity.DeviceRecord;
import com.example.deviceManage.service.DeviceRecordService;
import com.example.deviceManage.service.DeviceService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

	@Autowired
	private DeviceService deviceService;
	@Autowired
	private DeviceRecordService recordService;


	@GetMapping("/list")

	public R<IPage<Device>> list(Integer page, Integer limit, Device device, Integer queryType) {
		//queryTpe ==1 查询在库的设备(允许借出的设备)
		//queryType==2 查询当前用户已经借出的设备、归还审核中的

		IPage<Device> list = deviceService.selectPageVo(new Page<>(page, limit), new QueryWrapper<Device>()
				.like(StringUtils.isNotBlank(device.getDeviceName()), "device_name", device.getDeviceName())
				.eq(device.getTypeId() != null, "type_id", device.getTypeId())
				.like(StringUtils.isNotBlank(device.getRealName()), "u.real_name", device.getRealName())
				.like(StringUtils.isNotBlank(device.getRemark()), "remark", device.getRemark())
				.eq(device.getRoleId() != null && device.getRoleId() == 1, "user_id", device.getUserId())

				.and(queryType != null && queryType == 2, e -> {
					e.eq("audit_status", "已借出")
							.or()
							.eq("audit_status", "借出审核中")
							.or()
							.eq("audit_status", "归还审核中");
				})
				.isNull(queryType != null && queryType == 1, "user_id")
				.and(queryType != null && queryType == 3, e -> {
					e.eq("audit_status", "借出审核中")
							.or()
							.eq("audit_status", "归还审核中");
				})
				.orderByAsc("type_name","device_number")
		);

		List<Device> records = list.getRecords();
		for (Device record : records) {
			if (record.getUserId() == null) {
				record.setBelong("在库");
			}
			if (record.getIsDamage() != null && record.getIsDamage()) {
				record.setIsDamageText("是");
			} else {
				record.setIsDamageText(" ");
			}


		}
		return R.ok(list);
	}


	@PostMapping("/save")
	public R save(Device device) {

		Integer count = deviceService.count(new QueryWrapper<Device>()
				.eq("device_number", device.getDeviceNumber())
		);
		if (count > 0) {
			return R.failed("已存在重复记录");
		}
		device.setAuditStatus("在库");
		device.insert();
		return R.ok();
	}


	/**
	 * 借出
	 *
	 * @param auditVo
	 * @return
	 */
	@PostMapping("/out")
	public R out(AuditVo auditVo) {
		//userId

		for (Long deviceId : auditVo.getDeviceIds()) {
			Device device = new Device();
			device.setId(deviceId);
			device.setAuditStatus("借出审核中");
//			device.setRemark(auditVo.getRemark());
			deviceService.updateById(device);

			DeviceRecord record = new DeviceRecord();
			record.setDeviceId(deviceId);
			record.setUserId(auditVo.getUserId());
			record.setAgree(0);
			record.setType("借出审核中");
			record.setRemark(auditVo.getRemark());
			record.insert();
		}

		return R.ok();
	}

	/**
	 * 借出审核
	 *
	 * @return
	 */
	@PostMapping("/outAudit")
//	public R outAudit(Long deviceRecordId, Integer agree) {
	public R outAudit(AuditVo auditVo) {
		for (Long deviceRecordId : auditVo.getRecordIds()) {
			DeviceRecord record = recordService.getById(deviceRecordId);

			if (auditVo.getAgree() == 1) {
				//同意
//			Device device = new Device();
//			device.setUserId(record.getUserId());
//			device.setRemark(" ");
//			deviceService.updateById(device);

				deviceService.lambdaUpdate()
						.eq(Device::getId, record.getDeviceId())
						.set(Device::getAuditStatus, "已借出")
						.set(Device::getUserId, record.getUserId())
						.set(Device::getUserId, record.getUserId())
						.set(Device::getRemark, record.getRemark())
						.set(Device::getOutTime, new Date())

						.update();

				record.setId(deviceRecordId);
				record.setAgree(1);
				record.setType("已借出");
				record.setOutTime(new Date());
				record.updateById();


			} else {
				//审核不同意，查询是否还有其他待审核的
				record.setAgree(2);
				recordService.updateById(record);

				List<DeviceRecord> deviceRecords = recordService.list(new LambdaQueryWrapper<DeviceRecord>()
						.ne(DeviceRecord::getUserId, record.getUserId())
						.eq(DeviceRecord::getDeviceId, record.getDeviceId()));
				if (deviceRecords.size() == 0) {
					deviceService.lambdaUpdate()
							.eq(Device::getId, record.getDeviceId())
							.set(Device::getUserId, null)
							.set(Device::getAuditStatus, "在库")
							.set(Device::getRemark, null)
							.update();
				}
			}
		}


		return R.ok();
	}


	//归还
	@PostMapping("/in")
	public R in(AuditVo auditVo) {

		Long[] recordIds = auditVo.getRecordIds();
		for (Long recordId : recordIds) {

			DeviceRecord byId = recordService.getById(recordId);
			//userId
			Device device = new Device();
			device.setId(byId.getDeviceId());
			device.setAuditStatus("归还审核中");
			deviceService.updateById(device);

			DeviceRecord record = new DeviceRecord();
			record.setId(recordId);
			record.setType("归还审核中");
			record.setUserId(byId.getUserId());
			record.setDeviceId(byId.getDeviceId());
			record.setAgree(0);
			record.updateById();
		}

		return R.ok();
	}


	/**
	 * 单个用户归还审核，需要填写损坏情况。
	 *
	 * @param deviceRecordId
	 * @param agree
	 * @param isDamage
	 * @param damageText
	 * @return
	 */
	@PostMapping("/inAuditSingle")
	public R inAuditSingle(Long deviceRecordId, Integer agree, Boolean isDamage, String damageText) {
		DeviceRecord record = recordService.getById(deviceRecordId);

		if (agree == 1) {
			//同意
			Device device = new Device();
			device.setId(record.getDeviceId());
			device.setAuditStatus("在库");
			device.setIsDamage(isDamage);
			deviceService.updateById(device);

			device.setUserId(null);
			deviceService.lambdaUpdate()
					.eq(Device::getId, record.getDeviceId())
					.set(Device::getUserId, null)
					.set(Device::getAuditStatus, "在库")
					.set(Device::getRemark, null)
					.set(Device::getOutTime, null)
					.set(Device::getInTime, new Date())

					.update();
			DeviceRecord deviceRecord = new DeviceRecord();
			deviceRecord.setId(deviceRecordId);
			deviceRecord.setAgree(1);
			deviceRecord.setType("已归还");
			deviceRecord.setInTime(new Date());
			recordService.updateById(deviceRecord);

		} else {
			//还原用户
//			device.setUserId(null);
//			deviceService.lambdaUpdate()
//					.set(Device::getUserId, null)
//					.set(Device::getAuditStatus,"在库")
//					.update();
		}
		return R.ok();
	}

	@PostMapping("/inAudit")
//	public R in(Long deviceRecordId, Integer agree, Boolean isDamage, String damageText) {
	public R inAudit(AuditVo auditVo) {
		Long[] recordIds = auditVo.getRecordIds();
		for (Long recordId : recordIds) {
			DeviceRecord record = recordService.getById(recordId);

			if (auditVo.getAgree() == 1) {
				//同意
				Device device = new Device();
				device.setId(record.getDeviceId());
				device.setAuditStatus("在库");
				device.setIsDamage(auditVo.getIsDamage());
				deviceService.updateById(device);

				device.setUserId(null);
				deviceService.lambdaUpdate()
						.eq(Device::getId, record.getDeviceId())
						.set(Device::getUserId, null)
						.set(Device::getAuditStatus, "在库")
						.set(Device::getRemark, null)
						.set(Device::getOutTime, null)
						.set(Device::getInTime, new Date())

						.update();
				DeviceRecord deviceRecord = new DeviceRecord();
				deviceRecord.setId(recordId);
				deviceRecord.setAgree(1);
				deviceRecord.setType("已归还");
				deviceRecord.setInTime(new Date());
				recordService.updateById(deviceRecord);

			} else {
				//还原用户
//			device.setUserId(null);
//			deviceService.lambdaUpdate()
//					.set(Device::getUserId, null)
//					.set(Device::getAuditStatus,"在库")
//					.update();
				deviceService.lambdaUpdate()
						.eq(Device::getId, record.getDeviceId())
						.set(Device::getAuditStatus, "已借出")
						.set(Device::getUserId, record.getUserId())
						.update();

				record.setAgree(1);
				record.setType("已借出");
				record.updateById();

			}
		}
		return R.ok();
	}


	@GetMapping("/info/{id}")
	public R info(@PathVariable Long id) {

		//userId
		Device byId = deviceService.getById(id);

		return R.ok(byId);
	}

	@PostMapping("/update")
	public R update(Device device) {

		//userId
		deviceService.updateById(device);

		return R.ok();
	}


	@PostMapping("/delete")
	public R delete(Long id) {
		//userId
		deviceService.removeById(id);

		return R.ok();
	}

}
