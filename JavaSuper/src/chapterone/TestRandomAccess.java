package chapterone;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class TestRandomAccess {
	public static void main(String[] args) throws IOException {
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Jack", 5000, 1990, 1, 1);
		staff[1] = new Employee("Tom", 5400, 1992, 1, 1);
		staff[1] = new Employee("Green", 6400, 1995, 1, 1);

		try (DataOutputStream out = new DataOutputStream(new FileOutputStream("D://test.txt"))) {
			for (Employee e : staff) {
				writeData(out, e);
			}
		}
		
		
		try(RandomAccessFile in=new RandomAccessFile("D://test.txt", "r")){
			int n=(int)(in.length()/Employee.RECORD_SIZE);
			Employee[]newStaff=new Employee[n];
			
			for (int i = n-1; i >0; i--) {
				newStaff[i]=new Employee();
				in.seek(i*Employee.RECORD_SIZE);
				newStaff[i]=readData(in);
			}
			
			
			for(Employee employee:newStaff) {
				System.out.println(employee);
			}
		}
	}

	public static void writeData(DataOutput out, Employee employee) throws IOException {
		DataIO.writeFixedString(employee.getName(), Employee.NAME_SIZE, out);
		out.writeDouble(employee.getSalary());
		GregorianCalendar calendar = new GregorianCalendar();

		calendar.setTime(employee.birthDay);
		out.writeInt(calendar.get(Calendar.YEAR));
		calendar.get(Calendar.MONTH + 1);
		calendar.get(Calendar.DAY_OF_MONTH);
	}
	
	public static Employee readData(DataInput in)throws IOException {
		String name =DataIO.readFixedString(Employee.NAME_SIZE, in);
		double salary=in.readDouble();
		int y=in.readInt();
		int m=in.readInt();
		int d=in.readInt();
		
		return new Employee(name,salary,y,m-1,d);
	}
}
