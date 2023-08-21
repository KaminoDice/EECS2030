import java.util.Date;

public class GraduateStudent extends Student{
	private String thesisSupervisor;

	public GraduateStudent(String name, Date dob, String studentNumber) {
		super(name, dob, studentNumber);
	}
	
	public void setThesisSupervisor(String thesisSupervisor){
		this.thesisSupervisor = thesisSupervisor;
	}

	public String getThesisSupervisor(){
		return this.thesisSupervisor;
	}

	public String toString(){
		return "Graduate " + super.toString() + "Thesis Supervisor: " + this.thesisSupervisor + "\n";
	}
	
}
