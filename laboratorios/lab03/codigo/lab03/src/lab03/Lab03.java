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
        
        /*DigraphAM grafo1 = new DigraphAM(12);
        GraphAlgorithms proff = new GraphAlgorithms(grafo1.size());
        grafo1.addArc(0, 1, 1);
        grafo1.addArc(1, 0, 1);
        grafo1.addArc(1, 3, 1);
        grafo1.addArc(3, 1, 1);
        grafo1.addArc(2, 1, 1);
        grafo1.addArc(1, 2, 1);
        grafo1.addArc(3, 4, 1);
        grafo1.addArc(4, 3, 1);        
        grafo1.addArc(2, 3, 1);
        grafo1.addArc(3, 2, 1);
        System.out.println(" "+proff.BFS(0, grafo1).toString());*/
        Ejercicios pruebas = new Ejercicios();
        int[] unaSolucion = pruebas.nReinas(5);
        if(unaSolucion != null)
        {
        for(int i = 0; i < unaSolucion.length; i++ )
        {
            System.out.println(unaSolucion[i]);
        }
        }else
        {
            System.out.println("es null");
            
        }

    }
    
}
