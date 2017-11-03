package com.taca.action;

import com.taca.common.bean.ResultBean;
import com.taca.common.constants.Constants;
import com.taca.common.constants.IMResp;
import com.taca.common.enumstatus.UserStatus;
import com.taca.common.exception.BusinessException;
import com.taca.common.exception.IMRunTimeException;
import com.taca.common.util.ExcelUtil;
import com.taca.common.util.MD5Util;
import com.taca.common.util.Page;
import com.taca.controller.mobile.LoginMobileController;
import com.taca.model.HonorTitle;
import com.taca.model.ReceiveTask;
import com.taca.model.UserInfo;
import com.taca.service.HonorTitleService;
import com.taca.service.ReceiveTaskService;
import com.taca.service.UserInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by 芳华 on 2017/9/27.
 */
@Component("userInfoAction")
public class UserInfoAction {

    private static final Logger log = LoggerFactory.getLogger(LoginMobileController.class);
    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private ReceiveTaskService reciveTaskService;
    
    @Autowired
    private HonorTitleService honorTitleService;

    public UserInfo getUserInfoByUM(String UM){
        return userInfoService.getUserInfoByUM(UM);
    }

    public ResultBean updateNickName(Long id,String nickName){
        if(nickName==null||nickName.equals("")){
            throw new BusinessException(IMResp.FIELD_IS_NULL);
        }
        return userInfoService.updateNickName(id,nickName);
    }
    public ResultBean updateIcon(MultipartFile file, HttpSession httpSession){
        UserInfo userInfo=new UserInfo();
        String username=httpSession.getAttribute("username").toString();
        if(username==null&&username.equals("")){
           throw new BusinessException(IMResp.UNLOGIN);
        }
        userInfo.setUserName(username);
        if(file.getOriginalFilename().equals("")){
            userInfo.setIconAddress(null);
        }else{
            String fileName = file.getOriginalFilename();
            log.info(fileName);
            String date=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
            int index = fileName.lastIndexOf(".");
			fileName = "user_"+date+fileName.substring(index);
            String path  = Constants.PIC_PATH+fileName;
            File file2 = new File(path);
            try {
                file.transferTo(file2);
            } catch (IllegalStateException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            } catch (IOException e) {
                throw new IMRunTimeException(IMResp.FILE_SAVE_ERROR);
            }
            userInfo.setIconAddress(path);
        }
        return userInfoService.updateIcon(userInfo);
    }
    public List<UserInfo> getListByPage(Map<String,Object> map,UserInfo userInfo, Page page) {
        map.put("userInfo",userInfo);
        int count=userInfoService.userCountByMap(map);
        page.setTotalNumber(count);
        page.count();
        List<UserInfo> list=null;
        map.put("page", page);
        list= userInfoService.queryUserList(map);
        return list;

    }
    public List<UserInfo> getGroupUserListByPage(Map<String, Object> map , UserInfo userInfo, Page page) {
        map.put("userInfo",userInfo);
        int count=userInfoService.getCount(userInfo);
        page.setTotalNumber(count);
        page.count();
        List<UserInfo> list=null;

        map.put("page", page);
        list= userInfoService.queryUserListForGroup(map);
        return list;

    }

    public Integer userCount() {
        return userInfoService.userCount(new UserInfo());
    }
    public List<UserInfo> getMonthArmoryListByPage(String  time1,String time2,Page page) {
        Map<String, Object> map = new HashMap<>();
        map.put("time1", time1);
        map.put("time2", time2);
        int count=userInfoService.countForArmory(map);
        page.setTotalNumber(count);
        page.count();
        List<UserInfo> list=null;
        list= userInfoService.getMonthList(time1,time2, page);
        return list;

    }
    public UserInfo getUserById(Long id) {
        return userInfoService.getUserById(id);
    }

    public Integer activeUser(Long id){
        UserInfo userInfo = null;
        userInfo = userInfoService.getUserById(id);
        String status = null;
        if(UserStatus.ACTIVE.name().equals(userInfo.getStatus())){
            status = UserStatus.INACTIVE.name();
        }else{
            status = UserStatus.ACTIVE.name();
        }
        return userInfoService.activeUser(id, status);
    }

