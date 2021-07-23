package com.example.drive.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("platfrom")
@NoArgsConstructor
@AllArgsConstructor
public class Terrace extends Model<Terrace> {
	private static final long serialVersionUID = 1L;

	@TableId
	private Long id;

	@ApiModelProperty(value = "平台名称")
	private Long terraceName;


	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	private Date gmtCreate;

}
