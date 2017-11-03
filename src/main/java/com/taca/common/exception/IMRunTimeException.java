package com.taca.common.exception;

import com.taca.common.constants.IMResp;

/**
 * Created by jetty on 17/9/22.
 */
public class IMRunTimeException extends RuntimeException{

    private String code;
    private String message;


    public IMRunTimeException(IMResp resp){
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
