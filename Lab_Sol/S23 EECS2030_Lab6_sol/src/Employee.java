import java.util.Date;

public abstract class Employee extends Person {
	public final String employeeNumber;
	
	protected Employee(String name, Date dob, String employeeNumber){
		super (name, dob);
		this.employeeNumber = employeeNumber;
	}
	
	@Override
	public String toString(){
		return "Employee\n" + super.toString() + "Employee Number: " + this.employeeNumber + "\n";
	}
}
