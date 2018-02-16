import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #3
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller3 {

	
    private static boolean puedoPonerReina(int[] tablero) {
	for(int i = 0; i < tablero.length; i++)
	    for(int j = i+1; j < tablero.length; j++)
		if(tablero[i] == tablero[j] || Math.abs(tablero[i]-tablero[j]) == Math.abs(i-j))
		    return true;
	return false;
    }
	
    public static int nReinas(int n) {
	int resultado = 0;
	int [] tablero = new int[n];
	ArrayList<int []> num =  new ArrayList<>();
	num = nReinas( 0, tablero, num);
	/*for(int i = 0; i < num.size(); i++)
	  {
	      resultado = resultado + num.get(i);
		
	      }*/
	return num.size();
    }
	
    private static ArrayList<int[]> nReinas(int n, int[] tablero, ArrayList<int []> num) {
	if(n == tablero.length)
	    {
		if(!puedoPonerReina(tablero))
		    {
			imprimirTablero(tablero);
			num.add(tablero);
		    }
	    }else
	    {
		for(int i = 0; i < tablero.length; i++)
		    {
			tablero[n] = i;
			nReinas(n+1, tablero, num);

			
		    }
	    }

	return num;
    }
	
    public static void imprimirTablero(int[] tablero) {
	int n = tablero.length;
	System.out.print("    ");
	for (int i = 0; i < n; ++i)
	    {
		System.out.print(i + " ");
	    }
	System.out.println("\n");
	for (int i = 0; i < n; ++i) {
	    System.out.print(i + "   ");
	    for (int j = 0; j < n; ++j)
		{
		    System.out.print((tablero[i] == j ? "Q" : "#") + " ");
		}
	    System.out.println();
	}
	System.out.println();
    }
	
    public static ArrayList<Integer> camino(Digraph g, int inicio, int fin) {
	
    }

    // recomendacion
    private static boolean dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {
	
    }

    public static void main(String[] args)
    {
	System.out.println(nReinas(4));
    }

}

