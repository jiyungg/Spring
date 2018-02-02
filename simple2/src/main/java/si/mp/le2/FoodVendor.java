package si.mp.le2;

import si.mp.le2.Food;

public interface FoodVendor {
	public void setFoodName(String foodName);

	public Food sell(Money m);
}
