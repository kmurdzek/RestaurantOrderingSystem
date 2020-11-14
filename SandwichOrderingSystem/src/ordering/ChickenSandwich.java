package ordering;

public class ChickenSandwich extends Sandwich {

	static final double chickenSandwichPrice = 8.99;

	public ChickenSandwich() {
		super();
	}

	@Override
	public double price() {
		double price = chickenSandwichPrice + (PER_EXTRA * extras.size());
		return price;

	}

	@Override
	public String toString() {
		return "Chicken Sandwich; Fried Chicken, Spicy Sauce, Pickles, " + super.toString();

	}
}
