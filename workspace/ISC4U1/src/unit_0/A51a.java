package unit_0;
/**
 * finds factors
 * @author mike stefan
 * @version 09/021
 */
public class A51a {
	public static void main(String[] args) {
		int num = 106;
		System.out.println("number\t format");
		System.out.format( "%-6d \t",num);
		for(int i = 1; i <= num ; i++) {
			if(num % i == 0)System.out.print(i + "\t");
		}
	}
}
