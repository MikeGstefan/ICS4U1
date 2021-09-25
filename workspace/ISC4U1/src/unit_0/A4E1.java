package unit_0;
import java.util.*;
/**
 * prints receipt for a restaurant with varying tax rate 
 * @author mike stefan
 * @version 09/09
 */
public class A4E1 {

	public static void main(String[] args) {
//		double item1 = 3.0;
//		double item2 = 1.20;
//		double item3 = 1.00;
//		double price = item1 + item2 + item3;
//		final double HST = 0.13, REDUCED_TAX = 0.05;
//		double tax;
//		if(price <= 4.0)tax =REDUCED_TAX;
//		else tax=HST;
//		
//		System.out.format("Item one:     $ %.2f\n",item1);
//		System.out.format("Item two:     $ %.2f\n",item2);
//		System.out.format("Item three:   $ %.2f\n",item3);
//		System.out.println("              -------");
//		System.out.format("HST (%2.0f%%)     $%5.2f\n",(tax*100), price*tax);
//		System.out.println("              -------");
//		System.out.format("price cost:   $ %.2f\n",price+ (price*tax));
		
		//sets up constants and user input
		System.out.print("Enter total price: ");
		Scanner input = new Scanner(System.in);
		double price = input.nextDouble();
		final double HST = 0.13, REDUCED_TAX = 0.05, THRESHOLD = 4.0;
		
		//calculate tax
		double tax;
		if(price <= THRESHOLD)tax =REDUCED_TAX;
		else tax=HST;
		
		System.out.format("Price:        $%5.2f\n",price);
		System.out.println("              -------");
		System.out.format("HST (%2.0f%%)     $%5.2f\n",(tax*100), price*tax);
		System.out.println("              -------");
		System.out.format("price cost:   $%5.2f\n",price+ (price*tax));
	}

}
