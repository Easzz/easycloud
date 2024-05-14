package com.example.deviceManage.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.deviceManage.config.R;
import com.example.deviceManage.entity.Item;
import com.example.deviceManage.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;


	@GetMapping("/list")

	public R<IPage<Item>> list(Integer page, Integer limit) {

		IPage<Item> list = itemService.selectPageVo(new Page<>(page, limit), new QueryWrapper<Item>());

		return R.ok(list);
	}


	@PostMapping("/save")
	public R save(Item item) {

		item.insert();
		return R.ok();
	}


	@GetMapping("/info/{id}")
	public R info(@PathVariable Long id) {

		//userId
		Item byId = itemService.getById(id);

		return R.ok(byId);
	}

	@PostMapping("/update")
	public R update(Item item) {

		//userId
		itemService.updateById(item);

		return R.ok();
	}


	@PostMapping("/delete")
	public R delete(Long id) {
		itemService.removeById(id);

		return R.ok();
	}

}
