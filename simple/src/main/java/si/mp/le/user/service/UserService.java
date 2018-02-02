package si.mp.le.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import si.mp.le.user.dao.UserDAO;

@Service
public class UserService {
	
	@Autowired
	private UserDAO udao;
	
	public User getUser() {
		return udao.selectUser();
	}
}
