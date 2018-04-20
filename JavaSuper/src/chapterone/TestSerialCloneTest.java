package chapterone;

public class TestSerialCloneTest {
	public static void main(String[] args) {
		Employee harry=new Employee("harry kane",50000,1989,1,1);
		Employee erricson=(Employee)harry.clone();
		
		harry.rasieSalary(10);
		
		System.out.println(harry);
		System.out.println(erricson);
	}
}
