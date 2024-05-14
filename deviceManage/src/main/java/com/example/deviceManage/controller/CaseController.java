package com.example.deviceManage.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.deviceManage.config.R;
import com.example.deviceManage.entity.Case;
import com.example.deviceManage.entity.Item;
import com.example.deviceManage.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Case")
public class CaseController {

	@Autowired
	private CaseService caseService;


	@GetMapping("/list")

	public R<IPage<Case>> list(Integer page, Integer limit) {

		IPage<Case> list = caseService.selectPageVo(new Page<>(page, limit), new QueryWrapper<Case>());

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
		Case byId = caseService.getById(id);

		return R.ok(byId);
	}

	@PostMapping("/update")
	public R update(Case ca) {

		//userId
		caseService.updateById(ca);

		return R.ok();
	}


	@PostMapping("/delete")
	public R delete(Long id) {
		caseService.removeById(id);

		return R.ok();
	}

}
