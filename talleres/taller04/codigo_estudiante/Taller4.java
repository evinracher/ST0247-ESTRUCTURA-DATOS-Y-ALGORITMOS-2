import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #4
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller4 {

    public static ArrayList<Integer> recorrido(Digraph g, int star) {
	int tamano = g.size();
 	boolean [] visitados =  new boolean[tamano];
	ArrayList<Integer> recorridos = new ArrayList<>();
	recorrido(g, star, visitados, recorridos);
	return recorridos;
    }

    private static void recorrido(Digraph g, int pos, boolean[] unvisited, ArrayList<Integer> recorridos)
    {
	unvisited[pos] = true;
	recorridos.add(pos);
	ArrayList<Integer> sucesores = g.getSuccessors(pos);
	if(sucesores != null)
	for(Integer sucesor : sucesores)
	    {
		if(!unvisited[sucesor])
		    {
			recorrido(g, sucesor, unvisited, recorridos);
		    }
		//return;
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
	DigraphAM g = new DigraphAM(12);
	g.addArc(5, 11, 1);
	g.addArc(11, 9,  1);
	g.addArc(11, 10, 1);
	g.addArc(11, 2, 1);
	g.addArc(7, 11, 1);
	g.addArc(7, 8, 1);
	g.addArc(3, 10, 1);
	g.addArc(3, 8, 1);
	g.addArc(8, 9 ,1);
	ArrayList p =  recorrido(g, 3);
	for(int i = 0; i < p.size(); i++)
	    {
		System.out.println(p.get(i));
	    }
	
    }
}
