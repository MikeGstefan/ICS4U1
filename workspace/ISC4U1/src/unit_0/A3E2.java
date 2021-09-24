package unit_0;
import java.util.*;
/**
 * prints receipt
 * @author mike stefan
 * @version 09/09
 */
public class A3E2 {

	public static void main(String[] args) {
		//declare variables
		String item1_name, item2_name, item3_name;
		double item1_price, item2_price, item3_price;
		final double HST = 0.13;
		
		//take user input
		Scanner input = new Scanner(System.in);
		System.out.print("enter name of the first item: ");
		item1_name = input.nextLine();
		System.out.print("enter price of the first item: ");
		item1_price = input.nextDouble();
		input.nextLine();
		System.out.print("enter name of the next item: ");
		item2_name = input.nextLine();
		System.out.print("enter price of the next item: ");
		item2_price = input.nextDouble();
		input.nextLine();
		System.out.print("enter name of the next item: ");
		item3_name = input.nextLine();
		System.out.print("enter price of the next item: ");
		item3_price = input.nextDouble();
		input.nextLine();
		
		//calculate total
		double total = item1_price + item2_price + item3_price;
		
		//formats and outputs data
		System.out.println("WOSS Gift Shop Receipt");
		System.out.println("----------------------\n");
		System.out.format("%-15s$%5.2f\n",item1_name,item1_price);
		System.out.format("%-15s$%5.2f\n",item2_name,item2_price);
		System.out.format("%-15s$%5.2f\n",item3_name,item3_price);
		System.out.println("              -------");
		System.out.format("HST (%.0f%%)      $%5.2f\n",(HST*100), total*HST);
		System.out.println("              -------");
		System.out.format("TOTAL          $%5.2f\n",total+(total*HST));
	
	}

}