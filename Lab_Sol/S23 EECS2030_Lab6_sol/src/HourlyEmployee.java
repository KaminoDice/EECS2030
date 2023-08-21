import java.util.Date;

public class HourlyEmployee extends Employee {
	private double hourlyRate;

	protected HourlyEmployee(String name, Date dob, String employeeNumber) {
		super(name, dob, employeeNumber);
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public String toString(){
		return super.toString() + "Hourly rate: " + this.hourlyRate + "\n";
	}

}
