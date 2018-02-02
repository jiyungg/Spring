package si.mp.le2;

public class Food {
	
	public String name;
	
	public Food(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	@Override
	public String toString() {
		return "Food [name=" + name + "]";
	}

}
