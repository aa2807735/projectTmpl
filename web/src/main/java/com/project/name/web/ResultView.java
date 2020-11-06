package com.project.name.web;


import com.project.name.error.ErrorCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "API请求通用结果类")
public class ResultView<T> {

    @ApiModelProperty(value = "状态码")
    private Integer code;
    @ApiModelProperty(value = "消息")
    private String message;
    @ApiModelProperty(value = "数据结果")
    private T data;


    public ResultView(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public ResultView(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultView(ErrorCode errorCode, T data) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
        this.data = data;
    }


    public static <T> ResultView<T> ok(T data) {
        return new ResultView<T>(ErrorCode.SUCCESS_CODE, data);
    }

    public static <T> ResultView<T> ok(ErrorCode errorCode) {
        return new ResultView<T>(errorCode.getCode(), errorCode.getMessage());
    }
    public static ResultView<String> ok(){
        return new ResultView<String>(ErrorCode.SUCCESS_CODE.getCode(),ErrorCode.SUCCESS_CODE.getMessage());
    }


    public static <T> ResultView<T> fail(T data) {
        return new ResultView<>(ErrorCode.FAIL_CODE, data);
    }


}
