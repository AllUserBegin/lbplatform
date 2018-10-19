package com.erp.shiro;


import com.erp.entity.sys.SysUserBean;

import com.erp.service.sys.SysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;


import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



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

        String username = (String) principals.getPrimaryPrincipal();

        SysUserBean entity = sysUserService.findByName(username);
        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(entity.getUserId()),SecurityUtils.getSubject().getPrincipals());



        Session  session=  SecurityUtils.getSubject().getSession();
        if(null==session)
        {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        //authorizationInfo.setRoles(sysUserService.findRoles(username));
        authorizationInfo.setStringPermissions(sysUserService.findPermissions(username));

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

        String username=token.getUsername();

        SysUserBean entity = sysUserService.findByName(username);

        if (entity == null) {
            throw new UnknownAccountException();//没找到帐号
        }
        if (entity.getStatus() == 0) {
            throw new LockedAccountException(); //帐号锁定
        }
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("user", entity);

        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配，如果觉得人家的不好可以在此判断或自定义实现
        return new SimpleAuthenticationInfo(username, entity.getPassword(), getName());
    }


}


