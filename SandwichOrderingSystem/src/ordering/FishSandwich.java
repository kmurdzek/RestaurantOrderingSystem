package ordering;

public class FishSandwich extends Sandwich{
	
	static final double fishSandwichPrice = 12.99;
	
	public FishSandwich() {
		super();
	}

	@Override
	public double price() {
		
		double price = fishSandwichPrice  + (PER_EXTRA* extras.size());
		return price;
	}
	
	@Override 
	public String toString() {
		return "Fish Sandwich; Grilled Snapper, Cilantro, Lime" + super.toString();
	}
	
}
