package com.nnxy.competition.utils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CZS
 * CreateTime 2019/12/12 13:09
 * Email 642125256@qq.com
 */
public class ResponseMessage implements Serializable {

    private String status;
    private String msg;
    private Map<String, Object> data = new HashMap<String, Object>();


    public ResponseMessage() {
    }

    public ResponseMessage(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ResponseMessage(SuccessEnum successEnum) {
        this.status = successEnum.getSuccessCode();
        this.msg = successEnum.getSuccessMsg();
    }

    public ResponseMessage(ErrorEnum errorEnum) {
        this.status = errorEnum.getErrorCode();
        this.msg = errorEnum.getErrorMsg();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
