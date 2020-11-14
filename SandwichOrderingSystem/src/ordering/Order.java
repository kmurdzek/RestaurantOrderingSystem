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
		orderLines.add((OrderLine) obj);
		return true;
	}

	@Override
	public boolean remove(Object obj) {
		orderLines.remove(obj);
		return true;
	}

	public String printArr() {

		String output = "";

		for (int i = 0; i < orderLines.size(); i++) {
			output = output + orderLines.get(i).toString() + "\n";
		}

		return output;
	}

	public int size() {
		return orderLines.size();
	}

}
