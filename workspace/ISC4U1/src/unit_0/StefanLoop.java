package unit_0;
import java.util.*;
/**
 * creats payment schedule for loans
 * @author mike stefan
 * @version 09/24
 */
public class StefanLoop {

	public static void main(String[] args) {
		//variable declarations
		final double MAX_PRINC = 1000000.0;
		double princ = 5000.0, interest = 0.06, pay =  300.0, paid;
		int month = 1;
		Scanner input = new Scanner(System.in);
		boolean data_valid = false;
		
		//validate the principal
		while(!data_valid) {
			System.out.print("Enter your principal: ");
			princ = input.nextDouble();
			if( princ > MAX_PRINC)
				System.out.println("Invalid principal, please try again");
			else if( princ <= 0)
				System.out.println("Invalid principal, please try again");
			else 
				data_valid = true;
		}
		
		//validate the interest rate
		data_valid = false;
		while(!data_valid) {
			System.out.print("Enter the interest rate of your loan (%):");
			interest = input.nextDouble()/100;
			if( interest < 0)
				System.out.println("Invalid interest, please try again");
			else 
				data_valid = true;
		}
		
		//validate pay rate
		data_valid = false;
		while(!data_valid) {
			System.out.print("Enter payment per month:");
			pay = input.nextDouble();
			if( pay - (princ*interest/12) <= 0 )
				System.out.println("Not enough monthly payment, please try again");
			else 
				data_valid = true;
		}
		
		
		//creates and outputs schedule
		System.out.println("Month \t Initial Amount \tInterest \tPrincipal Paid \tAmount Remaining");
		while(princ > 0) {
			paid = pay - (princ*interest/12);
			if( (princ - paid) <0)
				paid = princ ;
			
			System.out.format("%2d \t $%9.2f\t\t$%6.2f\t\t$%7.2f\t$%9.2f\n", month, princ, (princ*interest/12), paid, princ - paid);
			princ -= paid;
			month++;
		}

	}

}
