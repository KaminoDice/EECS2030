

/**
 * @author 2030 student [Huanrui Cao, 219256809]
 *
 * The class should implement an invoice containing zero or more lines
 * of products with their prices and quantities, e.g.,
 * Oatmeal Cookies, price=1.99, quantity=3
 * (you may also think of it in terms of a  "Shopping cart" - to some extent the two are similar).
 * 
 * ONE public constructor should exist (no other constructors are permitted):
 * Invoice(): creates an empty invoice, so that the items can be added to it
 * 
 * In addition to the above, the following public methods should be implemented:
 * 
 * public void addItem(Product item, int quantity) - adds the new line to the invoice
 * NOTE: for simplicity, if the same items are added multiple times, they should remain on 
 * separate lines (i.e., identical products should NOT be merged into one line) 
 * 
 * public List<InvoiceItem> getItems() - returns a list of all the invoice items,
 * with the items in the same order that they were added in using the addItem method above
 * IMPORTANT
 * The client calling getItems() should not be able to change the invoice items
 * 
 * public double getTotal() - returns the total cost of the items on the invoice
 * 
 * String toString()
 * this one should return a String in the following form:
 * Invoice
 * Chocolate Cake, price=21.99, quantity=1
 * Oatmeal Cookies, price=1.99, quantity=3
 * Tasty Chocolates, price=0.98, quantity=30
 * Total: 57.36
 *  
 * Of course, the numbers above may be very different for any particular instance
 * 
 * IMPORTANT
 * You are expected to use the best practices you learned in EECS 2030 so far.
 * you may import any standard library classes, as necessary
 * e.g., import java.util.List;
 *  
 */
import java.util.ArrayList;
import java.util.List;

public class Invoice {
	//TODO
	private final List<InvoiceItem> items;

	/**
	 * Initializes an empty invoice. 
	 */
	public Invoice() {
        this.items = new ArrayList<>();
    }

    /**
     * Adds the new line of item to the invoice.
     * @param item
     * @param quantity the quantity of this item
     */
	public void addItem(Product item, int quantity) {
        items.add(new InvoiceItem(item, quantity));
    }

    /**
     * returns a list of all the invoice items, with the items in the 
     * same order that they were added in using the addItem method above.
     * @return a list of all the invoice items
     */
	public List<InvoiceItem> getItems() {
		List <InvoiceItem> cList = new ArrayList<InvoiceItem>();
		for (InvoiceItem i : this.items) {
			cList.add(new InvoiceItem(i.getProduct(), i.getQuantity()));
		}
        return cList;
    }

    /**
     * returns the total cost of the items on the invoice.
     * @return the total cost of the items on the invoice
     */
	public double getTotal() {
        double total = 0.0;
        for (InvoiceItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    /**
	 * Returns a string representation of this invoice. 
	 * 
	 * @return a string representation of the invoice
	 */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Invoice\n");
        for (InvoiceItem item : items) {
            sb.append(item).append("\n");
        }
        sb.append("Total: ").append(getTotal());
        return sb.toString();
    }
}
