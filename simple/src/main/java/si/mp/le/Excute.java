
package si.mp.le;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import si.mp.le.emp.Emp;
import si.mp.le.emp.EmpDAO;

public class Excute {
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("method/ioc.xml");
		EmpDAO ed = (EmpDAO)ac.getBean("edao");
		ed.test();
		for(Emp e : ed.selectEmpList()) {
			System.out.println(e);
		}
		System.out.println(ed.selectEmp(1));
	}
}



