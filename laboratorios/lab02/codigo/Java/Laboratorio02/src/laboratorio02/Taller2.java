/**
 * 
 * 
 * @author Kevin Parra, Daniel Mesa, Felipe Olaya.
 * 
 */
package laboratorio02;
import java.lang.*;
import java.util.*;
import java.util.ArrayList;
public class Taller2
{
      public static ArrayList<String> permutations(String s) {
	ArrayList<String> r = new ArrayList<String>();
	permutations("", s, r);
	return r;
    }
    private static void permutations(String pre, String pos, ArrayList<String> list) {
	if(pos.length() == 0){
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
	    }
	return resultado;
    }
    
    public static boolean valido(int[] tablero)
    {
	for(int i = 0; i < tablero.length; i++)
	    for(int j = i+1; j < tablero.length; j++)
		if(tablero[i] == tablero[j] || Math.abs(tablero[i]-tablero[j]) == Math.abs(i-j))
		    return false;
	return true;
    }
}
