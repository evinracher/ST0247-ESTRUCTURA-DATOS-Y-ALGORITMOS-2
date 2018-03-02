import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #5
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller5 {

	public static boolean mColoring(Digraph g, int m) {
	    int [] colors = new int[g.size()];
	    boolean i  = mColoring(g, 0, colors, m);
	    return i;
	}

	// recomendacion
	private static boolean isSafe(Digraph g, int v, int[] colors, int c) {
	    ArrayList<Integer> sucesores=  g.getSuccessors(v);
	    for(int i = 0; i < sucesores.size(); i++)
		{
		    if(colors[sucesores.get(i)] == colors[v]) return true;
		    
		}
	    return false;
	}

	// recomendacion
	private static boolean mColoring(Digraph g, int v, int[] colors, int m) {
	    if(v == g.size())
		{
		    return true;
		}else
		{
		    for(int i = 1; i <= m; i++)
			{
			    colors[v] = i;
			    if(!isSafe(g, v, colors, m)) return mColoring(g, v+1, colors, m);       
			}
		}
	    return false;
	}

    public static void main(String[] args)
    {
	DigraphAM g = new DigraphAM(10);
	g.addArc(0, 1, 1);
	g.addArc(0, 2, 1);
	g.addArc(0, 5, 1);
	g.addArc(1, 0, 1);
	g.addArc(1, 6, 1);
	g.addArc(1, 7, 1);
	g.addArc(2, 0, 1);
	g.addArc(2, 3, 1);
	g.addArc(2, 8, 1);
	g.addArc(3, 2, 1);
	g.addArc(3, 4, 1);
	g.addArc(3, 7, 1);
	g.addArc(4, 3, 1);
	g.addArc(4, 5, 1);
	g.addArc(4, 6, 1);
	g.addArc(5, 0, 1);
	g.addArc(5, 4, 1);
	g.addArc(5, 9, 1);
	g.addArc(6, 1, 1);
	g.addArc(6, 4, 1);
	g.addArc(6, 8, 1);	
	g.addArc(7, 1, 1);
	g.addArc(7, 3, 1);
	g.addArc(7, 9, 1);
	g.addArc(8, 2, 1);
	g.addArc(8, 6, 1);
	g.addArc(8, 9, 1);
	g.addArc(9, 5, 1);
	g.addArc(9, 7, 1);
	g.addArc(9, 8, 1);
	System.out.println(mColoring(g, 2));
    }

}
