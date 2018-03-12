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
        
        //DigraphAM grafo1 = new DigraphAM(12);
        GraphAlgorithms proff = new GraphAlgorithms(12);
        /*grafo1.addArc(0, 1, 1);
        grafo1.addArc(1, 0, 1);
        grafo1.addArc(1, 3, 1);
        grafo1.addArc(3, 1, 1);
        grafo1.addArc(2, 1, 1);
        grafo1.addArc(1, 2, 1);
        grafo1.addArc(3, 4, 1);
        grafo1.addArc(4, 3, 1);        
        grafo1.addArc(2, 3, 1);
        grafo1.addArc(3, 2, 1);
        System.out.println(" "+proff.BFS(, grafo1).toString());*/
        DigraphAM g = new DigraphAM(12);
        g.addArc(5, 11, 1);
        g.addArc(11, 9, 1);
        g.addArc(11, 10, 1);
        g.addArc(11, 2, 1);
        g.addArc(7, 11, 1);
        g.addArc(7, 8, 1);
        g.addArc(3, 10, 1);
        g.addArc(3, 8, 1);
        g.addArc(8, 9, 1);
        ArrayList<Integer> re = proff.BFS(5, g);
        for(int i = 0; i < re.size(); i++)
        {
            System.out.println(re.get(i));
        
        }
        /*Ejercicios pruebas = new Ejercicios();
        for(int i = 4; i <= 32; i ++)
        {
            System.out.println("tiempo para: "+ i + " :"+ pruebas.tomarTiempo(i));
        }*/
    }
    
}
