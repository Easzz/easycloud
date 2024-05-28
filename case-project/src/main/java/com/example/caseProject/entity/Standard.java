package com.example.caseProject.entity;

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
@TableName("standard")
@NoArgsConstructor
@AllArgsConstructor
public class Standard extends Model<Standard> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	private Long typeId;

	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date updateTime;

	@TableField(exist = false)
	private String updateTimeStr;

	private String caseVersion;

	private String fileUrl;
	private String realityName;


	//	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date gmtCreate;


	@TableField(value = "gmt_modified", fill = FieldFill.UPDATE)
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date gmtModified;


	@TableField(exist = false)
	private String typeName;

}
