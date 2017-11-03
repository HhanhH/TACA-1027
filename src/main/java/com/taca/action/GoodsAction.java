package com.taca.action;

import com.github.pagehelper.cache.Cache;
import com.taca.busservice.ShoppingBusService;
import com.taca.common.bean.ResultBean;
import com.taca.common.constants.AdminConstants;
import com.taca.common.constants.Constants;
import com.taca.common.constants.IMResp;
import com.taca.common.exception.BusinessException;
import com.taca.common.exception.IMRunTimeException;
import com.taca.common.util.Page;
import com.taca.model.GoodsInfo;
import com.taca.model.UserInfo;
import com.taca.service.GoodsService;
import com.taca.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 芳华 on 2017/9/26.
 */
@Component("goodsAction")
public class GoodsAction {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private ShoppingBusService shoppingBusService;

    @Autowired
    private UserInfoService userInfoService;

    public List<GoodsInfo> getGoodsList(){
        return goodsService.getGoodsList();
    }

    public GoodsInfo getGoodsById(Long id){
        return goodsService.getGoodsById(id);
    }

    public ResultBean exchangeGoods(Long id, HttpSession httpSession){
        String username=(String)httpSession.getAttribute("username");
        //1.判断是否有库存并且可用
        GoodsInfo goodsInfo=goodsService.getGoodsById(id);
        UserInfo userInfo=userInfoService.getUserInfoByUM(username);
        if(goodsInfo.getAvailableStock()==null&&goodsInfo.getAvailableStock()<=0){
            throw new BusinessException(IMResp.Goods_LOW_STOCK);
        }
        if(userInfo.getAvailableStar()<goodsInfo.getStarNumber()){
            throw new BusinessException(IMResp.STAR_IS_LOWER);
        }
        //2.兑换
        return shoppingBusService.exchangeGoods(id,username);
    }
    
    
    public Integer addGoods(MultipartFile file,GoodsInfo goodsInfo) {
        if(StringUtils.isEmpty(file.getOriginalFilename())){
            goodsInfo.setIconAddress(null);
        }else{
            String fileName = file.getOriginalFilename();
            int index = fileName.lastIndexOf(".");
            String date=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
            fileName = date+"_goods"+fileName.substring(index);
            String path  = Constants.PIC_PATH+fileName;
            System.setProperty("sun.jnu.encoding","utf-8");
            File file2 = new File(path);
            try {
                file.transferTo(file2);
            } catch (IllegalStateException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            }catch (IOException e) {
            	throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
			}

            goodsInfo.setIconAddress(path);
        }
        Integer count=0;
        count = goodsService.add(goodsInfo);
        return count;

    }


    public Integer editGoods(MultipartFile file, GoodsInfo goodsInfo) {
        if(StringUtils.isEmpty(file.getOriginalFilename())){
            goodsInfo.setIconAddress(null);
        }else{
            String fileName = file.getOriginalFilename();
            String date=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
            int index = fileName.lastIndexOf(".");
            fileName = date+"_goods"+fileName.substring(index);
            String path  = Constants.PIC_PATH+fileName;
            System.setProperty("sun.jnu.encoding","utf-8");
            File file2 = new File(path);
            try {
                file.transferTo(file2);
            } catch (IllegalStateException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            } catch (IOException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            }

            goodsInfo.setIconAddress(path);
        }
        Integer count=0;
        count = goodsService.updateGoods(goodsInfo);
        return count;

    }

    public List<GoodsInfo> queryListByPage(Map<String,Object> map,GoodsInfo goodsInfo,Page page) {
        int count=goodsService.countByMap(map,goodsInfo);
        page.setTotalNumber(count);
        page.count();
        List<GoodsInfo> list=null;
        list= goodsService.queryListByPage(map,goodsInfo, page);
        return list;

    }

    public  List<String> getCategoryList(){
        return goodsService.getCategoryList();
    }


    public Integer changOffAndOn(Long id){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", id);
        Date date=new Date();
        map.put("updateTime", date);
        GoodsInfo goodsInfo = goodsService.getGoodsById(id);
        if(goodsInfo.getStatus().equalsIgnoreCase("ON")){
            map.put("status", AdminConstants.TASK_STATUS_OFF);
        }else{
            map.put("status", AdminConstants.TASK_STATUS_ON);
        }
        Integer flagInteger=0;
        flagInteger = goodsService.changOffAndOn(map);

        return flagInteger;
    }
}
