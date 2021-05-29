package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@TableName("project_item_sub")
@NoArgsConstructor
@AllArgsConstructor
public class ProjectItemSub extends Model<ProjectItemSub> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;
	@ApiModelProperty(value = "设备id")
	private Long projectId;
	private Long projectItemId;
	private String driveName;
	private String platform;

	private String version;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date driveDate;
	private String url;


}
