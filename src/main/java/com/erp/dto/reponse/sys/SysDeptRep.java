package com.erp.dto.reponse.sys;

import com.erp.dto.reponse.BaseRep;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 部门管理
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysDeptRep extends  BaseRep {

            @ApiModelProperty(value = "")
        public Long deptId;
            @ApiModelProperty(value = "上级部门ID，一级部门为0")
        public Long parentId;
            @ApiModelProperty(value = "部门名称")
        public String name;
            @ApiModelProperty(value = "排序")
        public Integer orderNum;
            @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")
        public Integer delFlag;
    }
