package equajava;

import java.util.ArrayList;

public class EquaJava {
	
	public String equacao(int x1,int x2, int y1, int y2,int si1, int si2) {
		
		
		int[][] determinante = new int[2][3];
		
		/// PRIMEIRO PASSO É MONTAR A TABELA
		
		resetMatriz(x1, y1, si1, x2, y2, si2, determinante);
		
		// AGORA FAZ A CONTA PARA CALCULAR O VALOR DA DETERMINANTE.
		
		int d = (determinante[0][0] * determinante[1][1]) - (determinante[0][1] * determinante[1][0]);
		
		// MUDANDO A COLUNA DE X PARA O VALOR DA COLUNA DO SEM INCÓGNITA.
		
		mudaColunaX(si1, si2, determinante);
		
		// CALCULA O VALOR DA DETERMINANTE DE X.
		
		double dx = (determinante[0][0] * determinante[1][1]) - (determinante[0][1] * determinante[1][0]);
		
		// AGORA TESTAMOS PARA VER SE É NÚMERO QUEBRADO OU NÃO.
		
		String valorX = AnaliseResult(d, dx); // VALOR DE X EM STRING!
		
		
		
		
		
		
		/// ACHANDO SEGUNDA INCÓGNITA
		
		resetMatriz(x1, y1, si1, x2, y2, si2, determinante);
		
		// MUDANDO A COLUNA DE Y PARA O VALOR DA COLUNA DO SEM INCÓGNITA.
				
		mudaColunaY(si1, si2, determinante);
		
		// CALCULAMOS A DETERMINANTE DE Y.
				
		double dy = (determinante[0][0] * determinante[1][1]) - (determinante[0][1] * determinante[1][0]);
				
		// AGORA TESTAMOS PARA VER SE É NÚMERO QUEBRADO OU NÃO.
				
		String valorY = AnaliseResult(d, dy); // VALOR DE X EM STRING!
		
		// RETORNA O RESULTADO DA EQUAÇÃO COM OS VALORES FORMATADOS.
		
		return String.format("S={(%s , %s)}",valorX, valorY); 
	}
	
	private String AnaliseResult(double determinante, double numero) {
		
		

		ArrayList<Integer> num = new ArrayList<>();
		
		Double resultado = numero/determinante;
		String NumString = resultado.toString(); // converto o resultado da conta em String.
		
		// Passando um laço for para encontrar o ponto flutuante.
		
				for(int i = 0; i < NumString.length(); i++) {
					
					if(NumString.charAt(i) == '.') { // ACHOU
						
						for(int j = i + 1; j < NumString.length(); j++ ){ // agora passa outro laço para ver quantos números tem após o .
																			// Eu fiz isso, pois como é um double, por padrão pode ser .0 	
							
							num.add(Character.getNumericValue(NumString.charAt(j)));	// aqui ele converte o char na posição j em inteiro e joga pro Array.
						}	
					}
				}
		
		if(num.size() == 1 && num.get(0) == 0) {
			
			return String.format("%.0f", resultado);
	
		}else {
			
			String determinanteString = String.format("%.0f", determinante);
			String dNumString = String.format("%.0f", numero);
			
			return String.format("%s/%s", dNumString,determinanteString);
			
		}
		
		
		
	}
	
	private void resetMatriz(int x1, int y1, int si1,int x2, int y2, int si2, int[][] matriz) {
		
		// primeira linha
		
		matriz[0][0] = x1;
		matriz[0][1] = y1;
		matriz[0][2] = si1;
							
		// segunda linha
						
		matriz[1][0] = x2;
		matriz[1][1] = y2;
		matriz[1][2] = si2;
		
	}
	
	private void mudaColunaX(int num1, int num2, int[][] matriz) {
		
		matriz[0][0] = num1;
		matriz[1][0] = num2;
		
	}
	
	private void mudaColunaY(int num1, int num2, int[][] matriz) {
		
	matriz[0][1] = num1;
	matriz[1][1] = num2;
		
	}


}
