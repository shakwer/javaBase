package volatiles;

/**
 * volatile 保证可见性
 * 对volatile变量的写会立即刷新到主存
 * 对volatile变量的读会读主存中的新值
 * @author user
 *
 */
public class Task implements Runnable{
	volatile boolean running=true;//共享变量的可见性
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
