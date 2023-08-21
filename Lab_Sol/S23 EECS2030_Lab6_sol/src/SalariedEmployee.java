import java.util.Date;

public class SalariedEmployee extends Employee {
	private double salary;

	protected SalariedEmployee(String name, Date dob, String employeeNumber) {
		super(name, dob, employeeNumber);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString(){
		return super.toString() + "Salary: " + this.salary + "\n";
	}

}
