package generic;

/**
 * ֻ�ܱ�ʵ����comparable�Ľӿ��������ܵ��ô˷���
 * @author user
 *extends �޶���һ�����ͻ�ͨ��������ж���޶� ���� T extends Comparable & Serializable �޶�������& ���ָ�����������������ͱ���
 *java�̳У����Ը�������ӵ�ж���ӿڳ����ͣ����޶���������һ���࣬�����һ������Ϊ�޶������������޶��б��еĵ�һ���� 
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
