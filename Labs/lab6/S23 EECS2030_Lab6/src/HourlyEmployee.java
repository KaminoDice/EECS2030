import java.util.Date;

/**
 * A class of person that represents a HourlyEmployee object.
 * @author Huanrui Cao (219256809)
 * @author saikoro@my.yorku.ca
 */
public class HourlyEmployee extends Employee {
	private double hourlyRate;

	/**
	 * Initializes a HourlyEmployee with {@code name} and {@code dob} and {@code employeeNumber}
	 * @param name
	 * @param dob date of birth
	 * @param employeeNumber
	 */
    public HourlyEmployee(String name, Date dob, String employeeNumber) {
        super(name, dob, employeeNumber);
        this.hourlyRate = 0.0;
    }

    /**
	 * Return the hourlyRate of this HourlyEmployee.
	 * @return hourlyRate
	 */
    public double getHourlyRate() {
        return hourlyRate;
    }
    
    /**
	 * Set the hourlyRate of this HourlyEmployee.
	 */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    /**
	 * Returns a string representation of the HourlyEmployee with the name, dob, employeeNumber and hourlyRate. 
	 * 
	 * @return a string representation of the HourlyEmployee.
	 */
    @Override
    public String toString() {
        return "Employee\n" +
                "Name: " + getName() + '\n' +
                "DOB: " + getDob() +
                "\nEmployee Number: " + getEmployeeNumber() + '\n' +
                "Hourly rate: " + hourlyRate +
                '\n';
    }
}
