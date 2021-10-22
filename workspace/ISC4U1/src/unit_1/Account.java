package unit_1;
/**
 * Manages account
 * @author mike Stefan
 *@version 10/20
 */
public class Account {
	private double balance =0.0;
	private int accountNum;
	/**
	 * Constructor
	 * @param acctNum users bank account number
	 */
	public Account(int acctNum) {
		this.accountNum =acctNum;
	}
	/**
	 * Deposits money into account
	 * @param amount how muh to deposite
	 */
	public void deposit(double amount) {
		if(amount > 0.0) {
			this.balance+=amount;
		}
		else {
			System.out.println("Invalid deposit amount");
		}
	}
	/**
	 * Withdraws money from account
	 * @param amount how much to withdraw
	 */
	public void withdraw(double amount) {
		if(amount > this.balance) {
			System.out.println("Insufficent funds");
		}
		else if(amount < 0){
			System.out.println("Invalid withdraw amount");
		}
		else{
			this.balance -= amount;
		}
	}
	/**
	 * returns current balance
	 * @return current balance
	 */
	public double getBalance() {
		return balance;
	}
	
}
