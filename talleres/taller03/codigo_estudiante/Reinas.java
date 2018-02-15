public class Reinas
{
    public static int reinas(int numero)
    {
	int resultado = 0;
	int [] tablero = new int[numero];
	auxiliar(tablero, 0);
	/*for(int i = 0; i < numero; i++)
	    {
		tablero[i] = 0;
		
		}*/
	return resultado;
    }
    

    public static void auxiliar(int[] tablero, int  posicion)
    {
	if(posicion == tablero.length)
	    {
		if(!isTrue(tablero))
		    imprimir(tablero);
	    }else
	    {
		for(int i = 0; i < tablero.length; i++)
		    {
			tablero[posicion] = i;
			auxiliar(tablero, posicion+1);
		    }
	    }
	//return todos;
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
    
    public static boolean isTrue(int[] tablero)
    {
	for(int i = 0; i < tablero.length; i++)
	    for(int j = i+1; j < tablero.length; j++)
		if(tablero[i] == tablero[j] || Math.abs(tablero[i]-tablero[j]) == Math.abs(i-j))
		    return true;
	return false;
    }

    public static void main(String[] args)
    {
	System.out.println(reinas(4));
	
    }
}
