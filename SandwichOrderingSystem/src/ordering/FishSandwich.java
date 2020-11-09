package ordering;

public class FishSandwich extends Sandwich{
	
	static final double fishSandwichPrice = 12.99;
	
	public FishSandwich() {
		super();
	}

	@Override
	public double price() {
		
		double price = fishSandwichPrice;
		
		for(int i = 0; i<extras.size(); i++) {
			price += PER_EXTRA;
		}
		return price;
	}
	
	@Override 
	public String toString() {
		return "Grilled Snapper, Cilantro, Lime";
	}
	
}
