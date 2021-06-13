package com.example.drive.entity;

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
@TableName("project")
@NoArgsConstructor
@AllArgsConstructor
public class Project extends Model<Project> {
	private static final long serialVersionUID = 1L;

	/**
	 * 报废id
	 */
	@TableId
	private Long id;
	/**
	 * 设备id
	 */
	@ApiModelProperty(value = "设备id")
	private String projectName;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	private Date gmtCreate;
}
