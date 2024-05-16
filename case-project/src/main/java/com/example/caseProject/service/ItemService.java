package com.example.caseProject.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.caseProject.entity.Item;

/**
 * @author findshen
 */
public interface ItemService extends IService<Item> {

	IPage<Item> selectPageVo(Page<Item> objectPage, QueryWrapper<Item> itemQueryWrapper);
}
