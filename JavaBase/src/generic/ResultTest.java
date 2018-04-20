package generic;

public class ResultTest {
	public static void main(String[] args) {
		Result<String> result_Str = new Result<String>("1","success"); 
		Result<Integer> result_Inte = new Result<Integer>(0,-1);  
		
		  // ���Ƕ�ȷ�еķ�������ʹ��instanceof�Ǵ����  
//        if(result_Str instanceof Result<String>) {  
//            System.out.println("yes");  
//        }  
		
		 // ֻ�ܶ�ԭʼ����ʹ��instanceof  
        if(result_Str instanceof Result) {  
            System.out.println("yes");  
        }  
        
        // ���ڷ������е����ͼ��ֻ����ԭʼ����  
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