package unit_1;
/**
 *mimics bank 
 * @author mike stefan
 * @version 00/20
 */
public class Bank {

	public static void main(String[] args) {
		Account test = new Account(1123241);
		test.deposit(324.34);
		System.out.println(test.getBalance());
		test.withdraw(34.34);
		System.out.println(test.getBalance());

	}

}
