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
public class EjerciciosTest {

    /**
     * Test of nReinas method, of class Ejercicios.
     */
    @Test
    public void testNReinas() {
        System.out.println("nReinas con 5");
        int n = 5;
        Ejercicios instance = new Ejercicios();
        int[] expResult = {0,2,4,1,3};
        int[] result = instance.nReinas(n);
        assertArrayEquals(expResult, result);
        
        System.out.println("nReinas con 4");
        n = 4;
        int [] expResult2 = {1, 3, 0, 2};
        int[]result2 = instance.nReinas(n);
        assertArrayEquals(expResult2, result2);
        
        System.out.println("nReinas con null");
        n = 2;
        int [] expResult3 = null;
        int[]result3 = instance.nReinas(n);
        assertArrayEquals(expResult3, result3);
        
        System.out.println("nReinas con null");
        n = 3;
        int [] expResult4 = null;
        int[]result4 = instance.nReinas(n);
        assertArrayEquals(expResult4, result4);
    }
}
