/**
 * Clase en la cual se implementan los metodos del Taller de Clase #6
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller6 {

    public static int[] cambioGreedy(int n, int[] denominaciones) {
	int[] dv = new int[denominaciones.length];
	int k = 0;
	while(k < denominaciones.length )
	    {
		if(n-denominaciones[k] >= 0)
		    {
			dv[k] = dv[k] + 1 ;
			n = n - denominaciones[k];
		    }
		if(n-denominaciones[k] < 0) k++;
	    }
	if(n != 0) return null;
	return dv;
    }
    public static void main(String[] args)
    {
	int [] deno1 = {500, 300, 200, 50};
	int [] deno = {5, 3};
	int [] dv = cambioGreedy(900, deno1);
	if(dv != null)
	    {
		for(int i = 0; i < dv.length; i++)
		    {
			System.out.println(dv[i]);
		    }
	    }else
	    {
		System.out.println(dv);
	    }
	
    }
    /* public static int recorrido(Digraph g) {
	boolean[] visit =  new boolea[g.size()];
    }*/

}
