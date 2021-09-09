package unit_0;
/**
 * prints formated price
 * @author mike stefan
 * @version 09/09
 */
public class A2E1 {

	public static void main(String[] args) {
		double item1 = 2.55;
		double item2 = 3.20;
		double item3 = 4.00;
		double total = item1 + item2 + item3;
		
		System.out.format("$%.2f + $%.2f + $%.2f = $%.2f",item1, item2,item3, total);

	}

}
