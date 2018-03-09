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
		if(n-denominaciones[k] > 0)
		    {
			dv[k] = dv[k] + 1 ;
			n = n - denominaciones[k];
		    }
		if(n - denominaciones[k] < 0)
		    {
			k++;
		    }else if(n - denominaciones[k] == 0)
		    {
			n = n - denominaciones[k];
			dv[k] = dv[k] + 1;
			return dv;
		    }
	    }
	return dv;
    }
    public static void main(String[] args)
    {
	int [] deno = {500, 300, 200, 50};
	int [] dv = cambioGreedy(900, deno);
	for(int i = 0; i < dv.length; i++)
	    {
		System.out.println(dv[i]);
	    }
	
    }
    /* public static int recorrido(Digraph g) {
	boolean[] visit =  new boolea[g.size()];
    }*/

}
