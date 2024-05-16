package com.example.caseProject.controller;
/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.caseProject.config.R;
import com.example.caseProject.entity.Item;
import com.example.caseProject.service.ItemService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;


	@GetMapping("/list")

	public R<IPage<Item>> list(Integer page, Integer limit,Item item) {


		IPage<Item> list = itemService.page(new Page<>(page, limit), new LambdaQueryWrapper<Item>()

				.eq(StringUtils.isNotBlank(item.getItemName()), Item::getItemName, item.getItemName())

		);


		return R.ok(list);
	}


	@PostMapping("/save")
	public R save(Item item) {

		DateTime parse = DateUtil.parse(item.getItemDateStr());
		item.setItemDate(parse);

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
