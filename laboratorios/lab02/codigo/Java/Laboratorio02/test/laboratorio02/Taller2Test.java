/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio02;

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
public class Taller2Test {

    /**
     * Test of reinas method, of class Taller2.
     */
    @Test
    public void testReinas() {
        System.out.println("reinas");
        int numero = 5;
        int expResult = 10;
        int result = Taller2.reinas(numero);
        assertEquals(expResult, result);
        
        System.out.println("reinas 2");
        numero = 6;
        expResult = 4;
        result = Taller2.reinas(numero);
        assertEquals(expResult, result);
        
        System.out.println("reinas 2");
        numero = 1;
        expResult = 1;
        result = Taller2.reinas(numero);
        assertEquals(expResult, result);
        
        System.out.println("reinas 2");
        numero = 0;
        expResult = -1;
        result = Taller2.reinas(numero);
        assertEquals(expResult, result);
    }

    /**
     * Test of valido method, of class Taller2.
     */
    @Test
    public void testValido() {
        System.out.println("valido");
        int[] tablero = {7,3,0,2,5,1,6,4};
        boolean expResult = true;
        boolean result = Taller2.valido(tablero);
        assertEquals(expResult, result);
        
        System.out.println("valido mal" );
        int[] tableroM = {7,3,0,2,5,1,6,2};
        expResult = false;
        result = Taller2.valido(tableroM);
        assertEquals(expResult, result);
        
        System.out.println("valido bien 2" );
        int[] tableroN = {2,0,3,1};
        expResult = true;
        result = Taller2.valido(tableroN);
        assertEquals(expResult, result);
        
        System.out.println("valido bien 3" );
        int[] tableroR = {2,0,3,1};
        expResult = true;
        result = Taller2.valido(tableroR);
        assertEquals(expResult, result);
    }
    
}
