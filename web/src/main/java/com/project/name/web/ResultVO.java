package com.project.name.web;


import com.project.name.error.ErrorCode;
import lombok.Data;

@Data
public class ResultVO<T> {
    private Integer code;
    private String message;
    private T data;


    public ResultVO(Integer code,String message,T data){
        this.code =code;
        this.message=message;
        this.data = data;
    }

    public ResultVO(ErrorCode errorCode,T data){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.data = data;
    }


    public static <T> ResultVO<T> ok(T data){
        return new ResultVO<T>(ErrorCode.SUCCESS_CODE,data);
    }

    public static <T> ResultVO<T> fail(T data){
        return new ResultVO<>(ErrorCode.FAIL_CODE,data);
    }


}
