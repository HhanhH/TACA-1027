package com.taca.mapper;


import com.taca.model.Shopping;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ShoppingMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Shopping record);

    int insertSelective(Shopping record);

    Shopping selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Shopping record);

    int updateByPrimaryKeyWithBLOBs(Shopping record);

    int updateByPrimaryKey(Shopping record);

    /**
     * 根据用户名字查询用户的兑换交易记录
     */
    List<Shopping> selectShopByName(String userName);

    Integer count(Shopping shopping);

    List<Shopping> getListByPage(Map map);

    List<Shopping> getHisListByPage(Map map);

    Long getTransId(Long id);

    Integer updateForAudit(Shopping shopping);

    Integer countHis(Map<String,Object> map);

    Integer countForAudit(Map<String, Object> map);
    String getUMById(Long id);
}