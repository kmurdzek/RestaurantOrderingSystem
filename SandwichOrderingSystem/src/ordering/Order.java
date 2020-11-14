package ordering;

import java.util.ArrayList;

public class Order implements Customizable {

	public static int lineNumber;
	private ArrayList<OrderLine> orderLines;

	public Order() {
		orderLines = new ArrayList<>();
	}

	@Override
	public boolean add(Object obj) {
		getOrderLines().add((OrderLine) obj);
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		getOrderLines().remove(obj);
		return true;
	}

	public String printArr() {

		String output = "";

		for (int i = 0; i < getOrderLines().size(); i++) {
			output = output + getOrderLines().get(i).toString() + "\n";
		}

		return output;
	}

	public int size() {
		return getOrderLines().size();
	}
	
	public ArrayList<OrderLine> getOrder(){
		return getOrderLines();
	}

	public ArrayList<OrderLine> getOrderLines() {
		return orderLines;
	}

}
