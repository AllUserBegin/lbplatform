package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 部门管理
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysDeptCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long deptId;


    
        //@NotBlank(message = "上级部门ID，一级部门为0不能为空")
        @ApiModelProperty(value = "上级部门ID，一级部门为0")//, required = true
        public Long parentId;


    
        //@NotBlank(message = "部门名称不能为空")
        @ApiModelProperty(value = "部门名称")//, required = true
        public String name;


    
        //@NotBlank(message = "排序不能为空")
        @ApiModelProperty(value = "排序")//, required = true
        public Integer orderNum;


    
        //@NotBlank(message = "是否删除  -1：已删除  0：正常不能为空")
        @ApiModelProperty(value = "是否删除  -1：已删除  0：正常")//, required = true
        public Integer delFlag;


    }
