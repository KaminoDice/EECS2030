import java.util.Date;

/**
 * A class of person that represents an immutable student object.
 * @author Huanrui Cao (219256809)
 * @author saikoro@my.yorku.ca
 */

public class Student extends Person {
	private String studentNumber;

	/**
	 * Initializes a student with {@code name} and {@code dob} and {@code studentNumber}
	 * @param name
	 * @param dob date of birth
	 * @param studentNumber
	 */
    public Student(String name, Date dob, String studentNumber) {
        super(name, dob);
        this.studentNumber = studentNumber;
    }

    /**
	 * Return the studentNumber of this student.
	 * @return studentNumber
	 */
    public String getStudentNumber() {
        return studentNumber;
    }

    /**
	 * Returns a string representation of the student with the name, dob and studentNumber. 
	 * 
	 * @return a string representation of the student.
	 */
    @Override
    public String toString() {
        return "Student\n" +
                "Name: " + getName() + '\n' +
                "DOB: " + getDob() +
                "\nStudent Number: " + studentNumber +
                '\n';
    }
}
