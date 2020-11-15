package ordering;

public class BeefSandwich extends Sandwich {

	static final double beefSandwichPrice = 10.99;

	public BeefSandwich() {
		super();
	}

	@Override
	public double price() {

		double price = beefSandwichPrice + (PER_EXTRA * extras.size());
		return price;
	}

	@Override
	public String toString() {
		return "Beef Sandwich; Roast Beef, Provolone Cheese, Mustard, " + super.toString();
	}
}
