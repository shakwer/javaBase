package generic;

public class ResultTest {
	public static void main(String[] args) {
		Result<String> result_Str = new Result<String>("1","success"); 
		Result<Integer> result_Inte = new Result<Integer>(0,-1);  
		
		  // 这是对确切的泛型类型使用instanceof是错误的  
//        if(result_Str instanceof Result<String>) {  
//            System.out.println("yes");  
//        }  
		
		 // 只能对原始类型使用instanceof  
        if(result_Str instanceof Result) {  
            System.out.println("yes");  
        }  
        
        // 对于泛型所有的类型检查只产生原始类型  
        if(result_Str.getClass() == result_Inte.getClass()){  
            System.out.println("same Class");  
        }  
	}
}
class Result<T>{
	private T value;
	private T message;
	
	public Result(T value,T message){
		this.message=message;
		this.value=value;
	}
	
}