package unit_0;
/**
 * prints formated price
 * @author mike stefan
 * @version 09/09
 */
public class A2E2 {

	public static void main(String[] args) {
		double item1 = 2.55;
		double item2 = 3.20;
		double item3 = 4.00;
		double total = item1 + item2 + item3;
		
		System.out.format("Item one:     $ %.2f\n",item1);
		System.out.format("Item two:     $ %.2f\n",item2);
		System.out.format("Item three:   $ %.2f\n",item3);
		System.out.println("              -------");
		System.out.format("Total cost:   $ %.2f\n",total);
	}

}
