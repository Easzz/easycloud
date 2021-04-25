
package com.findshen.stock.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.findshen.stock.entity.DailyData;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DailyDataDao extends BaseMapper<DailyData> {
	
}
