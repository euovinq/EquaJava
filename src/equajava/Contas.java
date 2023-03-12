package equajava;

import java.util.ArrayList;

public class Contas {
	
	
	
	
	
	public void MontarTabelaDupla(int[][] array, int x1, int y1, int num1SemIncognita, int x2, int y2, int num2SemIncognita) {
		
		// primeira linha
		
				array[0][0] = x1;
				array[0][1] = y1;
				array[0][2] = num1SemIncognita;
				
				
				// segunda linha
				
				array[1][0] = x2;
				array[1][1] = y2;
				array[1][2] = num2SemIncognita;
	}
	
	
	
	//////// CALCULAR DETERMINANTE
	
	public double CalcularDeterminante(int[][] array) {
		
		int d = (array[0][0] * array[1][1]) - (array[0][1] * array[1][0]);
		
		return d;
		
	}
	
	/////// CALCULAR X
	
	public double CalcX(int[][] array) {
		
		array[0][0] = array[0][2];
		array[1][0] = array[1][2];
		
		double Dx = (array[0][0] * array[1][1]) - (array[0][1] * array[1][0]);
		
		return Dx;
		
		
		
		
	}
	
	////// VALIDA RESULTADO DA DIVISÃO PELO DETERMINANTE E VE SE VAI DAR NÚMERO QUEBRADO
	
	public String AnaliseResult(double determinante, double dx) {

		ArrayList<Integer> num = new ArrayList<>();
		
		double resultado = dx/determinante;
		
		if(num.size() == 1 && num.get(0) == 0) {
			
			return Double.toString(resultado);
	
		}else {
			
			String determinanteString = Double.toString(determinante);
			String dxString = Double.toString(dx);
			
			return String.format("%s/%s", dxString,determinanteString);
			
		}
		
		
		
	}
	
	
}


