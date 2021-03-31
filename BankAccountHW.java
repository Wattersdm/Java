
/**
 * @author Devin Watters
 * @version 1.0
 */
public class BankAccountHW implements Runnable {
	// Create new account
	private Account acct = new Account();
		
	/**
	 * Account class for account transactions
	 */
	class Account {
		private int balance = 500;

		public int getBalance() {
			return balance;
		}
		public void withdraw(int amount) {
			balance = balance - amount;
		}
		public void deposit(int amount) {
			balance = balance + amount;
		}
	}
	
	/**
	 * makeWithdrawal method to process withdrawals
	 * @param amt amount to be withdrawn
	 */
	private void makeWithdrawal(int amt) {
		if (acct.getBalance() >= amt) {
			System.out.println(Thread.currentThread().getName() + " is going to withdraw");
			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
			}
			acct.withdraw(amt);
			System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
		} else {
			System.out.println("Not enough in account for " + Thread.currentThread().getName() + " to withdraw " + acct.getBalance());
		}
	}
	
	
	/**
	 * makeDeposit method to process deposits
	 * @param amt amount to be deposited
	 */
	private void makeDeposit(int amt) {
		System.out.println(Thread.currentThread().getName() + " is going to deposit");
		try {
			Thread.sleep(100);
		}catch (InterruptedException ex) {			
		}
		acct.deposit(amt);
		System.out.println(Thread.currentThread().getName() + " completes the deposit");
	}
	
	
	/**
	* run method to loop through 5 withdrawals and do one deposit
	*/
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "'s starting balance is: " + acct.getBalance());
		for( int x = 0; x < 5; x++) {
			makeWithdrawal(100);
			if (acct.getBalance() < 0) {
				System.out.println("account is overdrawn!");
			}
		}
		// attempts to deposit
		makeDeposit(200);
	}
		

	/**
	 * main method to create a BankAccountHW object, create 2 threads, set the names, start threads
	 * @param args
	 */
	public static void main(String[] args) {
		// Creates new instance
		BankAccountHW r = new BankAccountHW();		
		Thread one = new Thread(r);
		Thread two = new Thread(r);
		one.setName("Jade");
		two.setName("Rocket");		
		one.start();
		two.start();		
	}
}



