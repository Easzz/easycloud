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
@TableName("permission_user")
@NoArgsConstructor
@AllArgsConstructor
public class PermissionUser extends Model<PermissionUser> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	private Integer typeNumber;
	private String userIds;



}
