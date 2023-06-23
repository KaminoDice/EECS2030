package eecs2030.lab3;

import java.util.Objects;
/**
 * A class of birds that represents an immutable bird object.
 * @author Huanrui Cao (219256809)
 * @author saikoro@my.yorku.ca
 */

public class Bird implements Comparable<Bird> {
	
	private final String type;
	private final double sizeGrams;
	
	/**
	 * Initializes a bird with {@code type} and {@code sizeGrams}
	 * 
	 * @param type the type of this bird
	 * @param sizeGrams the weight of this bird
	 */
	public Bird(String type, double sizeGrams) {
		this.type = type;
		this.sizeGrams = sizeGrams;
	}
	
	/**
	 * Initializes a default bird with {@code type} Unknown and {@code sizeGrams} 350.0 
	 */

	public Bird() {
		this.type = "Unknown";
		this.sizeGrams = 350.0;
	}
	
	/**
	 * Return the type of this bird.
	 * 
	 * @return the type of this bird
	 */
	public String getType() {
		return type;
	}

	/**
	 * Return the weight of this bird.
	 * @return the weight of this bird
	 */
	public double getSizeGrams() {
		return sizeGrams;
	}

	/**
	 * Two birds are to be considered equal if they are of the same type, 
	 * and their weight is equal when rounded to the nearest multiple of 20 g.
	 */
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || this.getClass() != o.getClass())
			return false;
		Bird other = (Bird) o;

		return Objects.equals(this.getType(), other.getType())
				&& Math.round(this.getSizeGrams() / 20.0) == Math.round(other.getSizeGrams() / 20.0);
	}
	
	/**
	 * Override the {@code hashCode()} by considered equal the same type,
	 * and weight is equal when rounded to the nearest multiple of 20 g.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(type, Math.round(sizeGrams / 20.0));
	}

	/**
	 * Returns a string representation of the bird with the type and weight. 
	 * 
	 * @return a string representation of the bird.
	 */
	@Override
	public String toString() {
		return "Bird{" + "type='" + type + '\'' + ", sizeGrams=" + sizeGrams + '}';
	}

	/**
	 * Returns the difference between two bird by considered equal if they are of the same type, 
	 * and their weight is equal when rounded to the nearest multiple of 20 g.
	 * <p>
	 * Non-equal birds are ranked first by weight (rounded to the nearest 20 g), 
	 * and then by type (alphabetically).
	 * 
	 * @return  difference between two bird
	 */
	@Override
	public int compareTo(Bird other) {
		int weightComp = Double.compare(Math.round(sizeGrams / 20.0), Math.round(other.sizeGrams / 20.0));
		if (weightComp != 0) {
			return weightComp;
		}
		return this.type.compareTo(other.type);
	}
}
