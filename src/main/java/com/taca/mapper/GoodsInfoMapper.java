package com.taca.mapper;


import com.taca.model.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodsInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insert(GoodsInfo record);

    int insertSelective(GoodsInfo record);

    GoodsInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GoodsInfo record);

    int updateByPrimaryKeyWithBLOBs(GoodsInfo record);

    int updateByPrimaryKey(GoodsInfo record);

    List<GoodsInfo> getGoodsList();

    Integer countByMap(Map<String,Object> map );

    Integer count(GoodsInfo goodsInfo);

    List<GoodsInfo> getListByPage(Map map);

    Integer changOffAndOnById(Map<String, Object> map);

    List<String> getCategoryList();
}