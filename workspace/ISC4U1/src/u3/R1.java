package u3;

public class R1 {
	public static int tri(int num) {
		if(num > 1) {
			return num + tri(num-1);
		}
		else {
			return 1;
		}
	}
	
	public static int fib(int num) {
		if( num >2) {
			return fib(num-1) + fib(num-2);
		}
		else {
			return 1;
		}
	}
	
	public static int fact(int num) {
		if( num > 1) {
			System.out.print(num + " X ");
			return num * fact(num-1);
		}
		else {
			System.out.print(num + " = ");
			return 1;
		}
	}
	
	public static String pali(String word) {
		if(word.length() == 1 ) {
			return word;
		}
		else return word.charAt(word.length()-1) + pali(word.substring(0, word.length()-1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(tri(6));
		System.out.println(fib(7));
		System.out.print("5! = ");
		System.out.println( fact(5));
		System.out.println(pali("levels"));

	}

}
