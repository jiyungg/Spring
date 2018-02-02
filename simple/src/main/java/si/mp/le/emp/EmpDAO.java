package si.mp.le.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class EmpDAO {
	private JdbcTemplate jt;
	
	public void setJdbcTemplate(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	public void test() {
		try {
			Connection c = jt.getDataSource().getConnection();
			System.out.println("연결 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Emp> selectEmpList(){
		String sql="select * from emp";
		return jt.query(sql, new BeanPropertyRowMapper(Emp.class));		
	}		
	
	public Emp selectEmp(int empNo) {
		String sql="select * from emp where empno=?";
		return jt.queryForObject(sql, new Object[] {empNo}, new BeanPropertyRowMapper(Emp.class));		
	}
}
