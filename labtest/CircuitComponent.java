package labTest2;

import java.text.NumberFormat;
import java.util.Objects;

/**
 * @author 2030 student [Huanrui Cao 219256809]
 *
 * The class should implement a circuit component that could be used in an electronic circuit
 * The class is intended to be used in the implementation of another class or classes
 * 
 * ONE public constructor should exist:
 * CircuitComponent(String name, double price): creates a component with the specified name and price
 * (you may add other - non-public - constructors, if you so desire) 
 * 
 * in addition to the above, the following public methods should be implemented:
 * public String getName()
 * public double getPrice()
 * public void setPrice(double price)
 * 
 * String toString()
 * this one should return a String in the form of "name, price=X" where X is the item price, with two decimal digits (no quotation marks)
 * 
 * IMPORTANT
 * You are expected to use the best practices you learned in EECS 2030 so far.
 *  
 */

public class CircuitComponent {
	//TODO
	private String name;
	private double price;
	
	public CircuitComponent(String name, double price) {
		this.name = name;
		this.price = price;
	}
	
	public CircuitComponent(CircuitComponent product) {
		this.name = product.name;
		this.price = product.price;
	}

	public String getName() {
		return this.name;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
//		return name + ", price=" + NumberFormat.getInstance().format(this.getPrice()) + "\n";
		return name + ", price=" + Double.toString(this.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CircuitComponent other = (CircuitComponent) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
	
}
