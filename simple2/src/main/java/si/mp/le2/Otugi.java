package si.mp.le2;

import si.mp.le2.Food;
import si.mp.le2.FoodVendor;

public class Otugi implements FoodVendor {
	private String foodName;

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public Food sell(Money m) {
		System.out.println(m.getAmt() + "원");
		return new Food(this.foodName);
	}
}
