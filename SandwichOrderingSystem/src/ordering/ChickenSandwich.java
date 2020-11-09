package ordering;

public class ChickenSandwich extends Sandwich{
	
	static final double chickenSandwichPrice = 8.99;
	
	public ChickenSandwich() {
		super();
	}
	@Override
	public double price() {
		double price = chickenSandwichPrice;
		
		for(int i = 0; i<extras.size(); i++) {
			price += PER_EXTRA;
		}
		return price;
		
	}
	@Override
	public String toString() {
		return "Fried Chicken, Spicy Sauce, Pickles";
	}
}
