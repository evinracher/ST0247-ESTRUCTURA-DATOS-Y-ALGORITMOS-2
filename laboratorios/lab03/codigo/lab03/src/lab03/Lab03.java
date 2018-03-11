/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab03;

import Graph.*;
import Graph.GraphAlgorithms;
import java.util.ArrayList;

/**
 *
 * @author Kevin Arley Parra
 * @author Daniel Mesa
 */
import java.util.ArrayList;
public class Lab03 {
    
    /**
     * Metodo principal para la ejecucion del programa
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DigraphAM grafo1 = new DigraphAM(12);
        GraphAlgorithms proff = new GraphAlgorithms(grafo1.size());
        grafo1.addArc(5, 11, 1);
        grafo1.addArc(7, 8, 1);
        grafo1.addArc(7, 11, 1);
        grafo1.addArc(3, 8, 1);
        grafo1.addArc(3, 10, 1);
        grafo1.addArc(8, 9, 1);
        grafo1.addArc(11, 2, 1);
        grafo1.addArc(11, 9, 1);
        grafo1.addArc(11, 10, 1);
        System.out.println(" "+proff.BFS(5, grafo1).toString());
    }
    
}
