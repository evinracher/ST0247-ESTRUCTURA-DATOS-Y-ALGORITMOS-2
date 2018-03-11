/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Kevin Arley Parra
 * @author Daniel Mesa
 */
public class GraphAlgorithms {

    //Variables
    int maxn;
    int size;
    
    public GraphAlgorithms(int size){
        init(size);
    }
    public int moreEdges(Digraph d) {
        int mayor = 0;
        for (int i = 1; i < d.size(); ++i) {
            ArrayList<Integer> s = d.getSuccessors(i);
            if (s.size() > d.getSuccessors(mayor).size()) {
                mayor = s.size();
            }
        }
        return mayor;
    }

    /**
     * Metodo que realiza un recorrido BFS y devuelve un ArrayList con los
     * vertices en orden de recorrido
     *
     * @param s vertice fuente desde donde se hará el recorrido
     * @param size Tamaño del grafo
     * @param g Grafo que se va a procesar
     * @return Arreglo con los vertices en orden de recorrido
     */
    public ArrayList<Integer> BFS(int s, Digraph g) {
        ArrayList<Integer> res = new ArrayList<>();
        int d[] = new int[maxn];
        for (int i = 0; i < size; ++i) {
            d[i] = -1;
        }

        Queue<Integer> q = new LinkedList();
        q.add(s);
        res.add(s);
        d[s] = 1;
        while (q.size() > 0) {
            int curr = q.poll();
            for (int i = 0; i < g.getSize(curr); ++i) {
                int next = g.getSuc(curr, i);
                if(next == -1){
                }else if (d[next] == -1) {
                    d[next] = d[curr] + 1;
                    res.add(next);
                    q.add(next);
                }
            }
        }
        return res;
    }

    /**
     * Metodo para inicializar la componentes
     *
     * @param size
     *
     */
    public void init(int size) {
        maxn = size + 10;
        this.size = size;
    }

}
