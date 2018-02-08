
/**
 * Esta clase contiene tres metodos recursivos que se encargan de calcular formulas
 * reconocidas como el algoritmo de euclides.
 * 
 * @author Kevin Parra, Daniel Mesa, Felipe Olaya.
 * @version 08/02/2018 Clase#2
 */
public class TallerCom
{      
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
	System.out.println("abc");
    }
}
