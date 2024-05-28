package com.example.caseProject.controller;
/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.caseProject.config.R;
import com.example.caseProject.entity.StandardType;
import com.example.caseProject.service.StandardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/standardType")
public class StandardTypeController {

	@Autowired
	private StandardTypeService standardTypeService;


	@GetMapping("/list")

	public R<IPage<StandardType>> list(Integer page, Integer limit) {
		if (null == page) {
			page = 0;
		}
		if (null == limit) {
			limit = -1;
		}

		IPage<StandardType> list = standardTypeService.page(new Page<>(page, limit));

		return R.ok(list);
	}


	@PostMapping("/save")
	public R save(StandardType caseType) {

		caseType.insert();
		return R.ok();
	}


	@GetMapping("/info/{id}")
	public R info(@PathVariable Long id) {

		//userId
		StandardType byId = standardTypeService.getById(id);

		return R.ok(byId);
	}

	@PostMapping("/update")
	public R update(StandardType caseType) {

		//userId
		standardTypeService.updateById(caseType);

		return R.ok();
	}


	@PostMapping("/delete")
	public R delete(Long id) {
		standardTypeService.removeById(id);

		return R.ok();
	}

}
