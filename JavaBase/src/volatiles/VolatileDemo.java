package volatiles;

public class VolatileDemo implements Runnable {
	 int i=0;
	public  void run() {
		for (int j = 0; j <1000; j++) {
			i++;
		}
	}
	
	public static void main(String[] args)throws InterruptedException {
		VolatileDemo task=new VolatileDemo();
		Thread t1=new Thread(task);
		Thread t2=new Thread(task);
		
		Thread t3=new Thread(task);
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		System.out.println(task.i);
	}
}
