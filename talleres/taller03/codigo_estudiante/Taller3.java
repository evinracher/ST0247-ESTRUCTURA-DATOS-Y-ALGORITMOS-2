//ds
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
	boolean [] visitados = new boolean[g.size()];
	//System.out.println(g.size());
        ArrayList<Integer> list = new ArrayList<>();
	//System.out.println("1");
	boolean resultado = dfs(g, inicio, fin, visitados, list);
	return list;
    }

    // recomendacion
    private static boolean dfs(Digraph g, int nodo, int objetivo, boolean[] visitados, ArrayList<Integer> list) {
	if(nodo == objetivo)
	    {
		list.add(nodo);
		return true;
	    }else
	    {
		if(g.getSuccessors(nodo) != null)
		    {
			ArrayList<Integer> s = g.getSuccessors(nodo);
	    
			//System.out.println("1");
			boolean f = false;
			if(visitados[nodo] == false)
			    {
				//System.out.println(nodo);
				//System.out.println("tamaño"  + s.size());
				visitados[nodo] = true;
				list.add(nodo);
				//System.o1ut.println("tamaño"  + s.size());
			
				for(int i = 0; i < s.size(); i++)
				    {
					nodo = s.get(i);
					//System.out.println("tamaño: " + nodo + " "+ f);
					f = dfs(g, nodo, objetivo, visitados, list);
					
					//System.out.println("tamaño: " + nodo + " "+ f);
					if(f == true)
					    {
						//list.add(nodo);
						return true;
					    }
				    }
		        
			    }else
			    {
				return false;
			    }
	    
			return false;
		    }
	    }
	return false;
    }

    public static void main(String[] args)
    {
	DigraphAM g = new DigraphAM(12);
	g.addArc(3, 8, 1);
	g.addArc(3, 10, 1);
	g.addArc(5, 11, 1);
	g.addArc(7, 8, 1);
	g.addArc(7,11, 1);
	g.addArc(8, 9, 1);
	g.addArc(11,2, 1);
	g.addArc(11,9, 1);
	g.addArc(11, 10, 1);
	//System.out.println("1");
	ArrayList<Integer> list= camino(g, 7, 10);
	for(int i  = 0; i < list.size(); i++)
	    {
		//System.out.println("1");
		System.out.println(list.get(i));
	    }
    }

}

