package com.project.name.web.aop;


import com.project.name.error.ErrorCode;
import com.project.name.exception.LogicException;
import com.project.name.web.ResultView;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.login.LoginException;

@ControllerAdvice
@ResponseBody
public class CustomerControllerAdvice {

    /**
     * 逻辑异常
     *
     * @param e 异常参数
     * @return 结果视图
     */
    @ExceptionHandler(LoginException.class)
    public ResultView<String> catchMyException(LogicException e) {
        return ResultView.ok(e.getErrorCode());
    }

    /**
     * 服务器异常
     *
     * @return 结果视图
     */
    @ExceptionHandler(Exception.class)
    public ResultView<String> catchMyException() {
        return ResultView.ok(ErrorCode.SERVER_BUSY_CODE);
    }
}
