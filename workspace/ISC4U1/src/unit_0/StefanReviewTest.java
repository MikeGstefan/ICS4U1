package unit_0;
import java.util.*;
/**
 * Encodes String
 * @author mike stefan
 * @version 10/07
 */
public class StefanReviewTest {

	public static void main(String[] args) {
		// Constants for letters in ACSII, min max for A-Z SHIFT is the translation for lowercase
		final int MIN = 65, MAX = 90, SHIFT = 32;
		
		//collect string
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a message: ");
		String orig = input.nextLine(), encoded = "";
		
		//start collection of shift amounts
		ArrayList <Integer> shifts = new ArrayList<Integer>();
		System.out.print("Enter shift values: ");
		//loop until -1 is entered, signaling completion
		 do{
			shifts.add(input.nextInt());
		}while(shifts.get(shifts.size()-1) != -1);
		
		 
		// how far many non letters skipped, i - shift offset represents our current place in the shift array
		 int shift_offset = 0;
		//encoding loop
		 for(int i = 0; i < orig.length(); i++) {
			 //is The charater a letter? asking whether its capital variation is within our MIN-MAX range
			 if((int)orig.toUpperCase().charAt(i) >= MIN && (int)orig.toUpperCase().charAt(i) <= MAX) {
				 //will shifting the letter make it  non letter? this handles rollover
				 if(((int)orig.toUpperCase().charAt(i))+ shifts.get((i-shift_offset)%(shifts.size()-1)) > MAX){
					 //case for upper/lower case
					 if((int)orig.charAt(i) <= MAX && (int)orig.charAt(i)>= MIN) {
						 //rolls over an upper case char
						 encoded += (char)(MIN + shifts.get((i-shift_offset)%(shifts.size()-1)) - (MAX+1 - (int)orig.charAt(i)));
					 }
					 else {
						 // rolls over a lower case char
						 encoded += (char)(MIN+SHIFT + shifts.get((i-shift_offset)%(shifts.size()-1)) - (MAX+SHIFT+1 - (int)orig.charAt(i)));
					 }
					 
				 }
				 else {
					 // increase by the shift amount
					 encoded += (char)((int)orig.charAt(i)+ shifts.get((i-shift_offset)%(shifts.size()-1))); 
				 }
				 
			 }
			 // is not a letter, left alone
			 else {
				 encoded +=orig.charAt(i);
				 // how far many non letters skipped, i - shift offset represents our current place in the shift array
				 shift_offset = (shift_offset + 1)%(shifts.size()-1);
			 }
		 }
		 System.out.println("Encoded message: " + encoded);
		 
		 
	}

}
