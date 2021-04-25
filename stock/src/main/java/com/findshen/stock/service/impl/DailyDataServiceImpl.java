package com.findshen.stock.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.findshen.stock.dao.DailyDataDao;
import com.findshen.stock.entity.DailyData;
import com.findshen.stock.service.DailyDataService;
import org.springframework.stereotype.Service;

@Service
public class DailyDataServiceImpl extends ServiceImpl<DailyDataDao, DailyData> implements DailyDataService {
}
