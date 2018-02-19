package taller01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author Mauricio Toro, Mateo Agudelo, Kevin Parra, Daniel Mesa
 */
public class DigraphAL extends Digraph {

    ArrayList<LinkedList<Pair<Integer, Integer>>> graph;

    public DigraphAL(int size) {
        super(size);
        graph = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            graph.add(new LinkedList<Pair<Integer, Integer>>());
        }
    }

    @Override
    public void addArc(int source, int destination, int weight) {
        graph.get(source).add(Pair.makePair(destination, weight));
    }
    

    @Override
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> r = new ArrayList<>();
        for (int j = graph.get(vertex).size()-1; j >= 0; j--) {
            r.add(graph.get(vertex).get(j).first);
        }
        if (r.isEmpty())
            return null;
        return r;
    }

    @Override
    public int getWeight(int source, int destination) {
        if (graph.get(source).size() > 0) {
            for (int i = 0; i < graph.get(source).size(); ++i) {
                if (graph.get(source).get(i).first == destination) {
                    return graph.get(source).get(i).second;
                } 
            }
            return 0;
        }
        return 0;
    }

    private boolean elemenQuestion(int source, int destination) {
        try {
            graph.get(source).get(destination);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void print() {
        System.out.println(graph.toString());
    }

    int sizeLink(int vertex) {
       return graph.get(vertex).size();
    }
}
