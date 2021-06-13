package com.example.deviceManage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@TableName("project_item")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectItem extends Model<ProjectItem> {
	private static final long serialVersionUID = 1L;

	/**
	 * 报废id
	 */
	@TableId
	private Long id;

	@ApiModelProperty(value = "设备id")
	private Long projectId;

	private String driveName;

	private String platform;

	private String manufacturer;

	private String description;

	@TableField(exist = false)
	private List<ProjectItemSub> win7SubList;

	@TableField(exist = false)
	private List<ProjectItemSub> win10SubList;

}
