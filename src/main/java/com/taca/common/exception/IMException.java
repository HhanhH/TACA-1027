package com.taca.common.exception;

import com.taca.common.constants.IMResp;

/**
 * Created by jetty on 17/9/22.
 */
public class IMException extends Exception {
    private String code;
    private String message;


    public IMException(IMResp resp){
        code=resp.getCode();
        message=resp.getMessage();
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
