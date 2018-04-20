package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * ≤‚ ‘hashMap
 * @author user
 *
 */
public class MapTest {
	public static void main(String[] args) {
		Map<String, Employee> staff=new HashMap<String, Employee>();
		staff.put(UUID.randomUUID().toString(), new Employee("Jams", 1000));
		staff.put(UUID.randomUUID().toString(), new Employee("Jack", 2000));
		staff.put(UUID.randomUUID().toString(), new Employee("Tom", 4000));
		
		System.out.println(staff);
		
		for(Map.Entry<String, Employee> enty : staff.entrySet()) {
			System.out.println("key="+enty.getKey()+" value=(name:"+enty.getValue().getName()+",salary:"+enty.getValue().getSalary()+")");
			enty.setValue(new Employee("Jim", 5000));
		}
		
		for(Map.Entry<String, Employee> enty : staff.entrySet()) {
			System.out.println("key="+enty.getKey()+" value=(name:"+enty.getValue().getName()+",salary:"+enty.getValue().getSalary()+")");
			
		}
//		ArrayList<E>
	}
}
