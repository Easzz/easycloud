
package com.findshen.stock.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.findshen.stock.entity.DailyData;
import com.findshen.stock.entity.XueQiuVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface XueQiuDao extends BaseMapper<XueQiuVo> {
	
}
