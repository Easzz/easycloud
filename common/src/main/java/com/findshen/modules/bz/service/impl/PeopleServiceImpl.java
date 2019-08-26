package com.findshen.modules.bz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.findshen.modules.bz.dao.PeopleDao;
import com.findshen.modules.bz.entity.People;
import com.findshen.modules.bz.service.PeopleService;
import org.springframework.stereotype.Service;

@Service
public class PeopleServiceImpl extends ServiceImpl<PeopleDao, People> implements PeopleService {
}
