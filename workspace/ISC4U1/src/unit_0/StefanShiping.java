package unit_0;
import java.util.*;
/**
 * calculates price of shipping a package of passed weight
 * @author mike stefan
 * @version 09/023
 */
public class StefanShiping {

	public static void main(String[] args) {
		//setup cost constants
		final double cost1 = 3.50, cost2 = 5.0, cost3 = 6.50, cost_rate = 0.75;
		final double weight1 = 2.0, weight2 = 4.5;
		
		//collect user input
		Scanner input = new Scanner(System.in);
		System.out.print("Enter package weight (in kg) : ");
		double weight = input.nextDouble(), price = 0;
		
		
		//validate it
		if(weight <= 0)System.out.println("Invalid weight, please try again");
		else {
			//find which bracket the weight goes in, solves for price
			if(weight <= weight1)price = cost1;
			else if(weight <= weight2)price = cost2;
			else {
				price = cost3;
				price += (weight - weight2)*cost_rate;
			}
			//prints formated final string
			System.out.format("The cost of mailing a %.1fkg package is $%.2f",weight, price);
		}
	}

}
