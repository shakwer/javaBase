package synchronize;

 class Account {
	String name;
	float amount;
	
	public Account(String name,float amount) {
		this.name=name;
		this.amount=amount;
	}
	
	//¥Ê«Æ
	public void depoist(float amt) {
		amount+=amt;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//»°«Æ
	public void wtihDraw(float amt) {
		amount-=amt;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public float getBlance() {
		return amount;
	}
}


public class AccountOperator implements Runnable{
	private Account account;
	public AccountOperator(Account account) {
		this.account=account;
	}
	
	public void run() {
		synchronized (account) {
			account.depoist(500);
			account.wtihDraw(900);
			System.out.println(Thread.currentThread().getName()+" : "+account.getBlance());
		}
	}
	
	public static void main(String[] args) {
		Account account=new Account("’≈…Ω", 10000.0f);
		AccountOperator accountOperator=new AccountOperator(account);
		
		final int THREAD_NUM=5;
		Thread[]threads=new Thread[THREAD_NUM];
		for(int i=0;i<THREAD_NUM;i++) {
			threads[i]=new Thread(accountOperator,"thread"+i);
			threads[i].start();
		}
	}
}
