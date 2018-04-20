package chapterone;

import java.io.Serializable;

public class Manager  extends Employee implements Serializable{
	private Employee secretory;
	
	public Employee getSecretory() {
		return secretory;
	}

	public void setSecretory(Employee secretory) {
		this.secretory = secretory;
	}

	public Manager(String name, double salary, int year, int month, int day) {
		super(name,salary,year,month,day);
	}
}
