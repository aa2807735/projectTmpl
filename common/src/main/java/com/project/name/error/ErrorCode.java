package com.project.name.error;

public enum ErrorCode {


    /**
     * 请求成功
     */
    SUCCESS_CODE(1001,"请求成功"),

    /**
     * 请求失败
     */
    FAIL_CODE(1999,"请求失败")

    ;
    private Integer code;
    private String message;


    ErrorCode(Integer code,String message){
        this.code =code;
        this.message=message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
