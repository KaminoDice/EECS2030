package labTest2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 2030 student [Huanrui Cao 219256809]
 *
 * The class should implement an list for electronic components to be used during a circuit development 
 * containing zero or more lines of components with their prices and quantities, e.g.,
 * Transistor 2N2222, price=1.99, quantity=3
 * 
 * ONE public constructor should exist (no other constructors are permitted):
 * ComponentList(): creates an empty component list, so that the items can be added to it
 * 
 * In addition to the above, the following public methods should be implemented:
 * 
 * public void addComponent(CircuitComponent item, int quantity) - adds the new line to the invoice
 * NOTE: for simplicity, if the same items are added multiple times, they should remain on 
 * separate lines (i.e., identical components should NOT be merged into one line) 
 * 
 * public List<ComponentListEntry> getItems() - returns a list of all the component list entries,
 * with the items in the same order that they were added in using the addComponent method above
 * IMPORTANT
 * The client calling getItems() should not be able to change the quantities in the original component list
 * 
 * public double getTotal() - returns the total cost of the components in the component list
 * 
 * String toString()
 * this one should return a String in the following form:
 * Component List
 * Transistor 2SC5200, price=21.99, quantity=1
 * Resistor 0.2 Ohm, price=1.99, quantity=3
 * Capacitor 100 uF, price=0.98, quantity=30
 * Total: 57.36
 *  
 * Of course, the numbers above may be very different for any particular instance
 * 
 * IMPORTANT
 * You are expected to use the best practices you learned in EECS 2030 so far.
 * You may import other Java classes, as needed.
 *  
 */

public class ComponentList{
	//TODO
	private ArrayList<ComponentListEntry> al ;
	
	public ComponentList() {
		 this.al = new ArrayList<ComponentListEntry>();
	 }
	
	public void addComponent(CircuitComponent item, int quantity) {
		ComponentListEntry ent = new ComponentListEntry(item, quantity);
		this.al.add(ent);
	}
	
	public List<ComponentListEntry> getItems() {
		List<ComponentListEntry> nl = new ArrayList<ComponentListEntry>();
		for (int i = 0 ; i < al.size(); ++i) {
			ComponentListEntry cp = new ComponentListEntry(this.al.get(i).getComponent(), this.al.get(i).getQuantity());
			nl.add(cp);
		}
		return nl;
	}
	
	public double getTotal() {
		double toCost = 0.00;
		for (int i = 0 ; i < al.size(); ++i) {
			toCost += this.al.get(i).getComponent().getPrice();
		}
		return toCost;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < al.size(); ++i) {
			sb.append(al.get(i).toString());
			sb.append("\n");
		}
		sb.append("Total: " + Double.toString(this.getTotal())+ "\n");
		return sb.toString();
	}
	
}
