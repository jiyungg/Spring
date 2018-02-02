package si.mp.le.emp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Excute {
	
	
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("method/ioc.xml");
		EmpDAO ed = (EmpDAO)ac.getBean("edao");
		ed.test();
	}	
}
