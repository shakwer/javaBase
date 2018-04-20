package exception;

import java.util.Scanner;

public class StackTraceTest {
	public static int factorial(int n) {
		System.out.println("factorial("+n+"):");
		Throwable t=new Throwable();
		StackTraceElement[]frames=t.getStackTrace();
		for (StackTraceElement f : frames) {
			System.out.println(f);
			System.out.println(f.getFileName());
			System.out.println(f.getClassName());
			System.out.println(f.getMethodName());
			System.out.println(f.isNativeMethod());
//			System.out.println(f.toString());
			
		}
		int r;
		if(n<=1)r=1;
		else {
			r=n*factorial(n-1);
		}
		System.out.println("return "+r);
		return r;
	}
	
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.println("Enter n:");
		int n=in.nextInt();
		factorial(n);
	}
}
