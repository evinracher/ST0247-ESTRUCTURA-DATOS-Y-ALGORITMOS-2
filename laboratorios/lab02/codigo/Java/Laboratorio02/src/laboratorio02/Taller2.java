/**
 *Clase que implemeta dos algoritmos uno para permutaciones y el otro para hallar las posibles
 * soluciones al problema de las nReinas
 *
 * @author Kevin Parra, Daniel Mesa
 *
 */
package laboratorio02;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;

public class Taller2 {

    /**
     * metodo que recibe un string para aplicar sobre el las permutaciones posibles
     * @param s string al cual se le aplican las permutaciones posibles
     * @return una lista con todas las permutaciones sobre el string recibido
     */
    public static ArrayList<String> permutations(String s) {
        ArrayList<String> r = new ArrayList<String>();
        permutations("", s, r);
        return r;
    }
    /**
     * Este es un metodo auxiliar para calcular las permutaciones mediante el 
     * uso de la recursion, desglozando la cadena original en una especie de arbol para llegar a todas
     * las permutaciones
     * @param pre string el cual actua como acumulador
     * @param pos cadena original la cual se va recortando
     * @param list lista en la cual se guardan las permutaciones
     */
    private static void permutations(String pre, String pos, ArrayList<String> list) {
        if (pos.length() == 0) {
            list.add(pre);
        } else {
            for (int i = 0; i < pos.length(); ++i) {
                permutations(pre + pos.charAt(i), pos.substring(0, i) + pos.substring(i + 1), list);
            }
        }
    }
    
    /**
     * Este metodo hace uso del metodo de permutaciones, para asi despues comprobar cual tablero
     * cumple con las condiciones para el problema e las nReinas que consiste en ubiacarlas sin que se ataquen
     * @param numero el numero de tipo int es el numero de reinas y por consiguiente del tablero o arreglo
     * @return el numero de soluciones
     */
    public static int reinas(int numero) {
        if (numero != 0) {
            int resultado = 0;
            String original = "";
            int[] tablero = new int[numero];
            for (int i = 0; i < numero; i++) {
                original = original + i;
            }
            ArrayList<String> todos = new ArrayList<String>();
            todos = permutations(original);

            for (int j = 0; j < todos.size(); j++) {
                String prueba = todos.get(j);
                for (int i = 0; i < prueba.length(); i++) {
                    tablero[i] = Integer.parseInt(prueba.charAt(i) + "");
                }
                if (valido(tablero) == true) {
                    resultado = resultado + 1;
                }
            }
            return resultado;
        } else {
            return -1;
        }
    }
    
    /**
     * Calcula el tiempo de ejecucion para un problema de tamaño n
     * @param numero de reinas y tamaño del tablero
     * @return el tiempo que demora en calcular las soluciones para un problema de tamaño n
     */
    public static long tomarTiempo(int n) {
        long startTime = System.currentTimeMillis();
        reinas(n);
        long estimatedTime = System.currentTimeMillis() - startTime;
        return estimatedTime;
    }
    
    /**
     * verifica si un tablero representado en arreglo cumple para valido es decir las reinas no se atacan
     * @param tablero arreglo que representa el tablero
     * @return un booleano indicando si se atacan o no
     */
    public static boolean valido(int[] tablero) {   
        for (int i = 0; i < tablero.length; i++) {
            for (int j = i + 1; j < tablero.length; j++) {
                if (tablero[i] == tablero[j] || Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
