import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #2
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller2 {

    public static boolean sumaGrupo(int start, int[] nums, int target) {
	if(start == nums.length){
	    if(target == 0)
		return true;
	    return false;
	}
	return sumaGrupo(start+1,nums,target)||sumaGrupo(start+1,nums, target-nums[start]);
    }

    public static ArrayList<String> permutations(String s) {
	ArrayList<String> r = new ArrayList<String>();
	permutations("", s, r);
	return r;
    }

    // recomendacion
    private static void permutations(String pre, String pos, ArrayList<String> list) {
	if(pos.length() == 0){
	    System.out.println(pre);
	    list.add(pre);
	}else{
	    for(int i = 0; i < pos.length(); ++i ){
		permutations(pre+pos.charAt(i), pos.substring(0,i)+pos.substring(i+1), list);
	    }
	}
    }

    /**

    /**    public static ArrayList<String> combinations(String s) {
	// complete...
    }

    // recomendacion
    private static void combinations(String pre, String pos, ArrayList<String> list) {
	// complete...
    }

    public static ArrayList<String> permutations(String s) {
	// complete...
    }

    // recomendacion
    private static void permutations(String pre, String pos, ArrayList<String> list) {
	// complete...
    }

    public static void imprimirTablero(int[] tablero) {
	int n = tablero.length;
	System.out.print("    ");
	for (int i = 0; i < n; ++i)
	    System.out.print(i + " ");
	System.out.println("\n");
	for (int i = 0; i < n; ++i) {
	    System.out.print(i + "   ");
	    for (int j = 0; j < n; ++j)
		System.out.print((tablero[i] == j ? "Q" : "#") + " ");
	    System.out.println();
	}
	System.out.println();
    }

    public static boolean esValido(int[] tablero) {
	// complete...
    }

    public static int queens(int n) {
	// complete...
	}**/
    public static void main(String[] args){
	Taller2 proff = new Taller2();
	proff.permutations("abc");
    }

}
