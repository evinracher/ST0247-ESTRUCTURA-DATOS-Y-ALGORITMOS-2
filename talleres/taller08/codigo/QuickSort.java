public class QuickSort{

    public static int[] p(int [] n)
    {
	quicksort(n, 0, n.length-1);
	return n;
    }

    public static void quicksort(int A[], int izq, int der) {

	int pivote=A[izq]; 
	int i=izq; 
	int j=der; 
	int aux;
 
	while(i<j){
	    while(A[i]<=pivote && i<j) i++; 
	    while(A[j]>pivote) j--;         
	    if (i<j) {                                            
		aux= A[i];                  
		A[i]=A[j];
		A[j]=aux;
	    }
	}
	A[izq]=A[j]; 
	A[j]=pivote; 
	if(izq<j-1)
	    quicksort(A,izq,j-1); 
	if(j+1 <der)
	    quicksort(A,j+1,der);
    }


    public static void main(String[] args)
    {
	int [] initial = {2, 10, 46, 1, 8};
	int [] numeros = p(initial);
	for(int i = 0; i < numeros.length; i++)
	    {
		System.out.println(numeros[i]);
	    }
    }

}
