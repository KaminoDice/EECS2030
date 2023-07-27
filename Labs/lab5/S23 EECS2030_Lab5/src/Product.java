import java.util.Objects;

/**
 * @author 2030 student [Huanrui Cao, 219256809]
 *
 * The class should implement a product that could be sold in a store
 * The class is intended to be used in the implementation of another class or classes
 * 
 * ONE public constructor should exist:
 * Product(String name, double price): creates a product with the specified name and price
 * (you may add other - non-public - constructors, if you desire) 
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
 * you may import any standard library classes, as necessary
 * e.g., import java.util.List;
 *  
 */

public class Product {
	//TODO
	private final String name;
    private double price;

    /**
	 * Initializes a Product with {@code name} and {@code price}
	 * 
	 * @param name the name of this product
	 * @param price the price of this product
	 */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
	 * Return the name of this product.
	 * 
	 * @return the name of this product
	 */
    public String getName() {
        return name;
    }

    /**
     * Return the price of this product.
     * @return the price of this product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of this product.
     * @param the price of this product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
	 * Returns a string representation of this product with the name and price. 
	 * 
	 * @return a string representation of the product.
	 */
    @Override
    public String toString() {
        return name + ", price=" + String.format("%.2f", price);
    }

    
    /**
	 * Override the {@code hashCode()} by considered equal the same product.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(name, price);
	}

	/**
	 * Override the {@code equals()} by considered equal the same product.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(name, other.name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}
	
//	@Override
//    public Product clone() throws CloneNotSupportedException{
//     
//        return (Product) super.clone();
//    }
}
