package unit_0;
import java.util.*;
/**
 * calculates taxes owed based on braket  
 * @author mike stefan
 * @version 09/09
 */
public class A4E2 {

	public static void main(String[] args) {
		//setup constants
		final int STAGES = 27500;
		final double STG1 = 0.17, STG2 = 0.24, STG3 = 0.29;
		//collect user input
		Scanner input = new Scanner(System.in);
		System.out.print("enter income: ");
		double income = input.nextInt(), tax;
		
		//calculate tax owed
		if(income > STAGES) {
			if(income > 2*STAGES) {
				tax = STAGES*STG1 + STAGES*STG2 + (income-2*STAGES)*STG3;
			}
			else tax = STAGES*STG1 + (income-STAGES)*STG2;
		}
		else tax = STG1*income;
		System.out.format("tax: $%.2f\n",tax);
	}

}
