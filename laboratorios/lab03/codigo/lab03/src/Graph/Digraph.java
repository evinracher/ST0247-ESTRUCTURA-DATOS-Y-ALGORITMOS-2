package Graph;

import java.util.ArrayList;

/**
 * Clase abstracta para la implementacion de grafos dirigidos
 * En la pareja (Pair):
 * first = destino (es un vertice)
 * second = peso
 * @author Mauricio Toro, Mateo Agudelo
 */
public abstract class Digraph {
	protected int size;

	public Digraph(int vertices) {
		size = vertices;
	}

	public abstract void addArc(int source, int destination, int weight);

	public abstract ArrayList<Integer> getSuccessors(int vertex);
	
	public abstract int getWeight(int source, int destination);
        
        public abstract int getSize(int curr);
        
        public abstract int getSuc(int curr, int i);

	public int size() {
		return size;
	}
}
