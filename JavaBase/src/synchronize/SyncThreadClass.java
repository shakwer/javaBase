package synchronize;

public class SyncThreadClass implements Runnable {
	private static int count;

	public SyncThreadClass() {
		count = 0;
	}

	public static void method() {
		synchronized (SyncThreadClass.class) {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println(Thread.currentThread().getName() + ":" + (count++));
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void run() {
		method();
	}
	
	public static void main(String[] args) {
		 SyncThreadStatic syncThread1 = new SyncThreadStatic();
		 SyncThreadStatic syncThread2 = new SyncThreadStatic();
		 Thread thread1 = new Thread(syncThread1, "SyncThread1");
		 Thread thread2 = new Thread(syncThread2, "SyncThread2");
		 thread1.start();
		 thread2.start();
	}
}
