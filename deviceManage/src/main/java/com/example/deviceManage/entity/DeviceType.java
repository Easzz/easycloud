package com.example.deviceManage.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("device_type")
@NoArgsConstructor
@AllArgsConstructor
public class DeviceType extends Model<DeviceType> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	private String typeName;
	private Integer valid;


//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	private Date gmtCreate;


	@TableField(value = "gmt_modified", fill = FieldFill.INSERT)
	private Date gmtModified;
}
