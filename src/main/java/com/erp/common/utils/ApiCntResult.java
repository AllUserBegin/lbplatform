package com.erp.common.utils;

import com.alibaba.fastjson.JSON;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiCntResult extends ApiResult {
    public ApiCntResult() {
    }

    private long cnt;

    @Override
    public String toString()
    {
        return JSON.toJSONString(this);
    }
}
