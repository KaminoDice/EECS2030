import java.util.Date;

public class Person {
	public final String name;
	private Date dob;

	public Person(String name, Date dob){
		this.name = name;
		this.dob = (Date) dob.clone();
	}
	
	public Date getDob (){
		return (Date) dob.clone();
	}
	
	@Override
	public String toString(){
		return "Name: " + this.name + "\nDOB: " + this.dob + "\n";
	}

}
