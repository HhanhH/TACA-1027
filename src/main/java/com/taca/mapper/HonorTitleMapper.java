package com.taca.mapper;


import com.taca.common.util.Page;
import com.taca.model.HonorTitle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HonorTitleMapper {

    int deleteByPrimaryKey(Long id);

    int insert(HonorTitle record);

    int insertSelective(HonorTitle record);

    HonorTitle selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HonorTitle record);

    HonorTitle getMinTitle();

    int updateByPrimaryKey(HonorTitle record);
    List<HonorTitle> getList();
    List<HonorTitle> queryHonorRanking();

    /**
     * 查询月排行榜
     * @return
     */
    List<HonorTitle> queryHonorMonth();

    /**
     * 查询季度排行榜
     * @return
     */
    List<HonorTitle> queryHonorMonths();

    Integer count();
    List<HonorTitle> queryListByPage(Page page);
    HonorTitle getByTitle(String title);
}