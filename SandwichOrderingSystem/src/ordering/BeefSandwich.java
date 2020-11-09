package ordering;

public class BeefSandwich extends Sandwich{
	
	static final double beefSandwichPrice = 10.99;
	
	public BeefSandwich() {
		super();
	}
	
	@Override
	public double price() {
		
		double price = beefSandwichPrice;
		
		for(int i = 0; i<extras.size(); i++) {
			price += PER_EXTRA;
		}
		return price;
	}
	
	@Override
	public String toString() {
		return "Roast Beef, Provolone Cheese, Mustard";
	}
}
