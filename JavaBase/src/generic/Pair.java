package generic;

/**
 * �����û�з��ͣ����ۺ�ʱ�ṩ��һ���������ͣ����Զ��ṩ��һ����Ӧ��ԭʼ����RawType,ԭʼ���;���ɾȥ���Ͳ����ķ�����������
 * ������erased�����ͱ���,���滻Ϊ�޶����ͣ����޶����͵���Object�滻��
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
