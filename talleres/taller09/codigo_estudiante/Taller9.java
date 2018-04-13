
/**
 * Clase en la cual se implementan los metodos del Taller de Clase #9
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
//import java.util.lang.*;
public class Taller9 {

	public static int levenshtein(String a, String b) {

	    //int i, j = 0;
	    int tamA = a.length();
	    int tamB = b.length();
	    int[][] resultados = new int[tamA+1][tamB+1];
	    for(int i = 0; i <= tamA; i++) resultados[i][0] = i;
	    for(int i= 0;i <= tamB; i++ ) resultados[0][i] = i;
		  
	    for(int i = 1; i <= tamA; i++)
		{
		    for(int j = 1; j<= tamB;j++)
			{
			    if(a.charAt(i-1) == b.charAt(j-1))
				{
				    resultados[i][j] = resultados[i-1][j-1];
				}else
				{
				    resultados[i][j] = Math.min(Math.min(resultados[i-1][j]+1, resultados[i][j-1]+1), resultados[i-1][j-1]+1);
				    //System.out.prinltn
				}
			}
		}

	    return resultados[tamA][tamB];
	}

}
