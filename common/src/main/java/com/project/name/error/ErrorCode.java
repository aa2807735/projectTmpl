package com.project.name.error;

public enum ErrorCode {


    /**
     * 请求成功
     */
    SUCCESS_CODE(1001,"请求成功"),

    /**
     * 请求失败
     */
    FAIL_CODE(1900,"请求失败"),

    /**
     * Bean拷贝失败
     */
    BEAN_COPY_CODE(1101,"Bean拷贝错误"),
    /**
     * 服务器异常，服务器繁忙
     */
    SERVER_BUSY_CODE(1999,"服务器繁忙，请稍后再试"),
    /**
     * 账号密码输入有误，请重新输入
     */
    LOGIN_INFO_ERROR(1899,"账号密码输入有误，请重新输入")
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
