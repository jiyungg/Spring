package com.iot.spring.dao;

import java.util.Map;

import com.iot.spring.vo.UserInfoVO;

public interface UserDAO {
   
   public int insertUser(UserInfoVO ui);
   UserInfoVO selectUserInfo(UserInfoVO ui);
   public void deleteUserInfo(UserInfoVO ui);
   public void updateUserInfo(UserInfoVO ui);   
   public int checkUserInfo(UserInfoVO ui);

}