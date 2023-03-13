package equajava;

import java.util.Locale;

public class Equacao {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		EquaJava eqj = new EquaJava();
		
		
		
		double x1 = 1;
		double y1 = 1;
		double z1 = 1;
		double si1 = 18;
		
		double x2 = 2;
		double y2 = 3;
		double z2 = 5;
		double si2 = 46;
		
		double x3 = 2;
		double y3 = -1;
		double z3 = 3;
		double si3 = 10;
		
		boolean numeroQuebrado = false;
		
		
		
		System.out.println(eqj.equacao(x1, x2, y1, y2, si1, si2, numeroQuebrado));
		
		
		
	}
}