package com.example.deviceManage.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.deviceManage.config.R;
import com.example.deviceManage.entity.CaseType;
import com.example.deviceManage.service.CaseTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Case")
public class CaseTypeController {

	@Autowired
	private CaseTypeService caseTypeService;


	@GetMapping("/list")

	public R<IPage<CaseType>> list(Integer page, Integer limit) {

		IPage<CaseType> list = caseTypeService.page(new Page<>(page, limit));

		return R.ok(list);
	}


	@PostMapping("/save")
	public R save(CaseType caseType) {

		caseType.insert();
		return R.ok();
	}


	@GetMapping("/info/{id}")
	public R info(@PathVariable Long id) {

		//userId
		CaseType byId = caseTypeService.getById(id);

		return R.ok(byId);
	}

	@PostMapping("/update")
	public R update(CaseType caseType) {

		//userId
		caseTypeService.updateById(caseType);

		return R.ok();
	}


	@PostMapping("/delete")
	public R delete(Long id) {
		caseTypeService.removeById(id);

		return R.ok();
	}

}
