package chapterone;

import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee extends SerialConeable  implements  Serializable {
	public String name;
	public Date birthDay;
	public double salary;

	
	public static int NAME_SIZE =100;
	
	public static int RECORD_SIZE =100;

	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;

		GregorianCalendar calendar = new GregorianCalendar(year, month, day);
		this.birthDay = calendar.getTime();
	}

	public void rasieSalary(double addSalary) {
		double raise=salary*addSalary/100;
		this.salary+=raise;
	}
	public Employee() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return getClass().getName()+"[name="+name+",salary="+salary+",birthday="+birthDay+"]";
	}
}
