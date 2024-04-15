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
@TableName("device")
@NoArgsConstructor
@AllArgsConstructor
public class Device extends Model<Device> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	private String deviceName;
	private Long typeId;
	private Long userId;


	// 在库，归属人
	@TableField(exist = false)
	private String belong;

	// 归属人姓名
	@TableField(exist = false)
	private String realName;

	//0 ->管理员  1->用户
	@TableField(exist = false)
	private Integer roleId;

	/**
	 * 是否损坏，1损坏，0未损坏
	 */
	private Boolean isDamage;


	@TableField(exist = false)
	private String isDamageText;

	private String deviceNumber;

	/**
	 * 损坏情况
	 */

	private String damageText;
	/**
	 * 0->在库。1->借出审核中。2->已借出。3->归还审核中
	 */
	private String auditStatus;
	private Integer valid;
	private String typeName;


	//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date gmtCreate;


	@TableField(value = "gmt_modified", fill = FieldFill.UPDATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date gmtModified;

	private String remark;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date inTime;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date outTime;
}
