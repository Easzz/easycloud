package com.example.deviceManage.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("device_record")
@NoArgsConstructor
@AllArgsConstructor
public class DeviceRecord extends Model<DeviceRecord> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	private Long deviceId;
	@TableField(exist = false)
	private String deviceName;
	@TableField(exist = false)
	private String realName;

	@TableField(exist = false)
	private String deviceNumber;
	@TableField(exist = false)
	private String typeName;
	@TableField(exist = false)
	private Boolean isDamage;

	@TableField(exist = false)
	private String damageText;



	private Long userId;
	// 0->借出，1->归还、已审核
	private String type;

	//0 未审核，1-同意  2->拒绝
	private Integer agree;

	private String remark;


//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date gmtCreate;


	@TableField(value = "gmt_modified", fill = FieldFill.UPDATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date gmtModified;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date inTime;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date outTime;
}
