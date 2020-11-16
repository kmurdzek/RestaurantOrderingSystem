package ordering;

/**
 * ChickenSandwich class extends the Sandwich class and uses the parent class
 * constructor to make a ChickenSandwich Instance. This class holds the price of
 * the sandwich as well as changes it when extras are modified.
 * 
 * @author Kacper Murdzek, Taranvir Singh
 */
public class ChickenSandwich extends Sandwich {

	static final double chickenSandwichPrice = 8.99;

	/**
	 * ChickenSandwich constructor creates an instance of ChickenSandwich using the
	 * parent class constructor.
	 * 
	 */
	public ChickenSandwich() {
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
		double price = chickenSandwichPrice + (PER_EXTRA * extras.size());
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
		return "Chicken Sandwich; Fried Chicken, Spicy Sauce, Pickles, " + super.toString();

	}
}
