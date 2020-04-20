package com.nnxy.competition.config.exception;

import com.nnxy.competition.utils.ErrorEnum;
import com.nnxy.competition.utils.ResponseMessage;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理类
 *
 * @author :CZS
 * @date :2019/12/17 13:31
 * Email    :642125256@qq.com
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {


    /**
     * 权限不足返回信息
     *
     * @return
     */
    @ExceptionHandler(UnauthorizedException.class)
    public ResponseMessage unauthorizedExceptionHandler() {
        return new ResponseMessage(ErrorEnum.E_UNAUTHORIZED);
    }

    /**
     * 未登录报错拦截
     * 在请求需要权限的接口,而连登录都还没登录的时候,会报此错
     */
    @ExceptionHandler(UnauthenticatedException.class)
    public ResponseMessage unauthenticatedException() {
        return new ResponseMessage(ErrorEnum.E_UNAUTHENTICATED);
    }

}
