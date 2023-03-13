package equajava;

import java.util.Locale;

public class EquaJava {
	
	public String equacao(double x1,double x2, double y1, double y2,double si1, double si2, boolean permissao) {
		
		
		Locale.setDefault(Locale.US);
		double[][] determinante = new double[5][5];
		
		/// PRIMEIRO PASSO É MONTAR A TABELA
		
		resetMatriz(x1, y1, si1, x2, y2, si2, determinante);
		
		
		
		// AGORA FAZ A CONTA PARA CALCULAR O VALOR DA DETERMINANTE.
		
		double d = (determinante[0][0] * determinante[1][1]) - (determinante[0][1] * determinante[1][0]);
		
		// MUDANDO A COLUNA DE X PARA O VALOR DA COLUNA DO SEM INCÓGNITA.
		
		mudaColunaX(si1, si2, determinante);
		
		// CALCULA O VALOR DA DETERMINANTE DE X.
		
		double dx = (determinante[0][0] * determinante[1][1]) - (determinante[0][1] * determinante[1][0]);
		
		// AGORA TESTAMOS PARA VER SE É NÚMERO QUEBRADO OU NÃO.
		
		String valorX = AnaliseResult(d, dx,permissao); // VALOR DE X EM STRING!
		
		
		
		
		
		
		/// ACHANDO SEGUNDA INCÓGNITA
		
		resetMatriz(x1, y1, si1, x2, y2, si2, determinante);
		
		// MUDANDO A COLUNA DE Y PARA O VALOR DA COLUNA DO SEM INCÓGNITA.
				
		mudaColunaY(si1, si2, determinante);
		
		// CALCULAMOS A DETERMINANTE DE Y.
				
		double dy = (determinante[0][0] * determinante[1][1]) - (determinante[0][1] * determinante[1][0]);
				
		// AGORA TESTAMOS PARA VER SE É NÚMERO QUEBRADO OU NÃO.
				
		String valorY = AnaliseResult(d, dy,permissao); // VALOR DE X EM STRING!
		
		// RETORNA O RESULTADO DA EQUAÇÃO COM OS VALORES FORMATADOS.
		
		return String.format("S={(%s , %s)}",valorX, valorY); 
	}
	
public String equacao(double x1,double y1, double z1,double si1 ,double x2, double y2, double z2, double si2,double x3,double y3,double z3,double si3, boolean permissao) {
		
		
		double[][] determinante = new double[3][5];
		
		/// PRIMEIRO PASSO É MONTAR A TABELA
		
		resetMatriz(x1, y1, z1,x2, y2, z2,x3, y3, z3,determinante);
		
		

		
		// AGORA FAZ A CONTA PARA CALCULAR O VALOR DA DETERMINANTE.
		
		double d = calcDandIncognita(determinante);
		
		// MUDANDO A COLUNA DE X PARA O VALOR DA COLUNA DO SEM INCÓGNITA.
		
		mudaColunaX(si1, si2,si3, determinante);
		
		// CALCULA O VALOR DA DETERMINANTE DE X.
		
		double dx = calcDandIncognita(determinante);
		
		// AGORA TESTAMOS PARA VER SE É NÚMERO QUEBRADO OU NÃO.
		
		
		
		
		
		String valorX = AnaliseResult(d, dx,permissao); // VALOR DE X EM STRING!
		
		
		/// ACHANDO SEGUNDA INCÓGNITA
		
		resetMatriz(x1, y1, z1,x2, y2, z2,x3, y3, z3,determinante);
		
		// MUDANDO A COLUNA DE Y PARA O VALOR DA COLUNA DO SEM INCÓGNITA.
				
		mudaColunaY(si1, si2,si3, determinante);
		
		// CALCULAMOS A DETERMINANTE DE Y.
				
		double dy = calcDandIncognita(determinante);
				
		// AGORA TESTAMOS PARA VER SE É NÚMERO QUEBRADO OU NÃO.
				
		String valorY = AnaliseResult(d, dy,permissao); // VALOR DE X EM STRING!
		
		// RETORNA O RESULTADO DA EQUAÇÃO COM OS VALORES FORMATADOS.
		
		
		
		/// ACHANDO TERCEIRA INCÓGNITA
		
		resetMatriz(x1, y1, z1,x2, y2, z2, x3, y3, z3, determinante);
				
		// MUDANDO A COLUNA DE Z PARA O VALOR DA COLUNA DO SEM INCÓGNITA.
						
		mudaColunaZ(si1, si2, si3, determinante);
				
		// CALCULAMOS A DETERMINANTE DE Z.
						
		double dz = calcDandIncognita(determinante);
						
		// AGORA TESTAMOS PARA VER SE É NÚMERO QUEBRADO OU NÃO.
						
		String valorZ = AnaliseResult(d, dz,permissao); // VALOR DE X EM STRING!
				
		// RETORNA O RESULTADO DA EQUAÇÃO COM OS VALORES FORMATADOS.
		
		return String.format("S={(%s , %s, %s)}",valorX, valorY, valorZ); 
	}
	
