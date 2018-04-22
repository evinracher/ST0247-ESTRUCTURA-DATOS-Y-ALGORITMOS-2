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
  map<int, vector<Edge > > adList;
  //For the moment, It doesn't be necesary
  int size;

  //Counter to the number of Edges in the Dinagraph
  int cEdges;

  //Obsoleted
  void defineTam();
 public:
  //Constructor of Dinagraph. tam is the number of vertex
  DinaGraph(int tam);
  //Variable i is the id of a vertex and x,y are the coordinates
  void addVertex(int i, double x, double y);
  //Name is the name of a vertex. e.g: Universidad eafit
  void addVertex(int i, double x, double y, string name);
  //An Edge that connect two vertex
  void addEdge(int i, int j);
  //An Edge that connect two vertex with dis (weight) and Edge name
  void addEdge(int i, int j, double dis, string name);
  //Print successors:
  void printSs(int i);
  /**
     if a given vertex i or a given vertex
     j doesn't exits, the edge don't be added
  **/
  //Return number of Vertexes
  int getSize();
  //Return number of Edges
  int getLength();
  //Return a Edge in Dinagraph
  Edge getEdge(int i, int j);
  //Return the successors of a vertex
  vector<Edge > getSuccessors(int i);
};
