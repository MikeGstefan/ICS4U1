package unit_0;

public class StefanLoop {

	public static void main(String[] args) {
		double princ = 5000.0, interest = 0.06, pay =  300.0, paid;
		int month = 1;
		// princ not too big
		//prince >0 
		// intreset 0<i<1
		//pay >0
		while(princ > 0) {
			paid = pay - (princ*interest/12);
			if( (princ - paid) <0)paid = princ;
			System.out.format("%5d \t $%9.2f\t$%9.2f\t$%9.2f\t$%9.2f\n", month, princ, (princ*interest/12), paid, princ - paid);
			princ -= paid;
			month++;
		}

	}

}