	private String AnaliseResult(double determinante, double numero, boolean permissao) {
		
		

		
		Double resultado = numero/determinante;
		String NumString = resultado.toString(); // converto o resultado da conta em String.
		String numeroTeste = "-1";
		
		// Passando um laço for para encontrar o ponto flutuante.
		
				for(int i = 0; i < NumString.length(); i++) {
					
					if(NumString.charAt(i) == '.') { // ACHOU
						
						for(int j = i; j < i+1;j++) {
							
							numeroTeste =  NumString.substring(i+1);
							
							
							
						}
						break;	
					} 			
				}
				Double numeroInt = Double.parseDouble(numeroTeste);
				if (numeroInt > 0 && permissao == true) {
					return String.format("%.2f", resultado);
					
				} else if(numeroInt == 0) {
					
					return String.format("%.0f", resultado);
				}
				
				
				else {
					
					return String.format("%f/%f", numero,determinante);
				}
				
		
		
		
		
		
	}
	
	
	
	/// FUNÇÃO QUE CRIA A MATRIZ.
	
	private void resetMatriz(double x1, double y1, double si1,double x2, double y2, double si2, double[][] matriz) {
		
		// primeira linha
		
		matriz[0][0] = x1;
		matriz[0][1] = y1;
		matriz[0][2] = si1;
							
		// segunda linha
						
		matriz[1][0] = x2;
		matriz[1][1] = y2;
		matriz[1][2] = si2;
		
	}
	
private void resetMatriz(double x1, double y1,double z1,double x2, double y2,double z2, double x3, double y3,double z3, double[][] matriz) {
		
		// PRIMEIRA LINHA
		
		matriz[0][0] = x1;
		matriz[0][1] = y1;
		matriz[0][2] = z1;
		matriz[0][3] = x1;
		matriz[0][4] = y1;
							
		// SEGUNDA LINHA
						
		matriz[1][0] = x2;
		matriz[1][1] = y2;
		matriz[1][2] = z2;
		matriz[1][3] = x2;
		matriz[1][4] = y2;
		
		// TERCEIRA LINHA
		
		matriz[2][0] = x3;
		matriz[2][1] = y3;
		matriz[2][2] = z3;
		matriz[2][3] = x3;
		matriz[2][4] = y3;
	}
	
	/// FUNÇÕES QUE MUDAM A COLUNA

	private void mudaColunaX(double num1, double num2, double[][] matriz) {
		
		matriz[0][0] = num1;
		matriz[1][0] = num2;
		
	}
	
private void mudaColunaX(double num1, double num2,double num3, double[][] matriz) {
		
		matriz[0][0] = num1;
		matriz[1][0] = num2;
		matriz[2][0] = num3;
		matriz[0][3] = num1;
		matriz[1][3] = num2;
		matriz[2][3] = num3;
		
	}
	
	private void mudaColunaY(double num1, double num2, double[][] matriz) {
		
	matriz[0][1] = num1;
	matriz[1][1] = num2;
		
	}
	
	private void mudaColunaY(double num1, double num2,double num3, double[][] matriz) {
		
		matriz[0][1] = num1;
		matriz[1][1] = num2;
		matriz[2][1] = num3;
		matriz[0][4] = num1;
		matriz[1][4] = num2;
		matriz[2][4] = num3;
			
		}
	
	private void mudaColunaZ(double num1, double num2,double num3, double[][] matriz) {
		
		matriz[0][2] = num1;
		matriz[1][2] = num2;
		matriz[2][2] = num3;
			
		}
	
	private double calcDandIncognita(double[][] matriz) {
		
		
				
		return 	  ((matriz[0][0] * matriz[1][1] * matriz[2][2]) 
				+ (matriz[0][1] * matriz[1][2] * matriz[2][3]) 
				+ (matriz[0][2] * matriz[1][3] * matriz[2][4])) 
				-
				  ((matriz[2][0] * matriz[1][1] * matriz[0][2]) 
				+ (matriz[2][1] * matriz[1][2] * matriz[0][3]) 
				+ (matriz[2][2] * matriz[1][3] * matriz[0][4]));
		
	}
	

}
