package unit_0;
/**
 * prints receipt
 * @author mike stefan
 * @version 09/09
 */
public class A2E3 {

	public static void main(String[] args) {
		double glove = 12.89, toque = 18.99, scarf = 20.0;
		double total = glove+ toque + scarf;
		final double HST = 0.13;
		
		System.out.println("WOSS Gift Shop Receipt");
		System.out.println("----------------------\n");
		System.out.format("glove          $%.2f\n",glove);
		System.out.format("toque          $%.2f\n",toque);
		System.out.format("scarf          $%.2f\n",scarf);
		System.out.println("              -------");
		System.out.format("HST (%.0f%%)      $% .2f\n",(HST*100), total*HST);
		System.out.println("              -------");
		System.out.format("TOTAL          $%.2f\n",total+(total*HST));
		
	}

}