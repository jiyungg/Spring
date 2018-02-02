package si.mp.le2;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Excute {
	
	public static void main(String[] args) {
		String path = "src/main/resources/ioc.xml";		
		BeanFactory bf = new XmlBeanFactory(new FileSystemResource(path));
		Super s = (Super)bf.getBean("s");
		s.buy();
	}
}
