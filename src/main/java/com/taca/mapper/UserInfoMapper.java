package com.taca.mapper;


import com.taca.model.UserInfo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserInfoMapper {

    int deleteByPrimaryKey(Long id);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    UserInfo getInactiveUserInfoByUM(String UM);

    UserInfo getUserByUMWithNoStatus(String UM);

    Integer userCountByMap(Map map);

    List<String > groupList();

    List<String> getUserEmailList();

    UserInfo getUserInfoByUM(String UM);
    /**
     * 查询月排行榜
     * @return
     */
    List<UserInfo> queryHonorMonth();

    /**
     * 查询季度排行榜
     * @return
     */
    List<UserInfo> queryHonorMonths();

    /**
     * 查询当前排行榜
     * @return
     */
    List<UserInfo> queryHonorRanking();

    int updateByUMSelective(UserInfo userInfo);

    List<UserInfo> queryUserList(Map map);
    List<UserInfo> queryUserListForGroup(Map map);
    Integer count(UserInfo userInfo);

    Integer active(Map map);

    Integer updateForTaskAudit(UserInfo userInfo);

    Integer updateForShoppingAudit(UserInfo userInfo);

    UserInfo selectByUserName(String userName);

    List<UserInfo> queryUserArmory(Map map);

    Integer countForArmory(Map map);


    List<UserInfo> getMonthList(Map map);

    Integer userCount(UserInfo userInfo);

    Integer batchAdd(List<UserInfo> list);

    int insert(UserInfo record);
    int updateIconAddress(UserInfo userInfo);
    
    String getGroupNameByGroupId(Long groupId);
    
    Long getGroupIdByGroupName(String groupName);
    
    Integer updatePwd(UserInfo userInfo);
}