package com.iot.spring.service;

import java.util.Map;

import com.iot.spring.vo.UserInfoVO;

public interface UserService {
   
   void insertUser(Map<String,Object> rMap, UserInfoVO ui);  
   void selectUser(Map<String,Object> rMap, UserInfoVO ui);
   void deleteUser(Map<String,Object> rMap, UserInfoVO ui);
   void updateUser(Map<String,Object> rMap, UserInfoVO ui);
   UserInfoVO getUserInfo(UserInfoVO ui);   
}












