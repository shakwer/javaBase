package generic;

/**
 * 只能被实现了comparable的接口类的类才能调用此方法
 * @author user
 *extends 限定；一个类型或通配符可以有多个限定 比如 T extends Comparable & Serializable 限定类型用& 符分割，而逗号用来隔开类型变量
 *java继承，可以根据需求拥有多个接口超类型，但限定中至多有一个类，如果用一个类作为限定，他必须是限定列表中的第一个。 
 */
public class ArrayAlgSec {
	public static <T extends Comparable> T min(T[]a){
		if(a==null||a.length==0)return null;
		T smallest=a[0];
		for(int i=1;i<a.length;i++) {
			if(smallest.compareTo(a[i])>0)smallest=a[i];
			
		}
		return smallest;
		
	}
}
