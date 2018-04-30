import java.lang.Math;
public class Punto11
{
    public static int subs(String initial, String finals)
    {
	int[][] table =  new int[initial.length()+1][finals.length()+1];
	for(int i = 0; i <= finals.length();i++)
	    {
		table[0][i] = 0;
	    }
	for(int i = 0; i <= initial.length(); i++)
	    {
		table[i][0] = 0;
	    }
	int ini = 0;
	int fin = 0;
	for(int i = 1; i <= initial.length(); i++)
	    {
		for(int j = 1; j <= finals.length(); j++)
		    {
			if(initial.charAt(i-1) == finals.charAt(j-1))
			    {
				table[i][j] = table[i-1][j-1] + 1;
			    }else if(initial.charAt(i-1) != finals.charAt(j-1))
			    {
				table[i][j] = Math.max(table[i][j-1], table[i-1][j]);
			    }
			//fin++;
		    }
		//ini++;
	    }
	return table[initial.length()][finals.length()];
    }

    public static void main(String[] args)
    {
	String x = "carro";
	String y = "casa";
	int r = subs(x, y);
	System.out.println("la mas larga es: "+ r);
    }
}
