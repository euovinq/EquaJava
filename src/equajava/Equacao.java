package equajava;

import java.util.Locale;

public class Equacao {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		EquaJava eqj = new EquaJava();
		
		
		
		double x1 = 1;
		double y1 = 1;
		double z1 = 1;
		double si1 = 6;
		
		double x2 = 1;
		double y2 = 2;
		double z2 = 2;
		double si2 = 9;
		
		double x3 = 2;
		double y3 = 1;
		double z3 = 3;
		double si3 = 11;
		
		boolean numeroQuebrado = false;
		
		
		
		System.out.println(eqj.equacao(3,2,6,2,3,5,numeroQuebrado));
		
		
		
	}
}