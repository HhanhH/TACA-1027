package com.taca.service;

import com.taca.common.bean.ResultBean;
import com.taca.common.util.Page;
import com.taca.model.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by jetty on 17/9/20.
 */
public interface UserInfoService {

    UserInfo getUserInfoByUM(String UM);
    UserInfo getInactiveUserInfoByUM(String UM);
    ResultBean updateNickName(Long id, String nickName);
    UserInfo getUserByUMWithNoStatus(String UM);
    ResultBean updateUserInfo(UserInfo userInfo);
    ResultBean updateIcon(UserInfo userInfo);
    UserInfo getUserById(Long userId);
    UserInfo getByUserName(String userName);
    Integer getCount(UserInfo userInfo);
    List<UserInfo> queryUserArmory(Page page);
    Integer activeUser(Long id,String status);
    Integer userCount(UserInfo userInfo);
    Integer batchAdd(List<UserInfo> list);
    Integer addOne(UserInfo userInfo);
    List<String > groupList();
    List<String> getUserEmailList();
    Integer userCountByMap(Map<String, Object> map);
    List<UserInfo> getMonthList(String time1,String time2,Page page);
    Integer countForArmory(Map<String, Object> map);
    List<UserInfo> queryUserList(Map<String, Object> map);
    List<UserInfo> queryUserListForGroup(Map<String, Object> map);
    Integer updateUserBaseInfo(UserInfo userInfo);
    String getGroupNameByGroupId(Long groupId);
    Integer updatePwd(UserInfo userInfo);
    Long getGroupIdByGroupName(String groupName);
}
