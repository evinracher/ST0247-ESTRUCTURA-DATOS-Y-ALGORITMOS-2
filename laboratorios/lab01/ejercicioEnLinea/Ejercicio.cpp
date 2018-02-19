#include <iostream>

using namespace std;

/*int esColoreable()
{


}*/


int main(void)
{
  int numeroDeAristas;
  int origen;
  int destino;
  int vertices;
  cin >> vertices; 
  while(vertices != 0)
    {

      int grafo [vertices][vertices]; 
      cin >> numeroDeAristas;
      /*cout << "numero de aristas: "
	   << numeroDeAristas
	   << endl;*/
      int con = 1;
      while(con <= numeroDeAristas)
	{
	  cin >> origen >> destino;
	  grafo [origen][destino] = 1;  
	  /*cout << origen
	       << destino
	       << endl;*/
	  con++;
	}
      cin >> vertices;
      //cout << vertices;
    }

  return 0;
}


