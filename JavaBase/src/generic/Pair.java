package generic;

/**
 * 虚拟机没有泛型，无论何时提供了一个泛型类型，都自动提供了一个相应的原始类型RawType,原始类型就是删去类型参数的泛型类型名，
 * 擦除（erased）类型变量,并替换为限定类型（无限定类型的用Object替换）
 * @author user
 *
 * @param <T>
 */
public class Pair<T> {
	private T first;
	private T second;
	
	public Pair() {
		first=null;
		second=null;
	}
	
	public Pair(T first,T second) {
		this.second=second;
		this.first=first;
	}
	
	public T getFirst() {
		return first;
	}
	
	public T getSecond() {
		return second;
	}
	
	public void setFirst(T newValue) {
		this.first=newValue;
	}
	
	public void setSecond(T newValue) {
		this.second=newValue;
	}
}



class Employee {  
    private String name;  
    private double salary;  
      
    public Employee(String n, double s) {  
        name = n;  
        salary = s;  
    }  
      
    public String getName() {  
        return name;  
    }  
  
    public double getSalary() {  
        return salary;  
    }  
}  


class Manager extends Employee {  
    public Manager(String n, double s) {  
        super(n, s);  
    }  
}  

class President extends Manager {  
    public President(String n, double s) {  
        super(n, s);  
    }  
}  
