#include <iostream>
#include "graph.cpp"
#include <cstdlib>
#include <vector>
#include <list>
using namespace std;

list<vector<string> > data;

int main(int argc, char* argv[]){
  string lectura;
  cin >> lectura;
  if(lectura == "Vertices."){
    cout << lectura << endl;
    getline(cin, lectura);
    cin >> lectura;
    while(lectura != "Arcos."){
      cout << "ID:"<< lectura << endl;
      int i = atoi(lectura.c_str());
      vector<string> vec(3);
      cin >> lectura;
      vec[0] = lectura;
      cout << "coordenada x:"<< lectura << endl;
      cin >> lectura;
      vec[1] = lectura;
      cout << "coordenada y:"<< lectura << endl;
      getline(cin,lectura);
      vec[2] = lectura;
      cout << "nombre:"<< lectura << endl;
      vec[3] = "TRES";
      cin >> lectura;
      //lista de parejas es mejor, necesita un iterador la lista para insertar :| I am going to sleep
      data.insert(vec);
    }
    getline(cin, lectura);
    cout << "ARCOS" << endl;
    while(cin >> lectura){
      cout << "ID1: "<< lectura << endl;
      cin >> lectura;
      cout << "ID2: "<< lectura << endl;
      cin >> lectura;
      cout << "Distancia: "<< lectura << endl;
      getline(cin,lectura);
      cout << "Nombre: "<< lectura << endl;
    }
  }else{
    cout << "Violación del formato" << endl;
  }
  return 0;
}
