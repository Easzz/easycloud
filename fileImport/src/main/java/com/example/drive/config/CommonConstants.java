package com.example.drive.config;/*
 *
 *      Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the pig4cloud.com developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: lengleng (wangiegie@gmail.com)
 *
 */


/**
 * @author lengleng
 * @date 2017/10/29
 */
public interface CommonConstants {
	/**
	 * 超级管理员用户
	 */
	String ADMIN_USERNAME = "admin";
	/**
	 * 超级管理员用户ID
	 */
	Integer ADMIN_USER_ID = 1;
	/**
	 * header 中租户ID
	 */
	String TENANT_ID = "TENANT_ID";
	String WX_TENANT_ID = "TENANTID";
	/**
	 * 删除
	 */
	String STATUS_DEL = "1";
	/**
	 * 正常
	 */
	String STATUS_NORMAL = "0";
	/**
	 * 删除
	 */
	Integer STATUS_DEL_FLAG = 1;
	/**
	 * 正常
	 */
	Integer STATUS_NORMAL_FLAG = 0;

	/**
	 * 锁定
	 */
	String STATUS_LOCK = "9";

	/**
	 * 菜单
	 */
	String MENU = "0";

	String BUTTON = "1";
	/**
	 * 编码
	 */
	String UTF8 = "UTF-8";

	/**
	 * 前端工程名
	 */
	String FRONT_END_PROJECT = "pigx-ui";

	/**
	 * 后端工程名
	 */
	String BACK_END_PROJECT = "pigx";

	/**
	 * 路由存放
	 */
	String ROUTE_KEY = "gateway_route_key";

	/**
	 * spring boot admin 事件key
	 */
	String EVENT_KEY = "event_key";

	/**
	 * 验证码前缀
	 */
	String DEFAULT_CODE_KEY = "DEFAULT_CODE_KEY_";

	/**
	 * 成功标记
	 */
	Integer SUCCESS = 0;
	/**
	 * 失败标记
	 */
	Integer FAIL = 1;

	/**
	 * minio 默认存储bucket
	 */
	String BUCKET_NAME = "sti";
	/**
	 * minio微信存储文件
	 */
	String WEIXIN_BUCKET = "weixin";
	/**
	 * 设备二维码存储文件
	 */
	String DEVICE_QR_BUCKET = "deviceqr";

	/**
	 * SysTenant表的privilege_access字段
	 */
	String MENU_ACCESS = "Menu";

	String BUTTON_ACCESS = "Button";

	String TENANT_ACCESS = "Tenant";

	String FACILITY_ACCESS = "Facility";

	String REPORT_ACCESS = "Report";

	String TABLE_ACCESS = "Table";

	/**
	 * 开关的1 0 对应
	 */
	// 开
	Integer SWITCH_OPEN = 0;
	// 关
	Integer SWITCH_CLOSE = 1;

	/**
	 * 滑块验证码
	 */
	String IMAGE_CODE_TYPE = "blockPuzzle";

	/**
	 * 临时文件夹
	 */
	String FILE_FOLDER_TEMP = "/temp/media";

}
