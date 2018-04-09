import java.util.*;
public class Punto1 {
    
    public static LinkedList<Integer> agenteViajero(Digraph g, int pos)
    {
	boolean [] visited = new boolean[g.size()];
	LinkedList<Integer> camino = new LinkedList<Integer>();
	int t = 0;
	//visited[pos] =  true;
	//camino.add(pos);
	viaje(g, pos, visited, t, camino);
	return camino;
    }

    
    private static void viaje(Digraph g, int pos, boolean[] visited, int tamano, LinkedList<Integer>camino) {
	if(tamano != g.size())
	    { 
		camino.add(pos);
		visited[pos] = true;
		ArrayList<Integer> su =  g.getSuccessors(pos);
		int minus= 20;
		for(int i = 0; i < su.size(); i++)
		    {
			if(visited[su.get(i)] == false && minus > g.getWeight(pos, su.get(i)))
			    {
				minus = g.getWeight(pos, su.get(i));
				pos = su.get(i);
			    }
		    }
		viaje(g, pos, visited,  tamano+1, camino);   
	    }
	
    }

    public static void main(String[] args)
    {
	DigraphAM g = new DigraphAM(4);
	g.addArc(0, 1,7);
	g.addArc(0, 2,15);
	g.addArc(0, 3,6);
	g.addArc(1, 0,2);
	g.addArc(1, 2,7);
	g.addArc(1, 3,3);
	g.addArc(2, 0,9);
	g.addArc(2, 1,6);
	g.addArc(2, 3,12);
	g.addArc(3, 0,10);
	g.addArc(3, 1,4);
	g.addArc(3, 2,8);
	LinkedList<Integer> camino = agenteViajero(g, 0);
	//System.out.println("hola");
	for(Integer i: camino)
	    {
		System.out.println(i);
	    }
    }
}
