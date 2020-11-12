package ordering;

import java.util.ArrayList;

public class Order implements Customizable {
	
	public static int lineNumber;
	private ArrayList<OrderLine> orderLines;

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
	
	

}
