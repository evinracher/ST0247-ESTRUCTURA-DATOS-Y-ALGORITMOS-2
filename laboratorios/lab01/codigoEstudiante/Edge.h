#pragma once
#include "Vertex.h"
#include <string>

class Edge{
  Vertex destination;
  double weight;
  string name;
 public:
  Edge(Vertex destination, double weight);
  Edge(Vertex destination, double weight, string name);
  double getWeight();
  Vertex getDestination();
  string getName();
  int getDesId();
  void setWeight(double w);
  void setName(string name);
};
