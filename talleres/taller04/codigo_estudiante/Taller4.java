import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

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

    public static boolean camino(Digraph g, int star, int finish) {
	int tamano = g.size();
 	boolean [] visitados =  new boolean[tamano];
	ArrayList<Integer> recorridos = new ArrayList<>();
	camino(g, star, visitados, recorridos);
	return recorridos.contains(finish);
    }

    private static void camino(Digraph g, int star, boolean[] unvisited, ArrayList<Integer> recorridos)
    {
	unvisited[star] = true;
	recorridos.add(star);
	ArrayList<Integer> sucesores = g.getSuccessors(star);
	if(sucesores != null)
	for(Integer sucesor : sucesores)
	    {
		if(!unvisited[sucesor])
		    {
			camino(g, sucesor,unvisited, recorridos);
		    }
		//return;
	    }
	
	
    }


    public static ArrayList<Integer> bfs(Digraph g, int star)
    {
	ArrayList<Integer> result = new ArrayList<>();
	boolean [] visitados = new boolean[g.size()];
	Queue<Integer> vecinos = new LinkedList<>();
	result.add(star);
	vecinos.add(star);
	while(!vecinos.isEmpty())
	    {
		int v = vecinos.poll();
		ArrayList<Integer> success = g.getSuccessors(v);
		if(success != null)
		for(int i = 0; i < success.size(); i++)
		    {
			vecinos.add(success.get(i));
			//result.add(success.get(i));
			if(!visitados[success.get(i)])
			    {
				result.add(success.get(i));
			    }
			visitados[success.get(i)] = true;
		    }
		
	    }

	return result;
    }


    public static boolean bfsCamino(Digraph g, int star, int finish)
    {
	ArrayList<Integer> result = new ArrayList<>();
	boolean [] visitados = new boolean[g.size()];
	Queue<Integer> vecinos = new LinkedList<>();
	result.add(star);
	vecinos.add(star);
	while(!vecinos.isEmpty())
	    {
		int v = vecinos.poll();
		ArrayList<Integer> success = g.getSuccessors(v);
		if(success != null)
		for(int i = 0; i < success.size(); i++)
		    {
			vecinos.add(success.get(i));
			//result.add(success.get(i));
			if(!visitados[success.get(i)])
			    {
				result.add(success.get(i));
			    }
			visitados[success.get(i)] = true;
		    }
		
	    }

	return result.contains(finish);
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
	/*ArrayList p =  bfs(g, 7);
	for(int i = 0; i < p.size(); i++)
	    {
		System.out.println(p.get(i));
	    }*/
	System.out.println(camino(g, 7, 10));
	System.out.println(camino(g, 7, 3));
	System.out.println(bfsCamino(g, 7, 10));
	System.out.println(bfsCamino(g, 7, 3));
    }
}
