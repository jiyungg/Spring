package si.mp.le.aop;

import org.springframework.aop.framework.ProxyFactory;

public class Excute {
	
	public static void main(String[] args) {
		PrintSome ps = new Print();
		//여기서 프록시팩토리가 들어감.
		//
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new PrintAdvice());
		//=ProxyFactory pf = new ProxyFactory(
		// Advice ad = new PrintAdvice();
		// 윗 두줄은 이 두줄과 같다고 한다.
		//
		//그러고나서, 감쌀 객체를 지정해줍니다.
		pf.setTarget(ps);
		
		Print p = (Print)pf.getProxy();
		p.hello();
	}
}
