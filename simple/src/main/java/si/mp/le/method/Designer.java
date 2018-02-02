package si.mp.le.method;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;

public class Designer implements MethodReplacer {

//	@Override
	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {		
		return "디자이너 일중";
	}
}





