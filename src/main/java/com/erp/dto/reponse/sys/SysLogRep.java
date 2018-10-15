package com.erp.dto.reponse.sys;

import com.erp.dto.reponse.BaseRep;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 系统日志
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysLogRep extends  BaseRep {

            @ApiModelProperty(value = "")
        public Long id;
            @ApiModelProperty(value = "用户名")
        public String username;
            @ApiModelProperty(value = "用户操作")
        public String operation;
            @ApiModelProperty(value = "请求方法")
        public String method;
            @ApiModelProperty(value = "请求参数")
        public String params;
            @ApiModelProperty(value = "执行时长(毫秒)")
        public Long time;
            @ApiModelProperty(value = "IP地址")
        public String ip;
            @ApiModelProperty(value = "创建时间")
        public Date createDate;
    }
