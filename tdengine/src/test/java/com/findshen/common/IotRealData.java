package com.findshen.common;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 声明为 mongodb 文档
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IotRealData implements Serializable {
	private static final long serialVersionUID = 1L;
	/**
	 * 实时数据ID
	 */
	@TableId(type = IdType.INPUT)
	private String id;
	/**
	 * 项目编码
	 */
	@ApiModelProperty("项目编码")
	private String projectCode;
	private String projectId;

	@ApiModelProperty("企业id")
	private Long tenantId;

	@ApiModelProperty("站点id")
	private String siteId;

	@ApiModelProperty("站点编码")
	private String siteCode;

	@ApiModelProperty("站点名称")
	private String siteName;

	/**
	 * 监测设施ID
	 */
	@ApiModelProperty("设施id")
	private String facilityId;

	/**
	 * 监测设施名
	 */
	@ApiModelProperty("设施名")
	private String facilityName;

	/**
	 * 监测设备参数ID
	 */
	@ApiModelProperty("参数id")
	private String paramId;

	/**
	 * 参数唯一编码(项目下唯一)
	 */
	@ApiModelProperty("参数唯一编码(项目下唯一)")
	private String uniqueCode;
	/**
	 * 参数代码
	 */
	@ApiModelProperty("参数代码")
	private String paramCode;
	/**
	 * 参数名称
	 */
	@ApiModelProperty("参数名称")
	private String paramName;
	/**
	 * 参数标签，比如统计进水出水流量
	 */
	@ApiModelProperty("参数标签")
	private String paramTag;

	@ApiModelProperty(value = "该参数是否需要统计 1->需要")
	private Integer needReport;
	/**
	 * 参数单位
	 */
	@ApiModelProperty(value = "参数单位")
	private String paramUnit = "";
	/**
	 * 保留小数位数
	 */
	@ApiModelProperty(value = "保留小数位数")
	private Integer formatLength;

	/**
	 * 监测时间（标准格式）
	 */
	@ApiModelProperty("监测时间")
	private LocalDateTime monitorTime;

	/**
	 * 数据是否正常
	 */
	@ApiModelProperty("数据是否正常")
	private Boolean normalIf;

	private LocalDateTime abnormalTime;
	/**
	 * 删除标记 0 未删除 1 已删除
	 */
	@ApiModelProperty("删除标记 0 未删除 1 已删除")
	private Integer delFlag;
	/**
	 * 量程转换前的值(原始上传数据)
	 */
	@ApiModelProperty("量程转换前的数值")
	private String originData;

	/**
	 * 质量标准级别
	 * 0.Ⅰ级（达标为优）
	 * 1.Ⅱ级（达标为良）
	 * 2.Ⅲ级（达标合格）
	 * 3.Ⅳ级（轻度超标）
	 * 4.Ⅴ级（中度超标）
	 * 5.Ⅵ级（重度超标）
	 * 6.Ⅶ级（严重超标）
	 */
	@ApiModelProperty("质量标准级别")
	private Integer qualityLevel;
	/**
	 * 参数质量标准ID
	 */
	@ApiModelProperty("参数质量标准ID")
	private Long qualityId;
	/**
	 * 标准异常提示信息
	 */
	private String qualityHintInfo = "";
	/**
	 * 警报信息
	 */
	@ApiModelProperty("警报信息")
	private String alertLevelMsg = "";

	/**
	 * 四舍五入后格式化的值
	 */
	private String paramValue = "";

	/**
	 * 上一次参数值
	 */
	private String lastParamValue;

	/**
	 * 存储区间
	 */
	private String localStorage;

	/**
	 * 相对于上一个上传区间值，是否发生改变
	 * 1->改变。0->未改变
	 */
	private Boolean changedIf;

	private Integer paramKind;
	/**
	 * 网关标签
	 */
	private String dtuTag;


	/**
	 * 物联网传输间隔时间
	 */
	@ApiModelProperty("物联网传输间隔时间")
	private Long uploadInterval;

	/**
	 * 创建时间
	 */
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	@ApiModelProperty(value = "创建时间")
	private LocalDateTime gmtCreate;
	/**
	 * 修改时间
	 */
	@TableField(value = "gmt_modified", fill = FieldFill.UPDATE)
	@ApiModelProperty(value = "修改时间")
	private LocalDateTime gmtModified;


}
