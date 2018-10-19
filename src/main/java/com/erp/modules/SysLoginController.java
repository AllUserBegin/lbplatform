package com.erp.modules;

import com.erp.common.utils.ApiResult;


import com.erp.config.shiro.TokenGenerator;
import com.erp.entity.sys.SysUserBean;
import com.erp.service.sys.SysUserService;
import com.google.code.kaptcha.Producer;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/SysLogin", produces = MediaType.APPLICATION_JSON_VALUE) //配置返回值 application/json
public class SysLoginController {
    @Autowired
    private Producer producer;

    @Autowired
    private SysUserService sysUserService;

/*    @RequestMapping("captcha.jpg")
    public void captcha(HttpServletResponse response)throws IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        //生成图片验证码
        BufferedImage image = producer.createImage(text);
        //保存到shiro session
        ShiroUtils.setSessionAttribute(Constants.KAPTCHA_SESSION_KEY, text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
    }*/

    /**
     * 登录
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ApiResult login(String username, String password, String captcha) {
      /*  String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
        if(!captcha.equalsIgnoreCase(kaptcha)){
            return ApiResult.Fail("验证码不正确");
        }*/
        String passwordmd5 = new Md5Hash(password, "2").toString();

        SysUserBean user = sysUserService.findByName(username);
        if(null==user)
        {
            return ApiResult.Fail("用户不存在");
        }

        if(user.getPassword().equalsIgnoreCase(passwordmd5)==false)
        {
            return ApiResult.Fail("密码不正确");
        }
       /* String strToken=  TokenGenerator.generateValue(username+passwordmd5);*/
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), passwordmd5);
        Subject currentUser = SecurityUtils.getSubject();
        try{
            currentUser.login(token);
            //String sid= currentUser.getSession().getId().toString();
             return  ApiResult.Success("登录成功",passwordmd5);
        }catch (UnknownAccountException e) {
            return ApiResult.Fail(e.getMessage());
        }catch (IncorrectCredentialsException e) {
            return ApiResult.Fail("账号或密码不正确");
        }catch (LockedAccountException e) {
            return ApiResult.Fail("账号已被锁定,请联系管理员");
        }catch (AuthenticationException e) {
                return ApiResult.Fail("账户验证失败");
        }
        catch (Exception ex)
        {
            return ApiResult.Fail(ex.getMessage());
        }

    }

    /**
     * 退出
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public ApiResult logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        /*
        * 从redis里面移除
        * */
        return ApiResult.Success();
    }
}
