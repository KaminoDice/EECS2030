import java.util.Date;

public class Student extends Person {
	public final String studentNumber;

	protected Student(String name, Date dob, String studentNumber){
		super (name, dob);
		this.studentNumber = studentNumber;
	}

	@Override
	public String toString(){
		return "Student\n" + super.toString() + "Student Number: " + this.studentNumber + "\n";
	}

}
