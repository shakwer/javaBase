package volatiles;

/**
 * volatile ��֤�ɼ���
 * ��volatile������д������ˢ�µ�����
 * ��volatile�����Ķ���������е���ֵ
 * @author user
 *
 */
public class Task implements Runnable{
	volatile boolean running=true;//��������Ŀɼ���
	int i=0;
	
	
	@Override
	public void run() {
		while(running) {
			i++;
		}
	}
	
	public static void main(String[] args)throws InterruptedException {
		
		Task task=new Task();
		Thread thread=new Thread(task);
		
		thread.start();
		Thread.sleep(100);
		task.running=false;
		Thread.sleep(1000);
		
		System.out.println(task.i);
		System.out.println("program is stopped");
	}
}
