
package com.findshen.modules.bz.service;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.findshen.modules.bz.entity.People;

public interface PeopleService extends IService<People> {

	Page<People> selectVoList(Page<People> peoplePage, QueryWrapper<People> peopleQueryWrapper);

	Page<People> selectVoList4Lambda(Page<People> peoplePage, LambdaQueryWrapper<People> lambda);
}
