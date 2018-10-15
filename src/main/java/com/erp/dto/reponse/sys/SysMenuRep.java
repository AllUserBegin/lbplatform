package com.erp.dto.reponse.sys;

import com.erp.dto.reponse.BaseRep;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 菜单管理
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysMenuRep extends  BaseRep {

            @ApiModelProperty(value = "")
        public Long menuId;
            @ApiModelProperty(value = "父菜单ID，一级菜单为0")
        public Long parentId;
            @ApiModelProperty(value = "菜单名称")
        public String name;
            @ApiModelProperty(value = "菜单URL")
        public String url;
            @ApiModelProperty(value = "授权(多个用逗号分隔，如：user:list,user:create)")
        public String perms;
            @ApiModelProperty(value = "类型   0：目录   1：菜单   2：按钮")
        public Integer type;
            @ApiModelProperty(value = "菜单图标")
        public String icon;
            @ApiModelProperty(value = "排序")
        public Integer orderNum;
    }
