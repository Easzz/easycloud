package com.example.deviceManage.controller;

/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.deviceManage.config.R;
import com.example.deviceManage.entity.User;
import com.example.deviceManage.mapper.UserMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public R login(User user) {
		User one = userMapper.selectOne(new QueryWrapper<User>()
				.eq("username", user.getUsername())
				.eq("pwd", user.getPwd())
				.eq("valid", 1)
		);
		if (one!=null){
			return R.ok(one);
		}

		return R.failed();
    }



	@GetMapping("/list")
	public R<IPage<User>> list(Integer page, Integer limit, User user) {
		IPage list = userMapper.selectPage(new Page<>(page,limit), new QueryWrapper<User>()
				.like(StringUtils.isNotBlank(user.getUsername()), "username", user.getUsername())
				.orderByAsc("username")
		);

		return R.ok(list);
	}


	@PostMapping("/save")
	public R save(User user) {
		Integer count = userMapper.selectCount(new QueryWrapper<User>()
				.eq("username", user.getUsername())
		);
		if (count > 0) {
			return R.failed("已存在重复记录");
		}

		user.insert();
		return R.ok();
	}

	@PostMapping("/update")
	public R update(User user) {

		user.updateById();
		return R.ok();
	}




}
