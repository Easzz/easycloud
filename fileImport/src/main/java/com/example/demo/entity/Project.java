package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
