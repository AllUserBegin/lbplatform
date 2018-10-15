package com.erp.dto.reponse.sys;

import com.erp.dto.reponse.BaseRep;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 角色与菜单对应关系
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysRoleMenuRep extends  BaseRep {

            @ApiModelProperty(value = "")
        public Long id;
            @ApiModelProperty(value = "角色ID")
        public Long roleId;
            @ApiModelProperty(value = "菜单ID")
        public Long menuId;
    }
