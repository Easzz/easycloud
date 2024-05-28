package com.example.caseProject.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.caseProject.config.R;
import com.example.caseProject.entity.Standard;
import com.example.caseProject.service.StandardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/standard")
public class StandardController {

	@Autowired
	private StandardService standardService;


	@GetMapping("/list")
	public R<IPage<Standard>> list(Integer page, Integer limit, Standard standard) {

		IPage<Standard> list = standardService.selectPageVo(new Page<>(page, limit), new QueryWrapper<Standard>()
				.eq(standard.getTypeId() != null, "s.type_id", standard.getTypeId())
		);

		return R.ok(list);
	}


	@PostMapping("/save")
	public R save(Standard device) {

		DateTime parse = DateUtil.parse(device.getUpdateTimeStr());
		device.setUpdateTime(parse);

		device.insert();
		return R.ok();
	}


	@GetMapping("/info/{id}")
	public R info(@PathVariable Long id) {

		//userId
		Standard byId = standardService.getById(id);

		return R.ok(byId);
	}

	@PostMapping("/update")
	public R update(Standard ca) {

		//userId
		standardService.updateById(ca);

		return R.ok();
	}


	@PostMapping("/delete")
	public R delete(Long id) {
		standardService.removeById(id);

		return R.ok();
	}

}
