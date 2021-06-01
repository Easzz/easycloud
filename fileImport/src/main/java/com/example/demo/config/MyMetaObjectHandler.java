package com.example.demo.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by shenxuan on 2019年11月25日17:00:00
 * 使用mp框架生成创建时间以及修改时间
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		final Object createTime = getFieldValByName("gmtCreate", metaObject);
		if (null == createTime) {
			this.setFieldValByName("gmtCreate", new Date(), metaObject);
		}
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		final Object gmtModified = getFieldValByName("gmtModified", metaObject);

		if (null == gmtModified) {
			setFieldValByName("gmtModified", new Date(), metaObject);
		}
	}
}
