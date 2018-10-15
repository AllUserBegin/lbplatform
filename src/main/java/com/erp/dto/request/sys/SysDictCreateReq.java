package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 数据字典表
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysDictCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long id;


    
        //@NotBlank(message = "字典名称不能为空")
        @ApiModelProperty(value = "字典名称")//, required = true
        public String name;


    
        //@NotBlank(message = "字典类型不能为空")
        @ApiModelProperty(value = "字典类型")//, required = true
        public String type;


    
        //@NotBlank(message = "字典码不能为空")
        @ApiModelProperty(value = "字典码")//, required = true
        public String code;


    
        //@NotBlank(message = "字典值不能为空")
        @ApiModelProperty(value = "字典值")//, required = true
        public String value;


    
        //@NotBlank(message = "排序不能为空")
        @ApiModelProperty(value = "排序")//, required = true
        public Integer orderNum;


    
        //@NotBlank(message = "备注不能为空")
        @ApiModelProperty(value = "备注")//, required = true
        public String remark;


    
        //@NotBlank(message = "删除标记  -1：已删除  0：正常不能为空")
        @ApiModelProperty(value = "删除标记  -1：已删除  0：正常")//, required = true
        public Integer delFlag;


    }
