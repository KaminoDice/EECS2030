package eecs2030.lab3;

import java.util.Objects;

public class Bird implements Comparable <Bird>{
	private String type;
	private double sizeGrams;
	/**
	 * Creates a Bird object of an unknown type, 350 grams in weight 
	 */
	public Bird() {
		this("Uknown", 350);
	} 
	/**
	 * Creates a Bird object of a specified type (e.g., Goose), and its weight in grams
	 * @param type
	 * @param sizeGrams
	 */
	public Bird(String type, double sizeGrams) {
		if (sizeGrams <= 0)
			throw new IllegalArgumentException("size should be positive");
		this.type = type;
		this.sizeGrams = sizeGrams;
	}

	public String getType() {
		return type;
	}

	public double getSizeGrams() {
		return sizeGrams;
	}

	@Override
	public String toString() {
		return "Bird[type=" + type + ", sizeGrams=" + sizeGrams + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Math.round(sizeGrams/20.0), type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bird other = (Bird) obj;
		return Math.round(sizeGrams / 20.0) == Math.round(other.sizeGrams / 20.0)
				&& Objects.equals(type, other.type);
	} 

	@Override
	public int compareTo(Bird o) {
		if (Math.round(sizeGrams / 20.0) != Math.round(o.sizeGrams / 20.0))
				return Double.compare(sizeGrams, o.sizeGrams);
		else return type.compareTo(o.type);
	}

}
