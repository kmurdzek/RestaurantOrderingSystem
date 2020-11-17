package ordering;

import java.util.ArrayList;

/**
 * Order class makes it possible to add and remove orders from and implements
 * the Customizable interface. This class makes it possible for users to save an
 * order and to have it all in one place.
 * 
 * @author Kacper Murdzek, Taranvir Singh
 *
 */
public class Order implements Customizable {

	public static int lineNumber;
	private ArrayList<OrderLine> orderLines;

	/**
	 * Constructor that initializes the arrayList that will hold the users order.
	 * 
	 */
	public Order() {
		orderLines = new ArrayList<>();
	}

	/**
	 * add method overrides the Customizable add method and adds an order to the
	 * orderLines arrayList.
	 * 
	 * @param orderline to be added
	 * @return boolean if added
	 */
	@Override
	public boolean add(Object obj) {
		getOrderLines().add((OrderLine) obj);
		return true;
	}

	/**
	 * remove method overrides the Customizable remove method and removes an order
	 * from the orderlines arrayList.
	 * 
	 * @param orderline to be removed
	 * @return boolean if removed
	 */
	@Override
	public boolean remove(Object obj) {
		
		if(getOrderLines().contains(obj)) {
			getOrderLines().remove(obj);
			return true;
		}
		else {
			return false;
		}
	}

	/**
	 * size method gets the size of the orderLines array.
	 * 
	 * @return int size of arrayList
	 */
	public int size() {
		return getOrderLines().size();
	}

	/**
	 * getOrderLines method gets the orderLines array that stores the sandwich
	 * orders.
	 * 
	 * @return orderline arrayList
	 */
	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

}
