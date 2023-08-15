import java.util.Date;

/**
 * A class of person that represents an immutable person object.
 * @author Huanrui Cao (219256809)
 * @author saikoro@my.yorku.ca
 */

public class Person {
	private String name;
	private Date dob;

	/**
	 * Initializes a person with {@code name} and {@code dob}
	 * @param name
	 * @param dob date of birth
	 */
	public Person(String name, Date dob) {
		this.name = name;
		this.dob = dob;
	}

	/**
	 * Return the name of this person.
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Return the date of birth of this person.
	 * @return dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * Returns a string representation of the person with the name and dob. 
	 * 
	 * @return a string representation of the person.
	 */
	@Override
	public String toString() {
		return "Name: " + name + '\n' + "DOB: " + dob + '\n';
	}
}
