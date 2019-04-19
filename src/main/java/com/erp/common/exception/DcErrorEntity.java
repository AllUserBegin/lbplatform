package com.erp.common.exception;

public class DcErrorEntity {

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    private  Long Id;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private  String errorMessage;
}
