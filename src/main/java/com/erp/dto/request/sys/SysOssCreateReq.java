package com.erp.dto.request.sys;

import java.util.Date;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * 文件上传
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysOssCreateReq {

    
        //@NotBlank(message = "不能为空")
        @ApiModelProperty(value = "")//, required = true
        public Long id;


    
        //@NotBlank(message = "URL地址不能为空")
        @ApiModelProperty(value = "URL地址")//, required = true
        public String url;


    
        //@NotBlank(message = "创建时间不能为空")
        @ApiModelProperty(value = "创建时间")//, required = true
        public Date createDate;


    }
