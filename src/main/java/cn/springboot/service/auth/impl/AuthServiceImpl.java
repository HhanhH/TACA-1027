//package cn.springboot.service.auth.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import cn.springboot.mapper.auth.RoleMapper;
//import cn.springboot.mapper.auth.UserInfoMapper;
//import cn.springboot.model.auth.Role;
//import cn.springboot.model.auth.UserInfo;
//import cn.springboot.service.auth.AuthService;
//
//@Service("authService")
//public class AuthServiceImpl implements AuthService {
//
//    @Autowired
//    private UserInfoMapper userMapper;
//
//    @Autowired
//    private RoleMapper roleMapper;
//
//    @Override
//    public UserInfo findUserByName(String username) {
//        return userMapper.findUserByName(username);
//    }
//
//    @Override
//    public Role findRoleByRoleCode(String roleCode) {
//        return roleMapper.findRoleByCode(roleCode);
//    }
//
//    @Override
//    public List<UserInfo> findUserByRoleCode(String roleCode) {
//        return userMapper.findUserByRoleCode(roleCode);
//    }
//
//}
//package cn.springboot.service.auth.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import cn.springboot.mapper.auth.RoleMapper;
//import cn.springboot.mapper.auth.UserInfoMapper;
//import cn.springboot.model.auth.Role;
//import cn.springboot.model.auth.UserInfo;
//import cn.springboot.service.auth.AuthService;
//
//@Service("authService")
//public class AuthServiceImpl implements AuthService {
//
//    @Autowired
//    private UserInfoMapper userMapper;
//
//    @Autowired
//    private RoleMapper roleMapper;
//
//    @Override
//    public UserInfo findUserByName(String username) {
//        return userMapper.findUserByName(username);
//    }
//
//    @Override
//    public Role findRoleByRoleCode(String roleCode) {
//        return roleMapper.findRoleByCode(roleCode);
//    }
//
//    @Override
//    public List<UserInfo> findUserByRoleCode(String roleCode) {
//        return userMapper.findUserByRoleCode(roleCode);
//    }
//
//}
