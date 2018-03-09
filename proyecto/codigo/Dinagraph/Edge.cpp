#include "Edge.h"

Edge::Edge(Vertex destination, double weight):
  destination(destination),
  weight(weight)
{}

Edge::Edge(Vertex destination, double weight, string name):
  destination(destination),
  weight(weight),
  name(name)
{}

double Edge::getWeight(){
  return weight;
}

Vertex Edge::getDestination(){
  return destination;
}

string Edge::getName(){
  return name;
}

int Edge::getDesId(){
  return destination.getId();
}

void Edge::setWeight(double w){
  weight = w;
}

void Edge::setName(string name){
  this->name = name;
}
