package com.project.name.exception;


import com.project.name.error.ErrorCode;
import lombok.Data;

@Data
public class LogicException extends RuntimeException {
    private ErrorCode errorCode;

    public LogicException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
