package com.taca.service.impl;

import com.taca.common.bean.ResultBean;
import com.taca.common.constants.IMResp;
import com.taca.common.enumstatus.UserStatus;
import com.taca.common.util.Page;
import com.taca.mapper.UserInfoMapper;
import com.taca.model.UserInfo;
import com.taca.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jetty on 17/9/20.
 */

@Component("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoByUM(String UM) {
        return userInfoMapper.getUserInfoByUM(UM);
    }
    @Override
    public UserInfo getUserByUMWithNoStatus(String UM) {
        return userInfoMapper.getUserByUMWithNoStatus(UM);
    }
    @Override
    public UserInfo getInactiveUserInfoByUM(String UM) {
        return userInfoMapper.getInactiveUserInfoByUM(UM);
    }

    @Override
    public ResultBean updateNickName(Long id, String nickName) {
        UserInfo userInfo=new UserInfo();
        userInfo.setId(id);
        userInfo.setNickName(nickName);
        userInfo.setUpdateTime(new Date());
        userInfoMapper.updateByPrimaryKeySelective(userInfo);
        return new ResultBean();
    }

    @Override
    public ResultBean updateUserInfo(UserInfo userInfo) {
        userInfo.setAvailableStar(0L);
        userInfo.setStatus(UserStatus.ACTIVE.toString());
        userInfo.setEmailAddress(userInfo.getUserName()+"@pingan.com.cn");
        userInfo.setFreezeStar(0L);
        userInfo.setHistoryStar(0L);
        userInfo.setCreateTime(new Date());
        userInfo.setUpdateTime(new Date());
        userInfoMapper.updateByUMSelective(userInfo);
        return new ResultBean(IMResp.SUCCESS);
    }
    
    

    @Override
    public ResultBean updateIcon(UserInfo userInfo) {
        userInfoMapper.updateIconAddress(userInfo);
        return new ResultBean(IMResp.SUCCESS);
    }

    @Override
    public UserInfo getUserById(Long userId) {

        return userInfoMapper.selectByPrimaryKey(userId);
    }
    @Override
    public Integer getCount(UserInfo userInfo) {
        return userInfoMapper.count(userInfo);
    }

    @Override
    public Integer activeUser(Long id,String status) {

        Map<String , Object> map = new HashMap<>();
        map.put("id", id);
        map.put("status", status);
        return userInfoMapper.active(map);
    }
    @Override
    public UserInfo getByUserName(String userName) {
        return userInfoMapper.selectByUserName(userName);
    }
    @Override
    public List<UserInfo> queryUserArmory(Page page) {
        Map<String ,Object> map=new HashMap<String, Object>();
        map.put("page", page);
        return userInfoMapper.queryUserArmory(map);
    }
    @Override
    public Integer userCount(UserInfo userInfo) {
        return userInfoMapper.userCount(userInfo);
    }
    @Override
    public Integer batchAdd(List<UserInfo> list) {
        return userInfoMapper.batchAdd(list);
    }
    @Override
    public Integer addOne(UserInfo userInfo) {
        userInfo.setUserName(userInfo.getUm());
        return userInfoMapper.insertSelective(userInfo);
    }
    @Override
    public List<String > groupList(){
        return userInfoMapper.groupList();
    }

    @Override
    public List<String> getUserEmailList() {
        return userInfoMapper.getUserEmailList();
    }

    @Override
    public List<UserInfo> queryUserList(Map<String, Object> map) {
        return userInfoMapper.queryUserList(map);
    }
    @Override
    public List<UserInfo> queryUserListForGroup(Map<String, Object> map) {
        return userInfoMapper.queryUserListForGroup(map);
    }

    @Override
    public Integer countForArmory(Map<String, Object> map) {
        return userInfoMapper.countForArmory(map);
    }
    @Override
    public List<UserInfo> getMonthList(String  time1, String  time2, Page page) {
        Map<String , Object> map = new HashMap<>();
        map.put("time1",time1);
        map.put("time2",time2);
        map.put("page",page);
        return userInfoMapper.getMonthList(map);
    }

    @Override
    public Integer userCountByMap(Map<String, Object> map) {
        return userInfoMapper.userCountByMap(map);
    }
    
	@Override
	public String getGroupNameByGroupId(Long groupId) {
		return userInfoMapper.getGroupNameByGroupId(groupId);
	}
	@Override
	public Integer updateUserBaseInfo(UserInfo userInfo) {
		return userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}
	@Override
	public Long getGroupIdByGroupName(String groupName) {
		return userInfoMapper.getGroupIdByGroupName(groupName);
	}
	@Override
	public Integer updatePwd(UserInfo userInfo) {
		return userInfoMapper.updatePwd(userInfo);
	}
}
