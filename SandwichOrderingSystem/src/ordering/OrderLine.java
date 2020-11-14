package ordering;

public class OrderLine {

	private int lineNumber;
	private Sandwich sandwich;
	private double price;

	public OrderLine(int lineNumber, Sandwich sandwich, double price) {
		this.lineNumber = lineNumber;
		this.sandwich = sandwich;
		this.price = price;
	}

	@Override
	public String toString() {

		return lineNumber + " " + sandwich + "Price $" + getPrice();
	}

	public double getPrice() {
		return price;
	}
}
