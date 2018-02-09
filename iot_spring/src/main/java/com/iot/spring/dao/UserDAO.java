package com.iot.spring.dao;

import java.util.Map;

import com.iot.spring.vo.UserInfoVO;

public interface UserDAO {
	
	UserInfoVO selectUserInfo(UserInfoVO ui);
	int insertUser(UserInfoVO ui);
	int checkUserInfo(UserInfoVO ui);


}

