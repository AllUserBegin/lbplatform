package com.erp.dto.reponse;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Getter;

@Data
public class BaseRep {
    @ApiModelProperty(name = "createrUid", value = "创建人Uid")
    private int createrUid;

    @ApiModelProperty(name = "creater", value = "创建者名称")
    private String creater;

    @ApiModelProperty(name = "createTime", value = "创建时间")
    private java.util.Date createTime;

    @ApiModelProperty(name = "modifierUid", value = "修改人Uid")
    private int modifierUid;

    @ApiModelProperty(name = "modifier", value = "修改者名称")
    private String modifier;

    @Getter
    @ApiModelProperty(name = "modifyTime", value = "修改时间")
    private java.util.Date modifyTime;
}
