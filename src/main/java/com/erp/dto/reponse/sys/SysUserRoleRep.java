package com.erp.dto.reponse.sys;

import com.erp.dto.reponse.BaseRep;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 用户与角色对应关系
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysUserRoleRep extends  BaseRep {

            @ApiModelProperty(value = "")
        public Long id;
            @ApiModelProperty(value = "用户ID")
        public Long userId;
            @ApiModelProperty(value = "角色ID")
        public Long roleId;
    }
