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
    Digraph g;
    colors[] color;

    /**
     * Metodo para inicializar la componentes
     *
     * @param u Digraph que sera util para las implemetaciones de DFS
     *
     */
    public GraphAlgorithms(Digraph u) {
        maxn = u.size() + 10;
        this.size = u.size();
        color = new colors[maxn];
        g = u;
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

    public enum colors {
        white, gray, black
    };

    public void DFS(int u) {
        color[u] = colors.gray;
        for (int i = 0; i < size; ++i) {
            int v = g.getSuc(u, i);
            if (v != -1) {
                if (color[v] == colors.white) {
                    DFS(v);
                }
            }

        }
        color[u] = colors.black;
    }

    public void call_DFS(int n) {
        for (int i = 0; i < n; ++i) {
            color[i] = colors.white;
        }
        for (int i = 0; i < n; ++i) {
            if (color[i] == colors.white) {
                DFS(i);
            }
        }
    }

    /**
     * 1.5: version modificada del DFS que verifica si hay un ciclo. El ciclo se
     * da si en cualquier momento se vuelve a un vertice marcado con gris
     *
     * @param n numero de vertices
     * @return true si hay ciclo, false si para ese recorrido no hay ciclo
     *
     */
    public boolean Ciclos(int n) {
        boolean r = false;
        for (int i = 0; i < n; ++i) {
            color[i] = colors.white;
        }
        for (int i = 0; i < n; ++i) {
            if (color[i] == colors.white) {
                if (DFSC(i)) {
                    return true;
                }
            }
        }
        return r;
    }

    public boolean DFSC(int u) {
        color[u] = colors.gray;
        for (int i = 0; i < size; ++i) {
            int v = g.getSuc(u, i);
            if (v != -1) {
                if (color[v] == colors.white) {
                    if (DFSC(v)) {
                        return true;
                    }
                }
                if (color[v] == colors.gray) {
                    return true;
                }
            }
        }
        color[u] = colors.black;
        return false;
    }

    /**
     * 2.1: version modificada del DFS para el camino más corto desde el vertice
     * 1 (inicial) hasta el n (final)
     * 
     * 1.6: camino más corto entre dos vertices.
     *
     * @param n numero de vertices
     * @param fin será -1 si es hasta el vertice n
     * @return true si hay ciclo, false si para ese recorrido no hay ciclo
     *
     */
    public int caminos(int n, int fin) {
        if(fin == -1)
            fin = g.size();
        ArrayList<Integer> suma = new ArrayList<>();
        int start = 0;
        ArrayList<Integer> camino = new ArrayList<>();
        camino.add(start);
        for (int i = 0; i < n; ++i) {
            color[i] = colors.white;
        }
        for (int i = start; i < n; ++i) {
            if (color[i] == colors.white) {
                DFSCami(i, suma, camino, fin);
            }
        }
        
        System.out.println(" "+ camino.toString());
        int sumaMin = 0;
        for(int i = 0; i < suma.size();++i){
            sumaMin+= suma.get(i);
        }
        return sumaMin;
    }

    public void DFSCami(int u, ArrayList<Integer> suma, ArrayList<Integer> camino, int finish) {
        color[u] = colors.gray;
        for (int i = 0; i < size; ++i) {
            int v = g.getSuc(u, i);
            if (v != -1) {
                if (color[v] == colors.white) {
                    suma.add(g.getWeight(u, v));
                    camino.add(v);
                    DFSCami(v, suma, camino, finish);
                }
                //Hasta el vertice n
                if (v == finish){
                    break;
                }
            }
        }
        color[u] = colors.black;
        
    }

    /**
     * Metodo que realiza un recorrido BFS y devuelve un ArrayList con los
     * vertices en orden de recorrido
     *
     * @param s vertice fuente desde donde se hará el recorrido
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
                if (next == -1) {
                } else if (d[next] == -1) {
                    d[next] = d[curr] + 1;
                    res.add(next);
                    q.add(next);
                }
            }
        }
        return res;
    }

}
