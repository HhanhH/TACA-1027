package com.taca.busservice;

import com.taca.common.exception.BusinessException;
import com.taca.common.bean.ResultBean;
import com.taca.common.constants.IMResp;
import com.taca.common.enumstatus.ShoppingStatus;
import com.taca.common.enumstatus.TransStatus;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.mapper.GoodsInfoMapper;
import com.taca.mapper.ShoppingMapper;
import com.taca.mapper.TransRecordMapper;
import com.taca.mapper.UserInfoMapper;
import com.taca.model.GoodsInfo;
import com.taca.model.Shopping;
import com.taca.model.TransRecord;
import com.taca.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by 芳华 on 2017/9/27.
 */
@Component("shoppingBusService")
public class ShoppingBusService {

    private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);

    @Autowired
    private GoodsInfoMapper goodsInfoMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private TransRecordMapper transRecordMapper;
    @Autowired
    private ShoppingMapper shoppingMapper;

    @Transactional
    public ResultBean exchangeGoods(Long id,String username){
        GoodsInfo goodsInfo=goodsInfoMapper.selectByPrimaryKey(id);
        if(goodsInfo!=null){
            //1.商品可用库存-1
            goodsInfo.setAvailableStock(goodsInfo.getAvailableStock()-1);
            goodsInfo.setCount(goodsInfo.getCount()+1);
            goodsInfo.setUpdateTime(new Date());
            goodsInfoMapper.updateByPrimaryKeySelective(goodsInfo);
            log.info("[{}]库存更新成功",goodsInfo.getId());
            //2.user_info  增加冻结星点 减少可用星点
            UserInfo userInfo=userInfoMapper.getUserInfoByUM(username);
            userInfo.setFreezeStar(userInfo.getFreezeStar()+goodsInfo.getStarNumber());
            userInfo.setAvailableStar(userInfo.getAvailableStar()-goodsInfo.getStarNumber());
            userInfo.setUpdateTime(new Date());
            userInfoMapper.updateByPrimaryKeySelective(userInfo);
            log.info("用户星点更新成功");
            //3.trans_info 插入一条记录
            TransRecord transRecord=new TransRecord();
            transRecord.setUsername(username);
            transRecord.setStarNumber(0L-goodsInfo.getStarNumber());
            transRecord.setStatus(TransStatus.PROCEEDING.toString());
            transRecord.setStartTime(new Date());
            transRecord.setCreateTime(new Date());
            transRecord.setUpdateTime(new Date());
            transRecordMapper.insert(transRecord);
            log.info("新增星点交易记录[{}]成功",transRecord.getId());
            //4.shopping 插入一条记录
            Shopping shopping=new Shopping();
            shopping.setUsername(username);
            shopping.setGoodsId(goodsInfo.getId());
            shopping.setName(goodsInfo.getName());
            shopping.setStarNumber(goodsInfo.getStarNumber());
            shopping.setStatus(ShoppingStatus.PROCEEDING.toString());
            shopping.setTransId(transRecord.getId());
            shopping.setContent(goodsInfo.getDescription());
            shopping.setStartTime(new Date());
            shopping.setCreateTime(new Date());
            shoppingMapper.insert(shopping);
            log.info("新增兑换记录成功");

            return new ResultBean(IMResp.SUCCESS);
        }
        else {
            throw new BusinessException(IMResp.FAIL);
        }
    }
}
