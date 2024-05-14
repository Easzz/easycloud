package com.example.deviceManage.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.deviceManage.entity.Item;
import com.example.deviceManage.mapper.ItemMapper;
import com.example.deviceManage.service.ItemService;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {
	@Override
	public IPage<Item> selectPageVo(Page<Item> objectPage, QueryWrapper<Item> itemQueryWrapper) {
		return objectPage.setRecords(this.baseMapper.selectPageVo(objectPage,itemQueryWrapper));
	}
}
