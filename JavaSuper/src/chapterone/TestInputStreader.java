package chapterone;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.runtime.Name;

public class TestInputStreader {
	public static void main(String[] args) throws IOException {
		// InputStreamReader in=new InputStreamReader(System.in);
		// InputStreamReader in2=new InputStreamReader(new
		// FileInputStream("D://test.txt"),"ISO8859_5");

		// PrintWriter printWriter=new PrintWriter("D://test.txt");
		PrintWriter printWriter = new PrintWriter(new FileWriter("D:\\test.txt"), true);
		/*
		 * printWriter.print("12321313ok");
		 * printWriter.println(100);//写出器设置为自动冲刷模式，调用println(),缓冲区的所有字符都会被发送到目的地
		 * System.out.println("dddd"+System.getProperty("line.separator")+"aaaa");
		 */
		List<Employee> inEmployees = new ArrayList<>();
		Employee employee1 = new Employee();
		employee1.name = "Jack";
		employee1.salary = 2000.00d;
		employee1.birthDay = new GregorianCalendar(1990, 1, 1).getTime();
		inEmployees.add(employee1) ;
		
		Employee employee2 = new Employee();
		employee2.name = "Green";
		employee2.salary = 2050.00d;
		employee2.birthDay = new GregorianCalendar(1998, 1, 1).getTime();
		inEmployees.add(employee2) ;
		
		writeData(printWriter, inEmployees);

		Scanner in = new Scanner(new File("D:\\test.txt"));
		List<Employee> outEmployees = readData(in);
		for(Employee employee : outEmployees) {
			readeEmployee(employee);
		}
		

	}

	/**
	 * 雇员读出
	 * @param employee
	 */
	public static void readeEmployee(Employee employee) {
		GregorianCalendar calendar=new GregorianCalendar();
		calendar.setTime(employee.birthDay);
		System.out.println(employee.name+"|"+employee.salary+"|"+calendar.get(Calendar.YEAR)+"|"+calendar.get(Calendar.MONTH)+"|"+calendar.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * 写入数据
	 * @param out
	 * @param employees
	 * @throws IOException
	 */
	public static void writeData(PrintWriter out, List<Employee> employees) throws IOException {
		GregorianCalendar calendar = new GregorianCalendar();
	
		for (Employee employee : employees) {
			calendar.setTime(employee.birthDay);
			out.println(employee.name + "|" + employee.salary + "|" + calendar.get(Calendar.YEAR) + "|"
					+ calendar.get(Calendar.MONTH + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH) + "|");
		}

	}
	/**
	 * 读取数据
	 * @param in
	 * @return
	 */
	public static List<Employee> readData(Scanner in) {
		String line;
		
		List<Employee> employees=new ArrayList<>();
		while(in.hasNextLine()) {
			line=in.nextLine();
			String[] tokens = line.split("\\|");
			Employee employee = new Employee();
			employee.name = tokens[0];
			employee.salary = Double.parseDouble(tokens[1]);
			int y = Integer.parseInt(tokens[2]);
			int m = Integer.parseInt(tokens[3]);
			int d = Integer.parseInt(tokens[4]);
			GregorianCalendar calendar = new GregorianCalendar(y, m - 1, d);
			employee.birthDay = calendar.getTime();
			employees.add(employee);
		}
		return employees;
	}
}
