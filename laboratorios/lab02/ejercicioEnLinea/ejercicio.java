import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.Math;

public class ejercicio
{
    private static ArrayList<String> permutations(String s) {
        ArrayList<String> r = new ArrayList<String>();      //c
        permutations("", s, r);  // n!
        return r; //c
    }
    //T(n) = c+c+n!
    //O(n!)

    private static void permutations(String pre, String pos, ArrayList<String> list) {
        if (pos.length() == 0) {
            list.add(pre);
        } else {
            for (int i = 0; i < pos.length(); ++i) {                   //c*n
                permutations(pre + pos.charAt(i), pos.substring(0, i) + pos.substring(i + 1), list);  //n*T(n-1)
            }
        }
    }
    //T(n) = c*n+ n*T(n-1)
    //O(n!)

    private static int nReinas(int numero, int [] tableroMalos) {
        if (numero != 0) {
            int resultado = 0;
            String original = "";
            int[] tablero = new int[numero];
            for (int i = 0; i < numero; i++) {            //n
                original = original + i;               //c*n
            }
            ArrayList<String> todos = new ArrayList<String>();
            todos = permutations(original);                    //n!

            for (int j = 0; j < todos.size(); j++) {          //c*m
                String prueba = todos.get(j);                 //c*m
                for (int i = 0; i < prueba.length(); i++) {   //c*n*m
                    tablero[i] = Integer.parseInt(prueba.charAt(i) + "");  //c*n*m
                }
                if (valido(tablero, tableroMalos) == true) {  //c*n^2*m
                    resultado = resultado + 1;                // c*m
                }
            }
            return resultado;                                 //c
        } else {
            return -1;
        }
    }

    //T(n) = n+c*n+n!+c*m+c*m+c*n*m+c*n*m+c*n^2*m+c*m+c
    //O(n!)

    public static boolean valido(int[] tablero, int [] tableroMalos) {
        for (int i = 0; i < tablero.length; i++) {     //c*n
            for (int j = i + 1; j < tablero.length; j++) {     //c*n*n
                if (tablero[i] == tablero[j] || Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j) || tablero[i] == tableroMalos[i]) //c*n^2 
                    return false;                 //c
                }
	}
    
	/*for(int j = 0; j < tablero.length; j++)
	    {
		if(tablero[j] == tableroMalos[j])
		    return false;
		    }*/
        return true; //c
    }
    //T(n) = c*n+c*n*n+c+c*n^2+c
    //O(n^2)
    

    public static void main(String[] args)
    {
	Scanner in  =  new Scanner(System.in); 
	int numero = in.nextInt(); 
	int contador = 0;          
	while(numero != 0)
	    {
		contador++;
		int [] malos = new int[numero];
		for(int r = 0; r < numero; r++)
		    malos[r] = -1;
		
		char auxiliar = ' ';
		String linea = "";
		for(int j = 0; j < numero; j++)
		    {
			linea = in.next();
			for(int i = 0; i < linea.length(); i++) //n
			    {
				
				auxiliar = linea.charAt(i); //c*n
				if(auxiliar == '*')          //c*n
				    {
				
					malos[j] = i;      //c*n
				    }
			    }

		    }
		System.out.println("Case "+ contador+ ": " + nReinas(numero, malos)); //n!
		numero = in.nextInt();         
	    }
    }
    //T(n) = n+c*n+c*n+c*n+n!
    //O(n!)
    
}
