package volatiles;

/**
 * ʹ��synchronized�ؼ���
 * �ù�������Ķ�д��������һ��
 * ����ͬ���� ���ʹ��������ȥ��ȡ����
 * �˳�ͬ���飬�����ڴ�Թ���������޸Ļ�ͬ����������
 * @author user
 *
 */
public class Task2 implements Runnable{
	boolean running=true;//��������Ŀɼ���
	int i=0;
	
	
	@Override
	public void run() {
		while(this.isRunning()) {
			i++;
		}
	}
	public static void main(String[] args) throws InterruptedException {

		Task2 task=new Task2();
		Thread thread=new Thread(task);
		
		thread.start();
		Thread.sleep(10);
		task.setRunning(false);
		System.out.println(task.i);
		System.out.println("program is stopped");
	}
	
	
	public synchronized boolean isRunning() {
		return running;
	}
	
	public synchronized void setRunning(boolean running) {
		this.running=running;
	}
}
