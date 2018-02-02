package com.iot.spring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public List<User> getUserList(){
		User user = new User();
		user.setName("홍길동");
		user.setAge(30);
		List<User> list = new ArrayList<User>();
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);
		list.add(user);
		return list;
	}

	public List<User> getUserList2(){
		List<User> list = new ArrayList<User>();
		for(int i=1;i<10;i++) {
			User user = new User();
			user.setName("홍길동"+i);
			user.setAge(i);
			list.add(user);
		}
		return list;
	}
}
