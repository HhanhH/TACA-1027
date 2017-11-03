package com.taca.common.exception;

import com.taca.common.constants.IMResp;

/**
 * Created by jetty on 17/9/22.
 */
public class DBException extends IMRunTimeException{

    public DBException(IMResp imResp){
        super(imResp);
    }
}
