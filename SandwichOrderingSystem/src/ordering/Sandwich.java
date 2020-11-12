package ordering;

import java.util.ArrayList;

public abstract class Sandwich implements Customizable {
	
	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;

	public Sandwich() {
		
	}
	public abstract double price();

	@Override
	public boolean add(Object obj) {
		
		if(extras.size() <= MAX_EXTRAS) {
			extras.add((Extra) obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		
		int index = extras.indexOf((Extra)obj);
		
		if(index != -1) {	
			extras.remove(index);
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		String completeOrder = this.toString();
		for(int i = 0; i < extras.size(); i++) {
			completeOrder.concat(", " + extras.get(i));
		}
		return completeOrder;
		
	}
	
}
