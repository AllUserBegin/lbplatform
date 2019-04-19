package com.erp.common.exception;


public class ProjectException extends RuntimeException  {

    private static final long serialVersionUID = 1L;

    public  DcErrorEntity  getDcErrorEntity()
    {
        return new DcErrorEntity();
    }
}
