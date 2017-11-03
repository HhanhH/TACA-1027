package com.taca.service.impl;

import com.taca.common.util.Page;
import com.taca.mapper.GoodsInfoMapper;
import com.taca.model.GoodsInfo;
import com.taca.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 芳华 on 2017/9/26.
 */
@Component("goodsService")
public class GoodsServiceImpl implements GoodsService{
    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Override
    public List<GoodsInfo> getGoodsList() {
        return goodsInfoMapper.getGoodsList();
    }

    @Override
    public GoodsInfo getGoodsById(Long id) {
        return goodsInfoMapper.selectByPrimaryKey(id);
    }
    @Override
    public List<GoodsInfo> queryListByPage(Map<String,Object> map ,GoodsInfo goodsInfo, Page page) {
        map.put("goodsInfo", goodsInfo);
        map.put("page", page);
        List<GoodsInfo> list=null;
        list=goodsInfoMapper.getListByPage(map);
        return list;
    }
    @Override
    public Integer countByMap(Map<String, Object> map,GoodsInfo goodsInfo) {
        map.put("goodsInfo", goodsInfo);
        return goodsInfoMapper.countByMap(map);
    }

    @Override
    public Integer getCount(GoodsInfo goodsInfo) {
        return goodsInfoMapper.count(goodsInfo);
    }

    @Override
    public Integer add(GoodsInfo goodsInfo) {
        Date date=new Date();
        goodsInfo.setCreateTime(date);
        goodsInfo.setUpdateTime(date);
        goodsInfo.setCount(0L);
        Integer count=0;
        count = goodsInfoMapper.insertSelective(goodsInfo);
        return count;
    }


    @Override
    public Integer changOffAndOn(Map map) {
        Integer flag=goodsInfoMapper.changOffAndOnById(map);
        return flag;
    }


    @Override
    public Integer updateGoods(GoodsInfo goodsInfo) {
        goodsInfo.setUpdateTime(new Date());
        System.out.println(goodsInfo);
        Integer integer=goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
        return integer;
    }
    @Override
    public List<String> getCategoryList() {
        return goodsInfoMapper.getCategoryList();
    }
}
