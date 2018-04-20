package volatiles;

/**
 * 使用synchronized关键字
 * 让共享变量的读写方法保持一致
 * 进入同步块 访问共享变量回去读取主存
 * 退出同步块，本地内存对共享变量的修改会同步到主存中
 * @author user
 *
 */
public class Task2 implements Runnable{
	boolean running=true;//共享变量的可见性
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
