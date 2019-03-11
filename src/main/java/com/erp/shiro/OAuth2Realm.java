package com.erp.shiro;


import com.erp.entity.SysUserBean;

import com.erp.service.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;


import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;


/**
 * 认证
 *
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {
    @Autowired
    private SysUserService sysUserService;

/*    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }*/
    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        Long userId = (Long) principals.getPrimaryPrincipal();

        //SysUserBean entity = sysUserService.findById(userId);
        //把principals放session中 key=userId value=principals
        //SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(entity.getUserId()),SecurityUtils.getSubject().getPrincipals());



        Session  session=  SecurityUtils.getSubject().getSession();
        if(null==session)
        {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> list=sysUserService.findPermissions(userId,true);

        //authorizationInfo.setRoles(sysUserService.findRoles(username));
        authorizationInfo.setStringPermissions(list);

        return authorizationInfo;
    }
    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;

      /*  String strToken =  (String) authenticationToken.getPrincipal();
        if (strToken == null) {
            throw new AccountException("Token不能为空");
        }*/

        //strToken，去redis查询用户信息
     /*   SysUserTokenEntity tokenEntity = shiroService.queryByToken(accessToken);
        //token失效
        if(tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()){
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }*/
        String userId=token.getUsername();
        SysUserBean entity = sysUserService.findById(Long.parseLong(userId));
        //账号不存在
        if(entity == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }

        //账号锁定
        if(entity.getStatus() == 0){
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        Session session = SecurityUtils.getSubject().getSession();

       /* if(redisUtil.exists(RedisKeys.getUserLoginInfo(session.getId().toString()))==false)
        {
            throw new LockedAccountException("登录超时，请重新登录!");
        }*/

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
        return new SimpleAuthenticationInfo(entity.getUserId(), entity.getPassword(), getName());
    }
}


