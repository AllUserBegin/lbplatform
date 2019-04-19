package com.erp.common.exception;

public class DataCenterException extends RuntimeException {
    private static final long serialVersionUID = 1L;



    public DataCenterException(DcErrorEntity dcErrorEntity)
    {
        super("");
    }
}
