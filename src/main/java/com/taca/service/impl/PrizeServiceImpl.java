package com.taca.service.impl;

import com.taca.mapper.ShoppingMapper;
import com.taca.model.Shopping;
import com.taca.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by asus on 2017/9/25.
 */
@Service("prizeService")
public class PrizeServiceImpl implements PrizeService {

    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public List<Shopping> selectShoppingByName(String userName) {
        return shoppingMapper.selectShopByName(userName);
    }
}
