/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio4d2;

import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test para probar los metodos implementados en la clase Laboratorio4D2
 * @author Daniel Mesa
 * @author Kevin Parra
 */
public class Laboratorio4D2Test {
    /**
     * Test of agenteViajero method, of class Laboratorio4D2.
     */
    @Test
    public void testAgenteViajero() {
        System.out.println("agenteViajero");
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
        int pos = 0;
        LinkedList<Integer> expResult = new LinkedList<>();
        expResult.add(0);
        expResult.add(3);
        expResult.add(1);
        expResult.add(2);
        LinkedList<Integer> result = Laboratorio4D2.agenteViajero(g, pos);
        assertEquals(expResult, result);
    }
}
