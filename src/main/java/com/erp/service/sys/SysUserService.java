package com.erp.service.sys;
import com.erp.Mapper.UserSource.sys.SysMenuMapper;
import com.erp.common.utils.Constant;
import com.erp.config.redis.RedisKeys;
import com.erp.config.redis.RedisUtil;
import com.erp.entity.sys.SysMenuBean;
import com.erp.entity.sys.SysUserBean;
import com.erp.service.BaseService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

@Service
public class SysUserService extends BaseService<SysUserBean,Long> {
    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    RedisUtil redisUtil;

    /*
    * 获取用户角色数据
    * */
    public Set<String> findRoles(String userName)
    {
        Set<String> permsSet = new HashSet<>();

        return  permsSet;
    }
    /*
     * 获取用户菜单数据
     */

    public Set<String> findPermissions(Long userId,boolean fromCache) {

        if (!fromCache) {
            return findPermissions(userId, false);
        } else {
            List<String> permsList;
            List<SysMenuBean> menuList;
            //用户权限列表
            Set<String> permsSet = new HashSet<>();
            SysUserBean entity = findById(userId);
            String key = RedisKeys.getUserPermissions(userId);

            if (!redisUtil.exists(key)) {
                if (entity != null && entity.getStatus() != 0) {

                    //系统管理员，拥有最高权限
                    if (entity.getUserId() == Constant.SUPER_ADMIN) {
                        menuList = sysMenuService.findAll();
                    } else {
                        menuList = sysMenuService.listAllByUserId(entity.getUserId());
                    }

                    permsList = new ArrayList<>(menuList.size());
                    for (SysMenuBean menu : menuList) {
                        permsList.add(menu.getPerms());
                    }

                    for (String perms : permsList) {
                        if (StringUtils.isBlank(perms)) {
                            continue;
                        }
                        permsSet.addAll(Arrays.asList(perms.trim().split(",")));
                    }
                    redisUtil.sadd(key, permsSet.toArray(new String[permsSet.size()]));
                }
            } else {
                permsSet = redisUtil.smembers(key);
            }
            return permsSet;
        }
    }

    public SysUserBean findByName(String Username)
    {
        Example example = new Example(SysUserBean.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("username", Username);
        //criteria.andEqualTo("password", Password);

        SysUserBean model =queryOneByExample(example);

        if(null==model)
        {
            return  model;
        }
        return  model;
    }
}
