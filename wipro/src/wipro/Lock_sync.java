package wipro;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Lock_sync implements Runnable  {
		private int balance=1000;
		private Lock lock=new ReentrantLock();
		
		public void withdraw(int amount)
		{
			lock.lock();
			try {
				if(balance>=amount)
				{
					System.out.println(Thread.currentThread().getName() + "withdrawing " + amount);
				
				balance-=amount;
				System.out.println("Remaining balance: " +balance);
			}
			
			else
			{
				System.out.println(Thread.currentThread().getName() + " - Insufficient balance");
			}
			}	
			finally{
					lock.unlock();
				}
		}
	@Override
	public void run()
	{
		withdraw(700);
	}
	public static void main(String[] args)
	{
		Lock_sync account= new Lock_sync();
	 
	Thread t1= new Thread(account, "user-1");
	Thread t2= new Thread(account, "user-2");
	 
	t1.start();
	t2.start();
	 
	} 
}
