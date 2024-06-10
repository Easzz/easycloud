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
import com.example.caseProject.entity.CaseProject;
import com.example.caseProject.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/caseProject")
public class CaseProjectController {

	@Autowired
	private CaseService caseService;


	@GetMapping("/list")
	public R<IPage<CaseProject>> list(Integer page, Integer limit, CaseProject caseInfo,Integer userId) {

		IPage<CaseProject> list = caseService.selectPageVo(new Page<>(page, limit), new QueryWrapper<CaseProject>()
				.eq(caseInfo.getTypeId() != null, "c.type_id", caseInfo.getTypeId())
				.apply("FIND_IN_SET({0},ct.user_ids)",userId)
		);

		return R.ok(list);
	}


	@PostMapping("/save")
	public R save(CaseProject device) {

		DateTime parse = DateUtil.parse(device.getUpdateTimeStr());
		device.setUpdateTime(parse);

		device.insert();
		return R.ok();
	}


	@GetMapping("/info/{id}")
	public R info(@PathVariable Long id) {

		//userId
		CaseProject byId = caseService.getById(id);

		return R.ok(byId);
	}

	@PostMapping("/update")
	public R update(CaseProject ca) {

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
