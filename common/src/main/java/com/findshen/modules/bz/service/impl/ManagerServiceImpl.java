package com.findshen.modules.bz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.findshen.modules.bz.dao.ManagerDao;
import com.findshen.modules.bz.entity.Manager;
import com.findshen.modules.bz.service.ManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerDao, Manager> implements ManagerService {
}
