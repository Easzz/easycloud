package com.findshen.modules.bz.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by shenxuan on 2018/11/30 9:12
 * 3.x版本不需要写入配置文件，只需要实现此MetaObjectHandler接口即可实现自动填充
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
	@Override
	public void insertFill(MetaObject metaObject) {
		//final Object createTime = getFieldValByName("gmtCreate", metaObject);
		//if (null == createTime) {

		//java bean中的属性名称
		this.setFieldValByName("createTime", new Date(), metaObject);
		//	}
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		//final Object gmtModified = getFieldValByName("gmtModified", metaObject);

		//if (null == gmtModified) {
		//setFieldValByName("gmtModified", new Date(), metaObject);
		//}
	}
}
