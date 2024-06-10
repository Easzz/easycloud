package com.example.caseProject.controller;
/**
 * Created by shenxuan on 2021/5/28 11:51
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.caseProject.config.R;
import com.example.caseProject.entity.PermissionUser;
import com.example.caseProject.entity.User;
import com.example.caseProject.mapper.UserMapper;
import com.example.caseProject.service.PermissionUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/permissionUser")
public class PermissionUserController {

    @Autowired
    private UserMapper userMapper;

	@Autowired
	private PermissionUserService permissionUserService;
    @GetMapping("/check")
    public R login(Integer userId) {
		User one = userMapper.selectOne(new QueryWrapper<User>()
				.eq("id", userId)

				.eq("valid", 1)
		);
		if (one!=null){

			IPage<PermissionUser> list = permissionUserService.selectPageVo(new Page<>(1, 1000), new QueryWrapper<PermissionUser>()
							.eq("1",1)
					.apply("FIND_IN_SET({0},p.user_ids)",one.getId())
			);

			List<Integer> permissionIds=new ArrayList<>();
			list.getRecords().forEach(e->{
				permissionIds.add(e.getTypeNumber());
			});
			one.setPermissionIds(permissionIds);
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
