package com.example.deviceManage.entity;

/**
 * Created by shenxuan on 2018/12/5 17:11
 * 附件多媒体类型
 */
public enum AttachmentMediaEnum {
	IMAGE("image"),
	PDF("pdf");

	private String description;

	AttachmentMediaEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
