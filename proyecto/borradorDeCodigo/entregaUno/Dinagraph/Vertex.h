#pragma once
#include <string>
using namespace std;

class Vertex{
  double x,y;
  int id;
  string name;
public:
  Vertex();
  Vertex(double x, double y, int id);
  Vertex(double x, double y, int id, string name);
  double getX();
  double getY();
  int getId();
  string getName();
  void setName(string name);
};
