package generic;

public class PairTest4 {
	public static void main(String[] args) {
		Employee employee1=new Employee("Jack", 1000.0);
		Employee employee2=new Employee("Tom", 1001.0);
		Pair<Employee>pairEmployee=new Pair<>(employee1,employee2);
		printEmployeeBoddies(pairEmployee);
		
		
		
		Manager mgr1 = new Manager("Jack", 10000.99);  
		Manager mgr2 = new Manager("Tom", 10001.01);  
		Pair<Manager> managerPair = new Pair<>(mgr1, mgr2);  
		printEmployeeBoddies(managerPair); 
		
		
		Pair<? super Manager> pair = new Pair<Employee>(null, null);  
		  minMaxSal(new Manager[] {mgr1, mgr2}, pair); 
		  System.out.println(((Manager)pair.getFirst()).getName()+":"+((Manager)pair.getSecond()).getName());
	}
	
	
//	public static void printEmployeeBoddies(Pair<Employee>pair) {
//		System.out.println(pair.getFirst().getName() + "'salary is :" +pair.getFirst().getSalary());  
//		System.out.println(pair.getSecond().getName() + "'salary is :" +pair.getSecond().getSalary());  
//	}
	public static void printEmployeeBoddies(Pair<?extends Employee>pair) {
		
		System.out.println(pair.getFirst().getName() + "'salary is :" +pair.getFirst().getSalary());  
		System.out.println(pair.getSecond().getName() + "'salary is :" +pair.getSecond().getSalary());  
	}
	
	public static void minMaxSal(Manager[] mgrs,  Pair<? super Manager> pair) {  
	    if (mgrs == null || mgrs.length == 0) {  
	        return;  
	    }  
	    
	    pair.setFirst(mgrs[0]);  
	    pair.setSecond(mgrs[1]);  
	    //TODO  
	}  
}
