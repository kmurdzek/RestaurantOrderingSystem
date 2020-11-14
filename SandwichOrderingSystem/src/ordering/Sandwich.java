package ordering;

import java.util.ArrayList;

//import ordering.Extra.Ingredients;

public abstract class Sandwich implements Customizable {
	
	static final int MAX_EXTRAS = 6;
	static final double PER_EXTRA = 1.99;
	protected ArrayList<Extra> extras;

	public Sandwich() {
		extras = new ArrayList<>();
		
	}
	public abstract double price();
	
	public void printArray() {
		for(int i=0;i<extras.size();i++) {
			System.out.println(extras.get(i));
		}
	}

	@Override
	public boolean add(Object obj) {
		if(extras.size() <= MAX_EXTRAS) {
			extras.add(Extra.valueOf(obj.toString()));
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object obj) {
		
		int index = extras.indexOf(Extra.valueOf(obj.toString()));
		
		if(index != -1) {	
			extras.remove(index);
			return true;
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		String completeOrder="Extra: ";
		for(int i = 0; i < extras.size(); i++) {
			completeOrder=completeOrder + extras.get(i) +", ";
		}
		return completeOrder;
		
	}
	
}
