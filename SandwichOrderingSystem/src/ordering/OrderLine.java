package ordering;

import java.text.DecimalFormat;

/**
 * Orderline class creates an instance of a sandwich order and and makes it
 * ready to be put into the orderLine arrayList to be displayed on the GUI.
 * OrderLine object contains a line number which is essentially the order serial
 * number, a sandwich that the user selected, and a price of the sandwich.
 * 
 * @author Kacper Murdzek, Taranvir Singh
 */
public class OrderLine {

	private int lineNumber;
	private Sandwich sandwich;
	private double price;

	/**
	 * Orderline Constructor creates an Orderline object that holds sandwich
	 * details.
	 * 
	 * @param lineNumber serial number
	 * @param sandwich   type
	 * @param price      of sandwich
	 */
	public OrderLine(int lineNumber, Sandwich sandwich, double price) {
		this.lineNumber = lineNumber;
		this.sandwich = sandwich;
		this.price = price;
	}

	/**
	 * toString method makes a string from an orderLine object.
	 * 
	 * @return String orderLine
	 */
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,###,##0.00");
		String priceFormated = df.format(getPrice());
		return lineNumber + " " + getSandwich() + "Price $" + priceFormated;
	}

	/**
	 * getPrice is a getter method that gets the final price of sandwich when it is
	 * ready to be displayed.
	 * 
	 * @return douple price of sandwich
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * getSandwich method gets the sandwich associated with the orderLine object.
	 * 
	 * @return Sandwich type
	 */
	public Sandwich getSandwich() {
		return sandwich;
	}

	/**
	 * setLineNumeber method sets the lineNumber of the orderLine object when an
	 * orderLine is removed and orderLines need to be renumbered.
	 * 
	 * @param lineNumber to be set
	 */
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
}
