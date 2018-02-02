package si.mp.le2;

import si.mp.le2.Food;
import si.mp.le2.FoodVendor;

public class Super {
	
	private FoodVendor fv;
	private Money m;
	
	public Super(FoodVendor fv) {
		this.fv = fv;
	}
	
	public void setMoney(Money m) {
		this.m = m;
	}	
	
	public void buy() {		
		Food f = fv.sell(m);
		System.out.println(" 주고 산 " + f.getName());
	}
}
