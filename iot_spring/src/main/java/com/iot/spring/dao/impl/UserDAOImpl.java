package com.iot.spring.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.vo.UserInfoVO;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	SqlSessionFactory ssf;

	@Override
	public UserInfoVO selectUserInfo(UserInfoVO ui) {
		final SqlSession ss = ssf.openSession();
		UserInfoVO rUi = ss.selectOne("user.selectUser", ui);
		ss.close();
		return rUi;
	}

	@Override
	public int insertUser(UserInfoVO ui) {
		final SqlSession ss = ssf.openSession();
		int result = ss.insert("user.insertUser", ui);
		ss.close();
		return result;
	}

	@Override
	public int checkUserInfo(UserInfoVO ui) {
		final SqlSession ss = ssf.openSession();
		int result = ss.selectOne("user.checkUser",ui);
		ss.close();
		return result;
	}
}
