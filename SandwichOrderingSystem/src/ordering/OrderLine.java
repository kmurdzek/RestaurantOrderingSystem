package ordering;

public class OrderLine {

	private int lineNumber;
	private Sandwich sandwich;
	private double price;

	public OrderLine(int lineNumber, Sandwich sandwich, double price) {
		this.setLineNumber(lineNumber);
		this.sandwich = sandwich;
		this.price = price;
	}

	@Override
	public String toString() {

		return lineNumber + " " + getSandwich() + "Price $" + getPrice();
	}

	public double getPrice() {
		return price;
	}

	public Sandwich getSandwich() {
		return sandwich;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
}
