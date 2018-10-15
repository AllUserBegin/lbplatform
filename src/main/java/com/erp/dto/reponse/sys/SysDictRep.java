package com.erp.dto.reponse.sys;

import com.erp.dto.reponse.BaseRep;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 数据字典表
 *
 * @author Lic
 * @email iqeq@iqeq.com
 * @date 2018-10-12 13:58:50
 */
@Data
public class SysDictRep extends  BaseRep {

            @ApiModelProperty(value = "")
        public Long id;
            @ApiModelProperty(value = "字典名称")
        public String name;
            @ApiModelProperty(value = "字典类型")
        public String type;
            @ApiModelProperty(value = "字典码")
        public String code;
            @ApiModelProperty(value = "字典值")
        public String value;
            @ApiModelProperty(value = "排序")
        public Integer orderNum;
            @ApiModelProperty(value = "备注")
        public String remark;
            @ApiModelProperty(value = "删除标记  -1：已删除  0：正常")
        public Integer delFlag;
    }
