import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.Math;

public class ejercicio
{
    private static ArrayList<String> permutations(String s) {
        ArrayList<String> r = new ArrayList<String>();
        permutations("", s, r);
        return r;
    }

    private static void permutations(String pre, String pos, ArrayList<String> list) {
        if (pos.length() == 0) {
            list.add(pre);
        } else {
            for (int i = 0; i < pos.length(); ++i) {
                permutations(pre + pos.charAt(i), pos.substring(0, i) + pos.substring(i + 1), list);
            }
        }
    }

    private static int nReinas(int numero, int [] tableroMalos) {
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
                if (valido(tablero, tableroMalos) == true) {
                    resultado = resultado + 1;
                }
            }
            return resultado;
        } else {
            return -1;
        }
    }

    public static boolean valido(int[] tablero, int [] tableroMalos) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = i + 1; j < tablero.length; j++) {
                if (tablero[i] == tablero[j] || Math.abs(tablero[i] - tablero[j]) == Math.abs(i - j)) //|| tableroMalos[i] == tablero[i]) {
                    return false;
                }
	}
    
	for(int j = 0; j < tablero.length; j++)
	    {
		if(tablero[j] == tableroMalos[j])
		    return false;
	    }
        return true;
    }

    

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
		        //System.out.println("j: " +j);
			linea = in.next();
			for(int i = 0; i < linea.length(); i++)
			    {
				//System.out.println("i: " +i);
				auxiliar = linea.charAt(i);
				if(auxiliar == '*')
				    {
					//System.out.println(j+ " " + i + " adentro" );
					malos[j] = i; 
				    }
			    }
			//linea = in.next();
		    }
		System.out.println("Case "+ contador+ ": " + nReinas(numero, malos));
		/*for(int h = 0; h < numero; h++)
		    {
			System.out.print(malos[h]+ " ");
		    }*/
		numero = in.nextInt();
	    }
    }
    
}
