package com.findshen.stock.entity;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by findshen on 2021/4/24 15:13
 * 每日数据
 */
@Data
@TableName("daily_data")
public class DailyData {
	/**
	 * 日期
	 */
	private Date stockDate;
	/**
	 * 代码
	 */
	private String stockCode;
	/**
	 * 名称
	 */
	private String stockName;
	/**
	 * 现价
	 */
	private double xj;
	/**
	 * 涨跌幅
	 */
	private double zdf;
	/**
	 * 涨跌
	 */
	private double zd;
	/**
	 * 涨速
	 */
	private double zs;
	/**
	 * 换手
	 */
	private double hs;
	/**
	 * 量比
	 */
	private double lb;
	/**
	 * 振幅
	 */
	private String zf;
	/**
	 * 成交额
	 */
	private String cje;
	/**
	 * 流通股
	 */
	private String ltg;
	/**
	 * 流通市值
	 */
	private String ltsz;
	/**
	 * 市盈率
	 */
	private String syl;

	/**
	 * 创建时间
	 */
	@TableField(value = "gmt_create", fill = FieldFill.INSERT)
	private LocalDateTime gmtCreate;
	/**
	 * 修改时间
	 */
	@TableField(value = "gmt_modified", fill = FieldFill.UPDATE)
	private LocalDateTime gmtModified;

}
