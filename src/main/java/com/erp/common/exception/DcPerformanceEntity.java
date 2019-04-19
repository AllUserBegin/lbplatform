package com.erp.common.exception;




public class DcPerformanceEntity {



    private    String InterfaceName;

    public String getInterfaceName() {
        return InterfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        InterfaceName = interfaceName;
    }

    public String getRequestParam() {
        return RequestParam;
    }

    public void setRequestParam(String requestParam) {
        RequestParam = requestParam;
    }

    public String getConsumeTime() {
        return ConsumeTime;
    }

    public void setConsumeTime(String consumeTime) {
        ConsumeTime = consumeTime;
    }

    private   String RequestParam;

    private  String ConsumeTime;

}
