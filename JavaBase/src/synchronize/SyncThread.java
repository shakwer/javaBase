package synchronize;

public class SyncThread implements Runnable{
	private static int count;
	
	
	public SyncThread() {
		count=0;
	}
	
	public void run() {
		synchronized(this) {
			for(int i=0;i<5;i++) {
				try {
					System.out.println(Thread.currentThread().getName()+" : "+(count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public int getCount() {
		return count;
	}
	
	
	
	
	public static void main(String[] args) {
		SyncThread syncThread=new SyncThread();
		//两个线程竞争同一个对象资源syncThread 
//		Thread thread1=new Thread(syncThread,"SyncThread1");
//		Thread thread2=new Thread(syncThread,"SyncThread2");
		
		//因为synchronized只锁定对象，每个对象只有一个锁（lock）与之相关联
		//两个线程同时执行
		Thread thread1=new Thread(new SyncThread(),"SyncThread1");
		Thread thread2=new Thread(new SyncThread(),"SyncThread2");
		
		thread1.start();
		thread2.start();
	}
}
