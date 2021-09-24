package unit_0;
import java.lang.Math;
import java.util.Scanner;

/**
 * finds prime
 * @author mike stefan
 * @version 09/021
 */
public class A5E1b {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("enter number of primes: ");
		int num_of_prime = 10000;//input.nextInt();
		
		int factor = 0, factor2 = 0, primes = 2, num = 7, num2 = num-2;
		long start_time = System.currentTimeMillis();
		while(primes < num_of_prime) {
			factor = 0;
			factor2 = 0;
			for(int i = 3; i <= Math.sqrt(num) ; i+=2) {
				if(num % i == 0) { 
					factor++; 
					break;
				}
					
			}
			num2 = num-2;
			for(int i = 3; i <= Math.sqrt(num2) ; i+=2) {
				if((num2) % i == 0) {
					factor2++; 
					break;
				}
					
			}
			if(factor == 0) {
				System.out.println(num);
				primes ++;
//				System.out.println(num);
			}
			if(factor2 == 0) {
				System.out.println(num-2);
				primes ++;
			}
			num+=6;
		}
		
		System.out.println(primes + " "+  (System.currentTimeMillis()-start_time));
		
	}
}
