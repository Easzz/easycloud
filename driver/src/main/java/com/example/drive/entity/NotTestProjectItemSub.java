package com.example.drive.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("not_test_project_item_sub")
@NoArgsConstructor
@AllArgsConstructor
public class NotTestProjectItemSub extends Model<NotTestProjectItemSub> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
//	@ApiModelProperty(value = "设备id")
//	private Long projectId;
	private String driveName;
//	private String platform;

	/**
	 * 芯片类型
	 */
	private String manufacturer;

	private String version;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern="yyyy/MM/dd",timezone="GMT+8")
	private Date driveDate;
	private String url;
	private String description;

	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	private Date gmtCreate;

	private Long notTestTerrace_id;

	@TableField(exist = false)
	private String terraceName;


}
