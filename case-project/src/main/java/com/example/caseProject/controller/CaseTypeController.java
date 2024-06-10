package com.example.caseProject.controller;
/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.caseProject.entity.CaseType;
import com.example.caseProject.service.CaseTypeService;
import com.example.caseProject.config.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caseType")
public class CaseTypeController {

	@Autowired
	private CaseTypeService caseTypeService;


	@GetMapping("/list")

	public R<IPage<CaseType>> list(Integer page, Integer limit,Integer userId) {
		if (null == page) {
			page = 0;
		}
		if (null == limit) {
			limit = -1;
		}

		IPage<CaseType> list = caseTypeService.page(new Page<>(page, limit),new QueryWrapper<CaseType>()

				.apply("FIND_IN_SET({0},user_ids)",userId)
		);

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
