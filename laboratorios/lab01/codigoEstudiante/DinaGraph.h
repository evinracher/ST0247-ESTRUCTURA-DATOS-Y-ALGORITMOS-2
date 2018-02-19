#pragma once
#include "Vertex.h"
#include "Edge.h"
#include <map>
#include <vector>

using namespace std;

/**
   I are going using map to allow to add new vertex to the graph
 **/

class DinaGraph{

  map<int, Vertex > vertexes;
  // map<int, vector<Edge> > edges;
  map<int, vector<Edge > > edges;
  //For the moment, It doesn't be necesary
  int size;
  int cEdges;
  void defineTam();
 public:
  DinaGraph(int tam);
  void addVertex(int i, double x, double y);
  void addVertex(int i, double x, double y, string name);
  void addEdge(int i, int j);
  void addEdge(int i, int j, double dis, string name);
  //Print successors:
  void printSs(int i);
  /**
     if a given vertex i or a given vertex 
     j doesn't exits, the edge don't be added
  **/
  int getSize();
};
