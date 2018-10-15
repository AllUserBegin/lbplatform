package com.erp.dto.reponse.sys;

import com.erp.dto.reponse.BaseRep;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 系统用户
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysUserRep extends  BaseRep {

            @ApiModelProperty(value = "")
        public Long userId;
            @ApiModelProperty(value = "用户名")
        public String username;
            @ApiModelProperty(value = "密码")
        public String password;
            @ApiModelProperty(value = "盐")
        public String salt;
            @ApiModelProperty(value = "邮箱")
        public String email;
            @ApiModelProperty(value = "手机号")
        public String mobile;
            @ApiModelProperty(value = "状态  0：禁用   1：正常")
        public Integer status;
            @ApiModelProperty(value = "部门ID")
        public Long deptId;
            @ApiModelProperty(value = "创建时间")
        public Date createTime;
    }
