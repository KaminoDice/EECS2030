import java.util.Date;

/**
 * An abstract class of person that represents an employee object.
 * @author Huanrui Cao (219256809)
 * @author saikoro@my.yorku.ca
 */
public abstract class Employee extends Person {
	private String employeeNumber;

    public Employee(String name, Date dob, String employeeNumber) {
        super(name, dob);
        this.employeeNumber = employeeNumber;
    }

    /**
	 * Return the employeeNumber of this Employee.
	 * @return employeeNumber
	 */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public abstract String toString();
}
