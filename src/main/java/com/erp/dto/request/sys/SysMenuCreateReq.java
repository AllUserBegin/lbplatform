package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 菜单管理
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysMenuCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long menuId;


    
        //@NotBlank(message = "父菜单ID，一级菜单为0不能为空")
        @ApiModelProperty(value = "父菜单ID，一级菜单为0")//, required = true
        public Long parentId;


    
        //@NotBlank(message = "菜单名称不能为空")
        @ApiModelProperty(value = "菜单名称")//, required = true
        public String name;


    
        //@NotBlank(message = "菜单URL不能为空")
        @ApiModelProperty(value = "菜单URL")//, required = true
        public String url;


    
        //@NotBlank(message = "授权(多个用逗号分隔，如：user:list,user:create)不能为空")
        @ApiModelProperty(value = "授权(多个用逗号分隔，如：user:list,user:create)")//, required = true
        public String perms;


    
        //@NotBlank(message = "类型   0：目录   1：菜单   2：按钮不能为空")
        @ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮")//, required = true
        public Integer type;


    
        //@NotBlank(message = "菜单图标不能为空")
        @ApiModelProperty(value = "菜单图标")//, required = true
        public String icon;


    
        //@NotBlank(message = "排序不能为空")
        @ApiModelProperty(value = "排序")//, required = true
        public Integer orderNum;


    }
