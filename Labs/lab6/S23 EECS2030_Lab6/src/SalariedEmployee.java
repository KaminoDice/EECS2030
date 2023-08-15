import java.util.Date;

/**
 * A class of person that represents a SalariedEmployee object.
 * @author Huanrui Cao (219256809)
 * @author saikoro@my.yorku.ca
 */
public class SalariedEmployee extends Employee {
	private double salary;

	/**
	 * Initializes a SalariedEmployee with {@code name} and {@code dob} and {@code employeeNumber}
	 * @param name
	 * @param dob date of birth
	 * @param employeeNumber
	 */
    public SalariedEmployee(String name, Date dob, String employeeNumber) {
        super(name, dob, employeeNumber);
        this.salary = 0.0;
    }

    /**
	 * Return the Salary of this SalariedEmployee.
	 * @return salary
	 */
    public double getSalary() {
        return salary;
    }

    /**
	 * Set the Salary of this SalariedEmployee.
	 */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
	 * Returns a string representation of the SalariedEmployee with the name, dob, employeeNumber and salary. 
	 * 
	 * @return a string representation of the SalariedEmployee.
	 */
    @Override
    public String toString() {
        return "Employee\n" +
                "Name: " + getName() + '\n' +
                "DOB: " + getDob() +
                "\nEmployee Number: " + getEmployeeNumber() + '\n' +
                "Salary: " + salary +
                '\n';
    }
}
