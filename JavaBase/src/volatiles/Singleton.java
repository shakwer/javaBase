package volatiles;

/**
 * �������ģʽ�����������������instanceΪ�գ��������ֻ��һ���߳̽���ͬ����
��ɶ���ĳ�ʼ����Ȼ��instance��Ϊ�գ���ô�����������̻߳�ȡinstance�����ü�����
�Ӷ����������ܡ�
�������ǸղŽ��˶���ֵ����������ܻ����������
����ǰ�̵߳Ĳ���4ִ�е�һ�룬�����߳��������ִ�е�����1��instance�Ѿ���Ϊnull��
��˽����ȡ��һ��û�г�ʼ����ɵĶ���
�������instance��volatile�����Σ�����ȫ��һ���ˣ���instance��д�����������һ��ԭ��
������û�г�ʼ���꣬�Ͳ��ᱻˢ�µ�������
 * @author user
 *
 */
public class Singleton {
	private static Singleton instance;
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(instance==null) {
			synchronized (Singleton.class) {
				if(instance==null) {
					instance=new Singleton();
				}
			}
		}
		return instance;
	}
}
