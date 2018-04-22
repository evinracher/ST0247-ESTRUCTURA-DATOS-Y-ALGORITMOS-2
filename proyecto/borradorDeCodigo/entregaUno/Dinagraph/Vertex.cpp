#include "Vertex.h"

Vertex::Vertex(){}
Vertex::Vertex(double x, double y, int id){
  this->x = x;
  this->y = y;
  this->id = id;
  name = "desconocido";
}

Vertex::Vertex(double x, double y, int id, string name){
  this->x = x;
  this->y = y;
  this->id = id;
  this->name = name;
}

double Vertex::getX(){
  return x;
}

double Vertex::getY(){
  return y;
}

int Vertex::getId(){
  return id;
}

string Vertex::getName(){
  return name;
}

void Vertex::setName(string name){
  this->name = name;
}
