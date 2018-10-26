
/**
 * @author waleed shuaib 
 *1161216
 *section:5
 */
import java.util.Date;

public class PizzaOrder implements Comparable<PizzaOrder> {
    //attributes
	private String name;
	private Date dateOrderd = new Date();
	private int pizzaSize;
	private int numOfToppings;
	private double toppingPrice;
	private String size = "";

	public PizzaOrder() {

	}
    //constructor with arguments
	public PizzaOrder(String name, int pizzaSize, int numOfToppings, double toppingPrice) {
		super();
		this.name = name;
		this.pizzaSize = pizzaSize;
		this.numOfToppings = numOfToppings;
		this.toppingPrice = toppingPrice;
	}

	public double calculateOrderPrice() {
		return (numOfToppings * toppingPrice) * pizzaSize;

	}

	public String printOrderReport(double order) {
		order = calculateOrderPrice(); // this if's statements to check the pizzaSize as shown
		if (this.pizzaSize == 1)
			size = "\nsmall";
		if (this.pizzaSize == 2)
			size = "/nmedium";
		if (this.pizzaSize == 2)
			size = "/nlarge";
		return toString() + order;

	}

	public String printOrderInfo() {
		 calculateOrderPrice();
		return "Costumer name:  " + name + "        price is:  " + calculateOrderPrice();

	}

	@Override
	public int compareTo(PizzaOrder price) { // this method to sort the orders based on calculated orders price

		if (calculateOrderPrice() > price.calculateOrderPrice())
			return -1;
		if (calculateOrderPrice() < price.calculateOrderPrice())
			return 1;
		else
			return 0;

	}

	@Override
	public String toString() {
		if (this.pizzaSize == 1) // this if's statements to chick pizzaSize as shown
			size = "small";
		if (this.pizzaSize == 2)
			size = "medium";
		if (this.pizzaSize == 3)
			size = "large";

		return "Costumer name=" + name + "\n DateOrderd=" + dateOrderd + "\npizzaSize=" + size + "\n NumOfToppings="
				+ numOfToppings + "\n ToppingPrice=" + toppingPrice;
	}
    //setter and getter methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOrderd() {
		return dateOrderd;
	}

	public int getPizzaSize() {
		return pizzaSize;
	}

	public void setPizzaSize(int pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public int getNumOfToppings() {
		return numOfToppings;
	}

	public void setNumOfToppings(int numOfToppings) {
		this.numOfToppings = numOfToppings;
	}

	public double getToppingPrice() {
		return toppingPrice;
	}

	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}

}
