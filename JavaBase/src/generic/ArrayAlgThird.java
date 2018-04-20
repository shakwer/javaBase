package generic;


import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

public class ArrayAlgThird {
	public static <T extends Comparable<?super T>> T min(T[]a) {
		if (a == null || a.length == 0) {  
            return null;  
        }  
        T smallest = a[0];  
        for (int i = 1; i < a.length; i++) {  
            if (smallest.compareTo(a[i]) > 0) {  
                smallest = a[i];  
            }  
        }  
        return smallest;  
	}
	
	
	public static <T> T min(T[]a,Comparator<? super T> c){
		 if (a == null || a.length == 0) {  
	            return null;  
	        }  
	        T smallest = a[0];  
	        for (int i = 1; i < a.length; i++) {  
	            if (c.compare(smallest, a[i]) > 0) {  
	                smallest = a[i];  
	            }  
	        }  
	        return smallest;  
	}

	public static void main(String[] args) {
		GregorianCalendar[] birthdays = {
				new GregorianCalendar(1906, Calendar.DECEMBER, 9),
				new GregorianCalendar(1815, Calendar.DECEMBER, 10),
				new GregorianCalendar(1903, Calendar.DECEMBER, 3),
				new GregorianCalendar(1910, Calendar.JUNE, 22), };

		System.out.println("Min Age = " + ArrayAlgThird.min(birthdays).getTime());
	}
}
