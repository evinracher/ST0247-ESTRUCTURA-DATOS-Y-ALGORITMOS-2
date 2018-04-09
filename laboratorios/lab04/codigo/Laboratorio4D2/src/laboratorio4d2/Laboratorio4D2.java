/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4d2;

import java.util.*;

/**
 * Esta clase implementa el algoritmo del agente viajero el cual recorreo un grafo, yendo
 * atodos los nodos y buscando el menor peso posible
 * @author Daniel Mesa
 * @author Kevin Parra
 */
public class Laboratorio4D2 {

    /**
     * Metodo principal para hacer la llamada recursiva al auxiliar crea todos los elementos necesarios
     * @param g grafo a recorrer
     * @param pos posicion inicial
     * @return el camino en una lista enlazada recorriendo todos desde un inicial y volviendo a el
     *              con el menor peso posible
     */
    public static LinkedList<Integer> agenteViajero(Digraph g, int pos) {
        boolean[] visited = new boolean[g.size()];
        LinkedList<Integer> camino = new LinkedList<Integer>();
        int t = 0;
        //visited[pos] =  true;
        //camino.add(pos);
        viaje(g, pos, visited, t, camino);
        return camino;
    }
    
    /**
     * este es el metodo principal hace la recursion y guarda el camino en la lista teniendo en cuenta siempre de no repetir
     * nodos visitados
     * @param g grafo a recorrer
     * @param pos posicion actual o donde estoy, es decir desde la cual me tengo que desplazar a otro nodo
     * @param visited arreglo que indica cuales ya fueron visitado de tipo boolean
     * @param tamano el tamaño del grafo, cuando este llega al tamaño del grafo ya se debio de llegar al nodo donde inicie
     * @param camino lista enlazada pasada por referencia para guardar el camino menos pesado posible
     */

    private static void viaje(Digraph g, int pos, boolean[] visited, int tamano, LinkedList<Integer> camino) {
        if (tamano != g.size()) {
            camino.add(pos);
            visited[pos] = true;
            ArrayList<Integer> su = g.getSuccessors(pos);
            int minus = 20;
            for (int i = 0; i < su.size(); i++) {
                if (visited[su.get(i)] == false && minus > g.getWeight(pos, su.get(i))) {
                    minus = g.getWeight(pos, su.get(i));
                    pos = su.get(i);
                }
            }
            viaje(g, pos, visited, tamano + 1, camino);
        }

    }

    /**
     * Metodo prinpipal que ejecuta y prueba los metodos contenidos en esta clase
     * @param args 
     */
    public static void main(String[] args) {
        DigraphAM g = new DigraphAM(4);
        g.addArc(0, 1, 7);
        g.addArc(0, 2, 15);
        g.addArc(0, 3, 6);
        g.addArc(1, 0, 2);
        g.addArc(1, 2, 7);
        g.addArc(1, 3, 3);
        g.addArc(2, 0, 9);
        g.addArc(2, 1, 6);
        g.addArc(2, 3, 12);
        g.addArc(3, 0, 10);
        g.addArc(3, 1, 4);
        g.addArc(3, 2, 8);
        LinkedList<Integer> camino = agenteViajero(g, 0);
        //System.out.println("hola");
        for (Integer i : camino) {
            System.out.println(i);
        }
    }

}
