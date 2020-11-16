package ordering;

import java.util.ArrayList;

/**
 * Sandwich class is an abstract class that implements the Customizable
 * interface. Sandwich class holds the arrayList of extras for every instance of
 * a sandwich. Sandwich class has capabilities of adding and removing extra
 * ingredients.
 * 
 * @author Kacper Murdzek, Taranvir Singh
 */
public abstract class Sandwich implements Customizable {

	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;

	/**
	 * Sandwich constructor sets an arrayList for the sandwich that will hold the
	 * extra ingredients that the user selects.
	 */
	public Sandwich() {
		extras = new ArrayList<>();
	}

	/**
	 * Abstract price method allows the sandwich subclasses to calculate the
	 * sandwich price based off the sandwich cost along with the cost of extras.
	 * 
	 * @return price of sandwich
	 */
	public abstract double price();

	/**
	 * add method adds an ingredient to the arrayList of extras associated with the
	 * sandwich.
	 * 
	 * @return boolean if added
	 */
	@Override
	public boolean add(Object obj) {
		if (extras.size() <= MAX_EXTRAS) {
			extras.add(Extra.valueOf(obj.toString()));
			return true;
		}
		return false;
	}

	/**
	 * remove method removes an extra from the arrayList of extras. If the extra is
	 * not in the arrayList method returns false.
	 * 
	 * @return boolean true if removed false if not
	 */
	@Override
	public boolean remove(Object obj) {

		int index = extras.indexOf(Extra.valueOf(obj.toString()));

		if (index != -1) {
			extras.remove(index);
			return true;
		}

		return false;
	}

	/**
	 * toString method puts the arrayList of extras into a string.
	 * 
	 * @return string of Extras
	 */
	@Override
	public String toString() {
		String completeOrder = "Extra: ";
		for (int i = 0; i < extras.size(); i++) {
			completeOrder = completeOrder + extras.get(i) + ", ";
		}
		return completeOrder;

	}

}
