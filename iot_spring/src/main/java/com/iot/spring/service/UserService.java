package com.iot.spring.service;

import java.util.Map;

import com.iot.spring.vo.UserInfoVO;

public interface UserService {
	
	UserInfoVO getUserInfo(UserInfoVO ui);	
	void insertUser(Map<String,Object> rMap, UserInfoVO ui);
}
