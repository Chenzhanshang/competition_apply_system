package com.nnxy.competition.utils;

/**
 * 成功信息
 * @author  :CZS
 * @date    :2019/12/17 13:13
 * Email    :642125256@qq.com
 */
public enum SuccessEnum {

    /**
     * 成功信息
     */
    S_LOGIN_SUCCESS("1","登录成功"),
    S_LOGINED("1","用户已登录，无需重复登录");



    /**
     * 成功代码
     */
    private String successCode;
    /**
     * 成功信息
     */
    private String successMsg;

    SuccessEnum(String successCode, String successMsg) {
        this.successCode = successCode;
        this.successMsg = successMsg;
    }

    public String getSuccessCode() {
        return successCode;
    }

    public String getSuccessMsg() {
        return successMsg;
    }
}
