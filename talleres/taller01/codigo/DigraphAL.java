import java.util.ArrayList;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Kevin Parra, Daniel Mesa
 */
public class DigraphAL extends Digraph {
    ArrayList<ArrayList<Pair<Integer, Integer>>> graph;
    
	public DigraphAL(int size) {
	    super(size);
	    System.out.println("TAMAÑO EN DIGRAPHAL: "+ size);
	    graph = new ArrayList<ArrayList<Pair<Integer, Integer>>>(size);
	    for(int i = 0; i < size; ++i){
		graph.add(new ArrayList<Pair<Integer, Integer>>());
	    }
	}

    public void addArc(int source, int destination, int weight) {
	System.out.println("Poniendo en: "+source);
	graph.get(source).add(new Pair(destination, weight));
    }
    
    public ArrayList<Integer> getSuccessors(int vertex) {
	ArrayList<Integer> r = new ArrayList<Integer>();
	for(int j = 0; j < graph.get(vertex).size(); j++){
		r.add(graph.get(vertex).get(j).first);
	    }
	    if(r.size() == 0)
		{
		    return null;
		}
	    return r;
    }
    
    public int getWeight(int source, int destination) {
	System.out.println("Mirando fuente: " + graph.get(source) );
	if(graph.get(source) != null){
	    System.out.println("Mirando Destino: "+ graph.get(source).get(destination));
	    if(graph.get(source).get(destination) != null){
		System.out.println("Proff"+graph.get(source).get(destination).second);
		return 0;
	    }else
		return 1000;
	}
	return 10000;
    }
    
}
