package com.erp.service;

import com.erp.entity.UsersBean;
import org.springframework.stereotype.Service;


@Service
public class UserService extends BaseService<UsersBean,Integer>{
    //引入dao层接口
   /* @Autowired
    UserDao userDao;


     public UsersEntity findByName(String username) {
        return  userDao.findByName(username);
    }


     public int newUser(UsersEntity entity) {
        return userDao.newUser(entity.getUsername(),entity.getUserpwd());
    }



    public List<UsersEntity> selectALL() {
        return userDao.selectAll();
    }*/

}


