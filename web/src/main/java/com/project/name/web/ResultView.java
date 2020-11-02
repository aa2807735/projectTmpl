package com.project.name.web;


import com.project.name.error.ErrorCode;
import lombok.Data;

@Data
public class ResultView<T> {
    private Integer code;
    private String message;
    private T data;


    public ResultView(Integer code,String message,T data){
        this.code =code;
        this.message=message;
        this.data = data;
    }


    public ResultView(Integer code,String message){
        this.code =code;
        this.message=message;
    }

    public ResultView(ErrorCode errorCode,T data){
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.data = data;
    }




    public static <T> ResultView<T> ok(T data){
        return new ResultView<T>(ErrorCode.SUCCESS_CODE,data);
    }

    public static <T> ResultView<T> ok(ErrorCode errorCode){
        return new ResultView<T>(errorCode.getCode(),errorCode.getMessage());
    }


    public static <T> ResultView<T> fail(T data){
        return new ResultView<>(ErrorCode.FAIL_CODE,data);
    }


}
