import java.util.Objects;

/**
 * @author 2030 student [Huanrui Cao, 219256809]
 *
 * The class should implement an item describing a line on an invoice: 
 * a product (including its name and price), and the quantity, as an integer 
 * The quantity above can be any integer (e.g., negative values indicate a product 
 * return for a refund)
 * 
 * The class is intended to be used in the implementation of another class or classes
 * 
 * ONE public constructor should exist:
 * InvoiceItem(Product product, int quantity): creates an invoice line item with 
 * the specified product and quantity
 * (you may add other - non-public - constructors, if you desire)
 * 
 * IMPORTANT
 * The product price may change after it's added to the invoice; however the price on the invoice
 * should not be affected (e.g., if product that sells for $2.00 is added to the invoice,
 * and then its price goes up to $2.50, the price of the items already added should remain $2.00.
 * However, if more items are added they will use the new price of $2.50
 * 
 * In addition, the following public methods should be implemented:
 * public Product getProduct()
 * public int getQuantity()
 * public void setQuantity(int quantity)
 * 
 * String toString()
 * this one should return a String in the form of "name, price=X, quantity=Y" 
 * where X is the item price, with two decimal digits; and Y is the quantity
 * 
 * IMPORTANT
 * You are expected to use the best practices you learned in EECS 2030 so far.
 * you may import any standard library classes, as necessary
 * e.g., import java.util.List;
 *  
 */

public class InvoiceItem {
	//TODO
	private final Product product;
    private int quantity;
    private final double originalPrice;

    /**
	 * Initializes an invoice item line with 
	 * the specified product and quantity.
	 */
    public InvoiceItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.originalPrice = product.getPrice();
    }

    /**
     * Return the product of this invoice item.
     * @return the product of this invoice item
     * @throws CloneNotSupportedException 
     */
    public Product getProduct() {
    	Product pClone = new Product(product.getName(), this.originalPrice);
        return pClone;
    }

    /**
     * Return the quantity of this invoice item.
     * @return the quantity of this invoice item
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of this invoice item.
     * @param quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Return the cost of this invoice item.
     * @return
     */
    public double getTotal() {
        return this.originalPrice * quantity;
    }

    /**
	 * Returns a string representation of this invoice item. 
	 * 
	 * @return a string representation of the invoice item
	 */
    @Override
    public String toString() {
        return product.getName() + ", price=" + String.format("%.2f", this.originalPrice) + ", quantity=" + quantity;
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
		InvoiceItem other = (InvoiceItem) obj;
		return Objects.equals(product, other.product) && quantity == other.quantity;
	}
    
    
}
