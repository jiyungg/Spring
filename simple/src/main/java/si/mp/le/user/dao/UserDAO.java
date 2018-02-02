package si.mp.le.user.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import si.mp.le.user.service.User;

@Repository("user.udao")
public class UserDAO {	
	@Autowired
	private JdbcTemplate jt;	
	@Autowired
	private User user;
	
	public UserDAO() {
		System.out.println("userDAO 생성~");
	}
	
	public User selectUser() {
		String sql = "select * from user_info where uino=1";
		return (User)jt.queryForObject(sql, new BeanPropertyRowMapper(User.class));
	}
}
