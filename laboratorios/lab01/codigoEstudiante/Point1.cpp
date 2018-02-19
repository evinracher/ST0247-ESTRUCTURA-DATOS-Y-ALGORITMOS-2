#include <iostream>
#include "DinaGraph.h"
#include <cstdlib>
#include <vector>
#include <list>
#include <map>

using namespace std;
DinaGraph grafo (10);
string lectura,name;
int id, ido;
double x,y,w;
  
void construction(){
  cin >> lectura;
  if(lectura == "Vertices."){
    getline(cin, lectura);
    cin >> lectura;
    while(lectura != "Arcos."){
      id = atoi(lectura.c_str());
      cout << "ID: "<< id << endl;
      cin >> x;
      cout << "X: " << x << endl;
      cin >> y;
      cout << "Y: " << y << endl;
      getline(cin,name);
      grafo.addVertex(id,x,y,name);
      cout << "Nombre: " << name << endl;
      cin >> lectura;
      cout << lectura << endl;
    }
    getline(cin, lectura);
    cout << lectura << endl;
    cout << "Despues de arcos" << endl;
    while(cin >> id){
      cout << "ID 1: "<< id << endl;
      cin >> ido;
      cin >> w;
      getline(cin,lectura);
      cout << "Añadiendo: "<< endl;
      grafo.addEdge(id,ido,w,lectura);
    }
  }else{
    cout << "Violación del formato" << endl;
  }
  
}
int main(int argc, char* argv[]){
  construction();
  grafo.printSs(1);
  return 0;
}
