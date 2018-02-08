
/**
 * Esta clase contiene tres metodos recursivos que se encargan de calcular formulas
 * reconocidas como el algoritmo de euclides.
 * 
 * @author Gonzalo Garcia Hernandez, Daniel Alejandro Mesa Arango.
 * @version 24/07/2017 Clase#2
 */
public class Taller2
{
    /**
     * Este metodo calcula el algoritmo de euclides, ingresando X y Y 
     * 
     * @param recibe dos enteros, un X y un Y 
     * @return retorna un entero, el cual es el M.C.D de los dos numeros ingresados
     */
    public static int gcd(int x, int y)
    {
        if(y == 0)
        {
            return x;
        }
        return gcd(y, x%y);
    }
    
    /**
     * Este metodo retorna un booleano segun si puede hacer la suma dentro del conjunto
     * para el numero que se pide
     * 
     * @param recibe un entero start, que sirve como contador, un arreglo de enteros
     * que representa el conjunto, y target un entero el cual es el que se pide encontrar un 
     * subconjunto que su suma sea igual a el
     * 
     * @return retorna un booleano, true si encuentra que dentro del conjunto es posible encontrar
     * el numero que se pide (target) y false si lo anterior no es posible
     */
    
    public static  boolean sumaGrupo(int start, int [] nums, int target)
    {
        if (start >= nums.length) 
        {
            return target == 0;
        }else 
        {
            return sumaGrupo(start+1, nums, target-nums[start]) 
            || sumaGrupo(start+1, nums, target);
        }
    }
    
    
    /**
     * Este metodo sirve de auxiliar para el metodo combinations el cual recibe una cadena de 
     * caracteres, siendo privado, ya que no nos interesa que se conozca el procemiento con el 
     * cual se realiza la operacion.
     * 
     * @param recibe dos Strings, uno que sirve como base para hacer las combinaciones y el otro
     * el String ingresado por el usuario
     * 
     * 
     */
    private static void combinationsAux(String base, String s)
    {
        /*if(s.length() == 0)
        {
            System.out.println(base);
        }else*/ if(s.length() != 0)
        {
            System.out.println(base + s.charAt(0));   
            combinationsAux(base+s.charAt(0), s.substring(1));
            combinationsAux(base, s.substring(1));
            //System.out.println(base);
        }
    }
    
    /**
     * Este metodo se encarga de recibir la cadena de caracteres por el usuario
     * para luego hacer el primer llamado al metodo recursivo combinationsAux
     * 
     * @param cadena de caracteres definida por el usuario
     */
    public static void combinations(String s)
    {
        combinationsAux("", s);
    }
  
    /**
     * Metodo principal desde el cual se puede hacer las pruebas de los metodos anteriores
     */
    public static void main(String[] args )
    {
        int [] conjunto = {2,4,8};
        System.out.println(gcd(345, 150));
        System.out.println(sumaGrupo(0, conjunto, 10));
        System.out.println("abc");
    }
}
