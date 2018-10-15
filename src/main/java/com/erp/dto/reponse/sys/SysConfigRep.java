package com.erp.dto.reponse.sys;

import com.erp.dto.reponse.BaseRep;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 系统配置信息表
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysConfigRep extends  BaseRep {

            @ApiModelProperty(value = "")
        public Long id;
            @ApiModelProperty(value = "key")
        public String paramKey;
            @ApiModelProperty(value = "value")
        public String paramValue;
            @ApiModelProperty(value = "状态   0：隐藏   1：显示")
        public Integer status;
            @ApiModelProperty(value = "备注")
        public String remark;
    }
