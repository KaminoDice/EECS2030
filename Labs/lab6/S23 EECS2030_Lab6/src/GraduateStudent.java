import java.util.Date;

/**
 * A class of person that represents a GraduateStudent object.
 * @author Huanrui Cao (219256809)
 * @author saikoro@my.yorku.ca
 */

public class GraduateStudent extends Student{
	private String thesisSupervisor;

	/**
	 * Initializes a GraduateStudent with {@code name} and {@code dob} and {@code studentNumber}
	 * @param name
	 * @param dob date of birth
	 * @param studentNumber
	 */
    public GraduateStudent(String name, Date dob, String studentNumber) {
        super(name, dob, studentNumber);
        this.thesisSupervisor = null;
    }

    /**
	 * Return the thesisSupervisor of this GraduateStudent.
	 * @return thesisSupervisor
	 */
    public String getThesisSupervisor() {
        return thesisSupervisor;
    }

    /**
	 * Set the thesisSupervisor of this GraduateStudent.
	 */
    public void setThesisSupervisor(String thesisSupervisor) {
        this.thesisSupervisor = thesisSupervisor;
    }

    /**
	 * Returns a string representation of the GraduateStudent with the name, dob, studentNumber and thesisSupervisor. 
	 * 
	 * @return a string representation of the GraduateStudent.
	 */
    @Override
    public String toString() {
        return "Graduate Student\n" +
                "Name: " + getName() + '\n' +
                "DOB: " + getDob() +
                "\nStudent Number: " + getStudentNumber() + '\n' +
                "Thesis Supervisor: " + thesisSupervisor +
                '\n';
    }
}
