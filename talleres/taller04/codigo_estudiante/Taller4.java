import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller4 {

    public static ArrayList<Integer> recorrido(Digraph g, int star) {
	int tamaño = g instanceof ArrayList ? g.size() : g.lenght;
 	boolean [] visitados =  new boolean [tamaño];
	ArrayList<Integer> recorridos = new ArrarList<>();
	recorrido(g, star, visitados, recorridos);
    }

    private static void recorrido(Digraph g, int pos, int[] unvisited, ArrayList<Integer> recorridos)
    {
	unvisited[pos] = true;
	recorridos.add(pos);
	ArrayList<Integer> sucesores = g.getSuccessors(pos);
	if(sucesores != null)
	for(Integer sucesor : sucesores)
	    {
		if(!visitados[sucesor])
		    {
			recorridos(g, sucesor, visitados, recorridos);
		    }
		return;
	    }
	
	
    }
    
    /*// recomendacion
    private static int[] removeAt(int k, int a[]) {
	// complete...
    }

    public static int costoMinimo(Digraph g, int inicio, int fin) {
	// complete...
    }

    // recomendacion
    private static void dfs(Digraph g, int v, int[] costo) {
	// complete...
	}*/

    public static void main(String[] args)
    {

	
    }
}
