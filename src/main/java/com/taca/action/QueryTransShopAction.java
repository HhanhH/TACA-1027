package com.taca.action;

import com.taca.common.constants.IMResp;
import com.taca.common.exception.IMRunTimeException;
import com.taca.model.Shopping;
import com.taca.service.PrizeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/9/25.
 */
@Component("queryTransShopAction")
public class QueryTransShopAction {


    @Autowired
    private PrizeService prizeService;

    public List<Shopping> selectShoppingByName(String userName){
        List<Shopping> transRecordList =new ArrayList<>();
   try{
     transRecordList = prizeService.selectShoppingByName(userName);
   }catch (Exception e){
      throw new IMRunTimeException(IMResp.DBEXCEPTION);
   }
        return  transRecordList;
    }
}
