package labTest2;

import java.util.Objects;

/**
 * @author 2030 student [Huanrui Cao 219256809]
 *
 * The class should implement an entry for a list of electronic components in a circuit: 
 * a component (including its type/name and price), and the quantity, as a positive integer 
 * 
 * The class is intended to be used in the implementation of another class or classes
 * 
 * ONE public constructor should exist:
 * ComponentListEntry(CircuitComponent product, int quantity): creates an entry with 
 * the specified component and quantity
 * (you may add other - non-public - constructors, if you so desire)
 * 
 * IMPORTANT
 * The component price may change after it's added to the list; and the price in the list
 * should reflect the new price (e.g., if a component that sells for $2.00 is added to the list,
 * and then its price goes up to $2.50, the price of the items already added should also change to $2.50.
 * 
 * In addition, the following public methods should be implemented:
 * public Product getComponent()
 * public int getQuantity()
 * public void setQuantity(int quantity)
 * 
 * String toString()
 * this one should return a String in the form of "name, price=X, quantity=Y" 
 * where X is the component price, with two decimal digits; and Y is the quantity
 * 
 * IMPORTANT
 * You are expected to use the best practices you learned in EECS 2030 so far.
 *  
 */

public class ComponentListEntry {
	//TODO
	private CircuitComponent product;
	private int quantity;
	
	public ComponentListEntry(CircuitComponent product, int quantity) {
		this.product = new CircuitComponent(product);
		this.quantity = quantity;
	}
	
	public CircuitComponent getComponent() {
		return new CircuitComponent(this.product);
	}
	
	public int getQuantity() {
		int quan = this.quantity;
		return quan;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return this.product.toString() + ", quantity=" + this.getQuantity();
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComponentListEntry other = (ComponentListEntry) obj;
		return Objects.equals(product, other.product) && quantity == other.quantity;
	}
	
	
}
