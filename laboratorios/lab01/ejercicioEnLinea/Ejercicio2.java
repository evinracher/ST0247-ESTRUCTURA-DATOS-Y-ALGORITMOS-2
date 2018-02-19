import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
import java.util.LinkedList;
public class Ejercicio2
{
    // metodo para hacer el ejercicio recursivo
    /*private ArrayList<Integer> sucesor(int [][] grafo, int nodo)
    {
	ArrayList<Integer> suce = new ArrayList<>();
	
	for(int i = 0; i < grafo.length; i++)
	    {
		if(grafo [nodo][i] == 1)
		    {
			suce.add(i);
		    }
	    }

	if(suce.size() == 0)
	    {

		return null;
	    }
	return suce;
    }*/


    public boolean esColoreableP(ArrayList<LinkedList<Integer>> grafo)
    {
	int [] yaColor = new int[grafo.size()];
	int i = 0;
	while(i < yaColor.length)
	    {
		yaColor[i] = -3;
		i++;
	    }
	yaColor[0] = 1;
	boolean es =  auxE(grafo, yaColor);
	return es? true : false;
    }

    private boolean auxE(ArrayList<LinkedList<Integer>> grafo, int [] color)
    {
	Stack<Integer> recorridos =  new Stack<>();
        
	recorridos.push(0);
	while(recorridos.size() != 0)
	    {
		int actual = recorridos.pop();
		if(grafo.get(actual).contains(actual) == true) return false;
		for(int i = 0; i < grafo.get(actual).size(); i++)
		    {
			if(color[i] == -3)
			    {
				color[i] = 3-color[actual];
				recorridos.push(i);
			    }else if(color[actual] == color[i]) return false;
		    }
	    }
	return true;
    }

    public boolean esColoreable(int [][] grafo)
    {
        
	int [] yaColor = new int[grafo.length];
	int i = 0;
	while(i < yaColor.length)
	    {
		yaColor[i] = -3;
		i++;
	    }
	yaColor[0] = 1;
	boolean es =  aux(grafo, yaColor);
	return es? true : false;
    }


    private boolean aux(int [][] grafo, int [] color)
    {
	Stack<Integer> recorridos =  new Stack<>();
        
	recorridos.push(0);
	while(recorridos.size() != 0)
	    {
		int actual = recorridos.pop();
		if(grafo[actual][actual] == 1) return false;
		for(int i = 0; i < grafo.length; i++)
		    {
			if(grafo[actual][i] == 1 && color[i] == -3)
			    {
				color[i] = 3-color[actual];
				recorridos.push(i);
			    }else if(grafo[actual][i] == 1  && color[actual] == color[i]) return false;
		    }
	    }
	return true;
    }
    
    public static void main(String[] args)
    {
	Ejercicio2 g = new Ejercicio2();
	Scanner consola =  new Scanner(System.in);
	int numeroVertices= consola.nextInt();
	int contador = 1;
	int aristas = 0;
	int origen = 0;
	int destino = 0;
	while(numeroVertices != 0)
	    {
		aristas = consola.nextInt();
		//int [][] grafo = new int[numeroVertices][numeroVertices];
		ArrayList <LinkedList<Integer>> grafo = new ArrayList<>();
		for(int j = 0; j < numeroVertices; j++ )
		    {
			grafo.add(new LinkedList<Integer>());
		    }
		contador = 1;
		while(contador <= aristas)
		    {
			origen = consola.nextInt();
			destino = consola.nextInt();
			grafo.get(origen).add(destino);
			//grafo[origen][destino] = 1;
			//System.out.println("origen: " + origen+ " " + "destino: " + destino);
			contador++; 
		    }
		String res = g.esColoreableP(grafo)? "BICOLORABLE" : "NOT BICOLORABLE";
		System.out.println(res);
		numeroVertices = consola.nextInt();
	    }
	
    }
}
