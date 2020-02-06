package com.nnxy.competition.utils;

/**
 * 错误信息
 * @author  :CZS
 * @date    :2019/12/17 13:14
 * Email    :642125256@qq.com
 */
public enum ErrorEnum {

    /**
     * 错误信息
     */
    E_UNKNOWN_ACCOUNT("-1","用户不存在"),
    E_PASSWORD_ERROR("-2","密码错误"),
    E_UNAUTHORIZED("-3","权限不足"),
    E_UNAUTHENTICATED("-4","用户未登录"),
    E_NOTADMIN("-5","用户不是管理员"),
    E_NOTSTUDENT("-6","用户不是学生"),
    E_NOTROLE("-7","无该角色");


    /**
     * 错误代码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    ErrorEnum(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

}
