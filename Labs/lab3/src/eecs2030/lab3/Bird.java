package eecs2030.lab3;

import java.util.Objects;

public class Bird implements Comparable<Bird> {
    private final String type;
    private final double sizeGrams;

    public Bird(String type, double sizeGrams) {
        this.type = type;
        this.sizeGrams = sizeGrams;
    }

    public Bird() {
        this.type = "Unknown";
        this.sizeGrams = 350.0;
    }

    public String getType() {
        return type;
    }

    public double getSizeGrams() {
        return sizeGrams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Bird other = (Bird) o;
        
        return Objects.equals(this.getType(), other.getType())
                && Math.round(this.getSizeGrams() / 20.0) == Math.round(other.getSizeGrams() / 20.0);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, Math.round(sizeGrams / 20.0));
    }

    @Override
    public String toString() {
        return "Bird{" +
                "type='" + type + '\'' +
                ", sizeGrams=" + sizeGrams +
                '}';
    }

    @Override
    public int compareTo(Bird other) {
        int weightComp = Double.compare(Math.round(sizeGrams / 20.0), Math.round(other.sizeGrams / 20.0));
        if (weightComp != 0) {
            return weightComp;
        }
        return this.type.compareTo(other.type);
    }
}
