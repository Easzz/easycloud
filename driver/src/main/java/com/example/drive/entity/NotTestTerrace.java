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
import java.util.List;

@Data
@TableName("not_test_terrace")
@NoArgsConstructor
@AllArgsConstructor
public class NotTestTerrace extends Model<NotTestTerrace> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	@ApiModelProperty(value = "未测试平台名称")
	private String terraceName;

	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	private Date gmtCreate;

	@TableField(exist = false)
	private List<Project> projectList;

}
