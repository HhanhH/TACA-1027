package com.taca.service;

import com.taca.common.util.Page;
import com.taca.model.GoodsInfo;
import com.taca.model.Shopping;

import java.util.List;
import java.util.Map;

/**
 * Created by 芳华 on 2017/9/26.
 */
public interface GoodsService {

     List<GoodsInfo> getGoodsList();

     GoodsInfo getGoodsById(Long id);

    List<GoodsInfo> queryListByPage(Map<String,Object> map ,GoodsInfo goodsInfo,Page page);
    Integer getCount(GoodsInfo goodsInfo);
    Integer add(GoodsInfo goodsInfo);
    Integer changOffAndOn(Map map);
    Integer updateGoods(GoodsInfo goodsInfo);
    Integer countByMap(Map<String,Object> map ,GoodsInfo goodsInfo);
    List<String> getCategoryList();


}
