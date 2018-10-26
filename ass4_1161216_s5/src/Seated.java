/**
 * @author waleed shuaib 1161216 section:5
 */
public class Seated extends PizzaOrder {

	private double serviceCharge;

	public Seated() {
		super();
	}

	public Seated(String name, int pizzaSize, int numOfToppings, double toppingPrice, double serviceCharge) {
		super(name, pizzaSize, numOfToppings, toppingPrice);
		this.serviceCharge = serviceCharge;
	}

	@Override
	public String printOrderReport(double order) {
		return super.printOrderReport(order);
	}

	@Override
	public double calculateOrderPrice() {
		return super.calculateOrderPrice() + serviceCharge;
	}

	@Override
	public String toString() {
		return super.toString() + "\nserviceCharge=" + serviceCharge;
	}
   //setter and getter methods
	public double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

}
