package ordering;

/**
 * FishSandwich class extends the Sandwich class and uses the parent class
 * constructor to make a FishSandwich Instance. This class holds the price of
 * the sandwich as well as changes it when extras are modified.
 * 
 * @author Kacper Murdzek, Taranvir Singh
 */
public class FishSandwich extends Sandwich {

	static final double fishSandwichPrice = 12.99;

	/**
	 * FishSandwich constructor creates an instance of FishSandwich using the parent
	 * class constructor.
	 */
	public FishSandwich() {
		super();
	}

	/**
	 * price method calculates the price of the sandwich and updates when the extras
	 * are modified. Price method overrides the abstract price method in Sandwich
	 * class.
	 * 
	 * @return price of sandwich
	 */
	@Override
	public double price() {

		double price = fishSandwichPrice + (PER_EXTRA * extras.size());
		return price;
	}

	/**
	 * toString method creates a string of the sandwich. This method calls the
	 * parent class toString to complete the string with the extra ingredients.
	 * 
	 * @return String of sandwich
	 */
	@Override
	public String toString() {
		return "Fish Sandwich; Grilled Snapper, Cilantro, Lime, " + super.toString();
	}

}
