package com.erp.dto.reponse.sys;

import com.erp.dto.reponse.BaseRep;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 角色
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysRoleRep extends  BaseRep {

            @ApiModelProperty(value = "")
        public Long roleId;
            @ApiModelProperty(value = "角色名称")
        public String roleName;
            @ApiModelProperty(value = "备注")
        public String remark;
            @ApiModelProperty(value = "部门ID")
        public Long deptId;
            @ApiModelProperty(value = "创建时间")
        public Date createTime;
    }
