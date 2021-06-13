package com.example.deviceManage.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
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
	private String damage;
	private Integer auditStatus;
	private Integer valid;


//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	private Date gmtCreate;


	@TableField(value = "gmt_modified", fill = FieldFill.INSERT)
	private Date gmtModified;
}
