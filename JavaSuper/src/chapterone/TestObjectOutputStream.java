package chapterone;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestObjectOutputStream {
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		Employee harry=new Employee("harry",50000,1989,1,1);
		Manager carl=new Manager("carl", 100000, 1987, 1, 1);
		carl.setSecretory(harry);
		
		Manager tony=new Manager("tony", 150000, 1980, 1, 1);
		tony.setSecretory(harry);
		
		Employee[]staff=new Employee[3];
		staff[0]=carl;
		staff[1]=harry;
		staff[2]=tony;
		
		try(ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("D:\\\\test2.txt"))){
			out.writeObject(staff);
		}
		
		try(ObjectInputStream in=new ObjectInputStream(new FileInputStream("D:\\\\test2.txt"))){
			Employee[]newStaff=(Employee[])in.readObject();
			
			for(Employee e:staff) {
				System.out.println(e);
			}
		}
		
		
	}
	
	public static void writeData(ObjectOutputStream out,Employee employee) {
		try {
			out.writeObject(employee);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public static Employee readData(ObjectInputStream in) throws IOException, ClassNotFoundException{
		return (Employee)in.readObject();
	}
}
