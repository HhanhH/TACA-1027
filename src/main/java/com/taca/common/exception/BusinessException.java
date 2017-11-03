package com.taca.common.exception;

import com.taca.common.constants.IMResp;

/**
 * Created by jetty on 17/9/22.
 */
public class BusinessException extends IMRunTimeException{

    public BusinessException(IMResp imResp){
        super(imResp);
    }
}
