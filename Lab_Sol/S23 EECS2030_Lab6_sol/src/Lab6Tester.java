import static org.junit.Assert.assertTrue;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Date;

import org.junit.Test;

public class Lab6Tester {

	@SuppressWarnings("deprecation")
	@Test
	public void testPerson() {
		Date dob = new Date();
		String name = "Person One";
		Person person = new Person (name, dob);
		String error = String.format("Person.getDob() failed");
		assertTrue(error + ": protective copy", person.getDob() != dob);
		assertTrue(error, person.getDob().getYear() + 1900 == 2023);

		assertTrue("Person.toString failed", person.toString().indexOf("Person One") > 0);
	}

	@Test
	public void testStudent() {
		Date dob = new Date();
		String name = "Student One";
		String number = "7676564";
		Student student1 = new Student (name, dob, number); 
		assertTrue("Student.toString failed 1", student1.toString().indexOf(name) > 0);
		assertTrue("Student.toString failed 2", student1.toString().indexOf(number) > 0);
	}


	@Test
	public void testGradStudent() {
		Date dob = new Date();
		String name = "Grad One";
		String number = "7676564";
		String supName = "Supervisor One";
		GraduateStudent grad1 = new GraduateStudent(name, dob, number); 
		grad1.setThesisSupervisor(supName);
		assertTrue("GradStudent.getSupervisor failed", grad1.getThesisSupervisor().equals(supName));
		assertTrue("GradStudent.toString failed 1", grad1.toString().indexOf(name) > 0);
		assertTrue("GradStudent.toString failed 2", grad1.toString().indexOf(number) > 0);
		assertTrue("GradStudent.toString failed 3", grad1.toString().indexOf(supName) > 0);
	}


	@Test
	public void testEmployee() {
		Date dob = new Date();
		String name = "Name0";
		String number = "728309720";
		Employee emp1 = new SalariedEmployee(name, dob, number); 
		assertTrue("Employee.toString failed 1", ((Employee) emp1).toString().indexOf(name) > 0);
		assertTrue("Employee.toString failed 2", ((Employee) emp1).toString().indexOf(number) > 0);
	}

	@Test
	public void testSalariedEmployee() {
		Date dob = new Date();
		String name = "Name1";
		String number = "728309720";
		int salary = 14_500; //ideally, it should be a double - based on the assignment description
		SalariedEmployee emp1 = new SalariedEmployee(name, dob, number);
		emp1.setSalary(salary);
		assertTrue("SalariedEmployee.getSalary failed", emp1.getSalary() == salary);
		assertTrue("SalariedEmployee.toString failed 1", emp1.toString().indexOf(name) > 0);
		assertTrue("SalariedEmployee.toString failed 2", emp1.toString().indexOf(number) > 0);
		assertTrue("SalariedEmployee.toString failed 3", emp1.toString().indexOf("14") > 0);
	}

	@Test
	public void testHourlyEmployee() {
		Date dob = new Date();
		String name = "Name2";
		String number = "728309720";
		double hourlyRate = 14.5;
		HourlyEmployee emp1 = new HourlyEmployee(name, dob, number);
		emp1.setHourlyRate(hourlyRate);
		assertTrue("HourlyEmployee.getSalary failed", emp1.getHourlyRate() == hourlyRate);
		assertTrue("HourlyEmployee.toString failed 1", emp1.toString().indexOf(name) > 0);
		assertTrue("HourlyEmployee.toString failed 2", emp1.toString().indexOf(number) > 0);
		assertTrue("HourlyEmployee.toString failed 3", emp1.toString().indexOf("14") > 0);
	}

	@Test
	public void testEmployeetoInstantiation() {
		final Constructor<?>[] constructors = Employee.class.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			assertTrue("Employee is not abstract and contains a public constructor", 
					!Modifier.isPublic(constructor.getModifiers())
					||Modifier.isAbstract(Employee.class.getModifiers()));
		}
	}

	@Test
	public void testEmployeeToString() {
		Date dob = new Date();
		String name = "Name00";
		String number = "728309720";

		class Employee2 extends Employee{
			protected Employee2(String name, Date dob, String employeeNumber) {
				super(name, dob, employeeNumber);
			}
		}

		Employee2 emp2 = new Employee2(name, dob, number);
		System.out.println(emp2);
		assertTrue("HourlyEmployee.toString failed 1", emp2.toString().indexOf(name) > 0);
		assertTrue("HourlyEmployee.toString failed 2", emp2.toString().indexOf(number) > 0);
		//if the above lines fail, this means that the [abstract] Employee does not override the toString() method
		//this increases code duplication in the Employee subclasses
	}


	@Test
	public void testForExtraneousEmployeeMethods() {
		final Method[] methods = Employee.class.getMethods();
		for (Method method : methods) {
			assertTrue("Employee contains a setHourlyRate method",
					!method.getName().equals("setHourlyRate"));
			assertTrue("Employee contains a setSalary method",
					!method.getName().equals("setSalary"));
					//!Modifier.isPublic(method.getModifiers()));
		}
		
	}
}