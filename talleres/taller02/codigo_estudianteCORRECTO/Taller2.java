/**
 * 
 * 
 * @author Kevin Parra, Daniel Mesa, Felipe Olaya.
 * @version 08/02/2018 Clase#2
 */
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
public class Taller2
{
    
    private static ArrayList<String> combinationsAux(String base, String s, ArrayList<String> p)
    {
	//ArrayList<String> combination = new ArrayList<>();
        if(s.length() == 0)
	    {
		p.add(base);
	    }else
	    {   
		combinationsAux(base+s.charAt(0), s.substring(1), p);
		combinationsAux(base, s.substring(1), p);
	    }
	return p;
	
    }
    
    public static ArrayList<String> combinations(String s)
    {
	ArrayList<String> p = new ArrayList<>();
        return combinationsAux("", s, p);
    }

    public static ArrayList<String> permutations(String s) {
	ArrayList<String> r = new ArrayList<String>();
	permutations("", s, r);
	return r;
    }

    // recomendacion
    private static void permutations(String pre, String pos, ArrayList<String> list) {
	if(pos.length() == 0){
	    //System.out.println(pre);
	    list.add(pre);
	}else{
	    for(int i = 0; i < pos.length(); ++i ){
		permutations(pre+pos.charAt(i), pos.substring(0,i)+pos.substring(i+1), list);
	    }
	}
    }

    public static int reinas(int numero)
    {
	int resultado = 0;
	String original = "";
	int [] tablero = new int[numero];
	for(int  i = 0; i < numero; i++)
	    {
		original = original+i;
	    }
	ArrayList<String> todos = new ArrayList<String>();
	todos = permutations(original);
	
	for(int j = 0; j < todos.size(); j++)
	    {
		String prueba = todos.get(j);
		for(int i = 0; i < prueba.length(); i++)
		    {
			tablero[i] = Integer.parseInt(prueba.charAt(i)+"");
		    }
		if(valido(tablero) == true)
		    {
			resultado = resultado + 1;
		    }
		//System.out.println(resultado);
	    }
	return resultado;
	//System.out.println(ta);
	//return ta;
    }
    

    public static ArrayList<int []> auxiliar(int[] tablero, int  posicion, ArrayList<int[]> todos)
    {
	if(posicion == tablero.length)
	    {
		todos.add(tablero);
	    }else
	    {
		for(int i = 0; i < tablero.length; i++)
		    {
			tablero[posicion] = i;
			auxiliar(tablero, posicion+1, todos);
		    }
	    }
	return todos;
    }

    
    public static void imprimir(int[] arreglo)
    {
	for(int i = 0; i < arreglo.length; i++)
	    {
		for(int j = 0; j < arreglo.length; j++)
		    if (j == arreglo[i])
			System.out.print("Q");
		    else
			System.out.print("*");
		System.out.println();
	    }
	System.out.println();
    }
    
    
    //tomado de interactiva
    public static boolean valido(int[] tablero)
    {
	for(int i = 0; i < tablero.length; i++)
	    for(int j = i+1; j < tablero.length; j++)
		if(tablero[i] == tablero[j] || Math.abs(tablero[i]-tablero[j]) == Math.abs(i-j))
		    return false;
	return true;
    }
    
    
    public static void main(String[] args )
    {
	//TallerCom primero = new TallerCom();
	//ArrayList<String> p = primero.combinations("abc");
	/*for(int i = 0; i < p.size(); i++)
	    {
		System.out.println(p.get(i));
		}*/
	System.out.println(reinas(1));
      }
}
