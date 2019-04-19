package com.erp.service.impl;


import com.erp.dao.SysMenuDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysMenuServiceImplTest {
    @Resource
    SysMenuDao sysMenuDao;
    @Test
    public void contextLoads() {
        System.out.println(sysMenuDao.MenuList());
    }

}
