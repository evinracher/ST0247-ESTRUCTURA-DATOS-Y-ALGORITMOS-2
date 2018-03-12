/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author danys
 */
public class GraphAlgorithmsTest {

    /**
     * Test of BFS method, of class GraphAlgorithms.
     */
    @Test
    public void testBFS() {
        System.out.println("BFS");
        int s = 5;
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
        GraphAlgorithms instance =  new GraphAlgorithms(12);
        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(5);
        expResult.add(11);
        expResult.add(2);
        expResult.add(9);
        expResult.add(10);
        ArrayList<Integer> result = instance.BFS(s, g);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //Dafail("The test case is a prototype.");
    }  
}
