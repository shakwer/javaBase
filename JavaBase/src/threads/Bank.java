package threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 银行账户类
 * 
 * @author user
 *
 */
public class Bank {
	private final double[] accounts;

	public Bank(int n, double initialBanlance) {
		accounts = new double[n];
		// 数组不能这样赋值
		// for(double a:accounts) {
		// a=initialBanlance;
		// }
		
		for (int i = 0; i < n; i++) {
			accounts[i] = initialBanlance;
			bankLock = new ReentrantLock();
			sufficientFunds=bankLock.newCondition();//使用条件对象
		}
	}
     //1、不使用同步锁
//	public void transfer(int from, int to, double amount) {
//
//		if (accounts[from] < amount)
//			return;
//		System.out.println(Thread.currentThread());
//		accounts[from] -= amount;
//		System.out.printf("%10.2f from  %d to %d ", amount, from, to);
//		accounts[to] += amount;
//		System.out.printf("Total balance: %10.2f ", getTotalBalance());
//	}

	// 2、使用synchronize关键字
//	 public synchronized void transfer(int from,int to,double amount) throws InterruptedException{
//	 if(accounts[from]<amount)
//		 wait();
//	 System.out.println(Thread.currentThread());
//	 accounts[from]-=amount;
//	 System.out.printf("%10.2f from %d to %d ",amount,from,to);
//	 accounts[to]+=amount;
//	 System.out.printf("Total balance: %10.2f ",getTotalBalance() );
//	 notifyAll();
//	 }
	
	//3.使用ReentrantLock类
	private Lock bankLock ;

//	public synchronized void transfer(int from, int to, double amount) {
//
//		if (accounts[from] < amount)
//			return;
//		bankLock.lock();
//		try {
//			System.out.println(Thread.currentThread());
//			accounts[from] -= amount;
//			System.out.printf("%10.2f from  %d to %d ", amount, from, to);
//			accounts[to] += amount;
//			System.out.printf("Total balance: %10.2f ", getTotalBalance());
//		} finally {
//			// TODO: handle finally clause
//			bankLock.unlock();
//		}
//		
//	}
	
	//4.结合使用条件对象
	private Condition sufficientFunds;
	public synchronized void transfer(int from, int to, double amount)throws InterruptedException {
		bankLock.lock();
		try {
			while (accounts[from] < amount)
				sufficientFunds.await();;
			System.out.println(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf("%10.2f from  %d to %d ", amount, from, to);
			accounts[to] += amount;
			System.out.printf("Total balance: %10.2f ", getTotalBalance());
			sufficientFunds.signalAll();
		} finally {
			// TODO: handle finally clause
			bankLock.unlock();
		}
		
	}
	public double getTotalBalance() {
		bankLock.lock();
		try {
			double sum = 0;
			for (double a : accounts) {
				sum += a;
			}
			return sum;
		} finally {
			// TODO: handle finally clause
			bankLock.unlock();
		}
		
	}

	public int size() {
		return accounts.length;
	}
}
