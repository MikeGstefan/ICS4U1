package unit_0;
import java.util.*;
/**
 * accecpts user mailing address and outputs it formatted
 * @author mike stefan
 * @version 09/09
 */

public class A3E1 {

	public static void main(String[] args) {
		String name, address, city;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name: ");
		name = input.nextLine();
		System.out.print("Enter address: ");
		address = input.nextLine();
		System.out.print("Enter city: ");
		city = input.nextLine();
		
		System.out.println("\t\t\t\t\t\t\t\t\tXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.format("\t\t\t\t\t\t\t\t\tX%-25sX\n",name);
		System.out.format("\t\t\t\t\t\t\t\t\tX%-25sX\n",address);
		System.out.format("\t\t\t\t\t\t\t\t\tX%-25sX\n",city);
		System.out.println("\t\t\t\t\t\t\t\t\tXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}

}
