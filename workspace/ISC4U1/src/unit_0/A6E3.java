package unit_0;

/**
 * removes vowles froma string
 * @author mike stefan
 * @version 09/021
 */
public class A6E3 { 
	public static void main(String[] args) {
		final String FILE = "D:\\Documents\\School\\ICS4U1";
		String sentance = "The Quick Brown Fox Jumps Over The Lazy Dog", vowels = "AEIOU", product ="";
		boolean clear = false;
		for(int i = 0; i < sentance.length(); i++) {
			clear = true;
			for(int j = 0; j < vowels.length(); j++) {
				if(sentance.toUpperCase().charAt(i) == vowels.charAt(j)) {
					System.out.println(sentance.toUpperCase().charAt(i) + " " + vowels.charAt(j));
					clear = false;
				}
				
			}
			if(clear)product +=sentance.charAt(i);
		}
		System.out.print(product);
	}
}
