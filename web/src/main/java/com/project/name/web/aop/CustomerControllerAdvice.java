package com.project.name.web.aop;


import com.project.name.error.ErrorCode;
import com.project.name.exception.LogicException;
import com.project.name.web.ResultView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
@Slf4j
public class CustomerControllerAdvice {

    /**
     * 逻辑异常
     *
     * @param e 异常参数
     * @return 结果视图
     */
    @ExceptionHandler({LoginException.class})
    public ResultView<String> catchMyException(LogicException e) {
        log.info(e.getMessage());
        return ResultView.ok(e.getErrorCode());
    }

    /**
     * 服务器异常
     *
     * @return 结果视图
     */
    @ExceptionHandler({Exception.class})
    public ResultView<String> catchMyException(Exception e, HttpServletRequest request) {
        log.info("服务器处理异常，请求URL为  {}  ,server exception:",request.getRequestURI(),e);
        return ResultView.ok(ErrorCode.SERVER_BUSY_CODE);
    }
}
