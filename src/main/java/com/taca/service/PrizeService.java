package com.taca.service;

import com.taca.model.Shopping;
import com.taca.model.TransRecord;

import java.util.List;

/**
 * Created by asus on 2017/9/25.
 */
public interface PrizeService {

    List<Shopping> selectShoppingByName(String userName);
}
