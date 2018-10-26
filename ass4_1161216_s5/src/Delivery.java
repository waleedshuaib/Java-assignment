/**
 * @author waleed shuaib 1161216 section:5
 */
public class Delivery extends PizzaOrder {
	private double tipRate;

	public Delivery() { // default constructor 

	}

	public Delivery(String name, int pizzaSize, int numOfToppings, double toppingPrice, double tipRate) {
		super(name, pizzaSize, numOfToppings, toppingPrice);
		this.tipRate = tipRate;
	}

	@Override
	public double calculateOrderPrice() { 
		double totalprice = (getNumOfToppings() * getToppingPrice()) * getPizzaSize();
		return super.calculateOrderPrice() + (tipRate / 100 * totalprice);
	}
	@Override
	public String printOrderReport(double order) {
		return super.printOrderReport(order);
	}

	@Override
	public String toString() {
		return super.toString() + "\ntipRate=" + tipRate;
	}
    //setter and getter methods
	public double getTipRate() {
		return tipRate;
	}

	public void setTipRate(double tipRate) {
		this.tipRate = tipRate;
	}

}