    public void  download(HttpServletResponse response) {
        String filePath = "static/fileDownload/user导入模板.xlsx";
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
            byte[] b = new byte[100];
            int len;
            OutputStream outputStream = response.getOutputStream();
            String fileName = "userImportTemplate.xlsx".toString();
            response.addHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
            response.setCharacterEncoding("GBK");
            //response.setContentType("application/vnd.xlsx;charset=utf-8");
            response.setContentType("bin");
            while ((len = inputStream.read(b)) > 0)
                outputStream.write(b, 0, len);
            inputStream.close();


            outputStream.flush();
            outputStream.close();
        } catch (UnsupportedEncodingException e) {
            throw new IMRunTimeException(IMResp.FAIL);
        } catch (IOException e) {
            throw new IMRunTimeException(IMResp.FAIL);
        }
    }



    public ResultBean importFile(MultipartFile file) {
    	if(file.isEmpty()){
    		throw new IMRunTimeException(IMResp.FILE_NO);
    	}
        String fileName = file.getOriginalFilename();
        if(!fileName.contains(".xlsx")||!fileName.contains(".xls")){
            throw new IMRunTimeException(IMResp.FILE_ERROR);
        }
        String date=new SimpleDateFormat("yyyyMMddHHmmss").format(Calendar.getInstance().getTime());
        fileName = date+"_"+fileName;
        String path  = Constants.PIC_PATH+fileName;
        File file2 = new File(path);
        try {
            file.transferTo(file2);
        } catch (IllegalStateException e) {
           throw new IMRunTimeException(IMResp.FILE_READ_ERROR);
        } catch (IOException e) {
        	 throw new IMRunTimeException(IMResp.FILE_READ_ERROR);
        }

        List<UserInfo> userInfos = ExcelUtil.readExcle(file2);
        UserInfo uInfo =null;
       for(UserInfo userInfo : userInfos){
    	   uInfo = userInfoService.getUserByUMWithNoStatus(userInfo.getUm());
    	   if(uInfo!=null){
    		   continue;
    	   }
    	   String groupName = userInfoService.getGroupNameByGroupId(userInfo.getGroupId());
    	     
           if(groupName!=null&&!groupName.equals(userInfo.getGroupName())){
           	throw new IMRunTimeException(IMResp.GROUPID_GROUPNAME_ERROR);
           }
           Long groupId = userInfoService.getGroupIdByGroupName(userInfo.getGroupName());
           if(groupId!=null&&!groupId.equals(userInfo.getGroupId())){
            	throw new IMRunTimeException(IMResp.GROUPID_GROUPNAME_ERROR);
            }
           userInfo.setStatus("ACTIVE");
     	   userInfo.setPassword(MD5Util.MD5("111111"));
     	   userInfo.setEmailAddress(userInfo.getUm()+"@pingan.com.cn");
     	   userInfo.setUserName(userInfo.getUm());
     	   userInfo.setCreateTime(new Date());
     	   userInfo.setUpdateTime(new Date());
     	   userInfo.setAvailableStar(0L);
     	   userInfo.setHistoryStar(0L);
     	   userInfo.setFreezeStar(0L);
     	   HonorTitle honorTitle=honorTitleService.getMinTitle();
           userInfo.setHonorTitle(honorTitle.getTitle());
    	   userInfoService.addOne(userInfo);
       }
       
        return new ResultBean<>();
    }
    public List<UserInfo> getArmoryListByPage(Page page) {
        Map<String, Object> map = new HashMap<String, Object>();
        int count=userInfoService.countForArmory(map);
        page.setTotalNumber(count);
        page.count();
        List<UserInfo> list=null;
        list= userInfoService.queryUserArmory(page);
        return list;

    }
 public ResultBean addOne(UserInfo userInfo){
    	
        UserInfo user = userInfoService.getUserByUMWithNoStatus(userInfo.getUm());
        if(user!=null){
        	throw new IMRunTimeException(IMResp.DATA_EXISTS);
        }
        String groupName = userInfoService.getGroupNameByGroupId(userInfo.getGroupId());
        
        if(groupName!=null&&!groupName.equals(userInfo.getGroupName())){
        	throw new IMRunTimeException(IMResp.GROUPID_GROUPNAME_ERROR);
        }
        Long groupId = userInfoService.getGroupIdByGroupName(userInfo.getGroupName());
        if(groupId!=null&&!groupId.equals(userInfo.getGroupId())){
         	throw new IMRunTimeException(IMResp.GROUPID_GROUPNAME_ERROR);
         }
       userInfo.setStatus("ACTIVE");
 	   userInfo.setPassword(MD5Util.MD5("111111"));
 	   userInfo.setEmailAddress(userInfo.getUm()+"@pingan.com.cn");
 	   userInfo.setUserName(userInfo.getUm());
 	   userInfo.setCreateTime(new Date());
 	   userInfo.setUpdateTime(new Date());
 	   userInfo.setAvailableStar(0L);
 	   userInfo.setHistoryStar(0L);
 	   userInfo.setFreezeStar(0L);
 	   HonorTitle honorTitle=honorTitleService.getMinTitle();
       userInfo.setHonorTitle(honorTitle.getTitle());
       userInfoService.addOne(userInfo);
       return new ResultBean<>();
    }
    public List<String> getGroupNameList() {
		return userInfoService.groupList();
	}

    public ResultBean update(UserInfo userInfo) {
    	
    	 String groupName = userInfoService.getGroupNameByGroupId(userInfo.getGroupId());
         if(groupName!=null&&!groupName.equals(userInfo.getGroupName())){
         	throw new IMRunTimeException(IMResp.GROUPID_GROUPNAME_ERROR);
         }
         Long groupId = userInfoService.getGroupIdByGroupName(userInfo.getGroupName());
         if(groupId!=null&&!groupId.equals(userInfo.getGroupId())){
          	throw new IMRunTimeException(IMResp.GROUPID_GROUPNAME_ERROR);
          }
    	userInfoService.updateUserBaseInfo(userInfo);
    	
    	return new ResultBean<>();
		
	}
    
    public ResultBean changPwd(String pwd,String pwdnew,String userName) {
    	UserInfo userInfo = userInfoService.getByUserName(userName);
    	if(userInfo ==null){
    		throw new BusinessException(IMResp.DBEXCEPTION);
    	}
    	
    	if(!MD5Util.MD5(pwd).equals(userInfo.getPassword())){
    		throw new BusinessException(IMResp.OLD_PWD_ERROR);
    	}
    	userInfo.setPassword(MD5Util.MD5(pwdnew));
    	userInfoService.updatePwd(userInfo);
    	return new ResultBean<>("修改成功");
		
	}
}
