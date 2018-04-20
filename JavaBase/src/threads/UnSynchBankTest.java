package threads;

import java.util.concurrent.locks.ReentrantLock;

/**
 * //不同步操作测试类
 * @author user
 *
 */

public class UnSynchBankTest {
	public static final int NACCOUNTS=100;
	public static final double INITIAL_BLANCE=100;
	
	public static void main(String[] args) {
		Bank b=new Bank(NACCOUNTS, INITIAL_BLANCE);
		int i;
		for(i=0;i<NACCOUNTS;i++) {
			TransferRunnable r=new TransferRunnable(b, i, INITIAL_BLANCE);
			Thread thread=new Thread(r);
			thread.start();
			
		}
	
	}
}
