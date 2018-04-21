#include <bits/stdc++.h>

/**
Compile with C++11
Trabajo en conjunto con Agustin Nieto 
**/
using namespace std;
#define D(x) cout << "DEBUG" << #x "=" << x << endl;

enum nodetype {
  customer = 'c', station = 's', deposit = 'd'
};

struct node {
  int id;
  char *name;
  float x, y;
  char type;
  int station_type;
};
/**
   n = # of nodes
   m = # of customers
   u = # of charging stations
 **/
int n, m, u, breaks;
float r, speed, Tmax, Smax;
float st_customer, Q;
int l, g;
float **ls, **gs;

node *nodes;

// Saving charging stations
vector<node> csts;


void readInput(){
  //About the problem
  scanf(" n = %d", &n);
  D(n);
  scanf(" m = %d", &m);
  D(m);
  scanf(" u = %d", &u);
  D(u);
  scanf(" breaks = %d", &breaks);
  D(breaks);
  //About the car
  scanf(" r = %f", &r);
  D(r);
  scanf(" speed = %f", &speed);
  D(speed);
  scanf(" Tmax = %f", &Tmax);
  D(Tmax);
  scanf(" Smax = %f", &Smax);
  D(Smax);
  //About... more xd
  scanf(" st_customer = %f", &st_customer);
  D(st_customer);
  scanf(" Q = %f", &Q);
  D(Q);
  //About the map!
  scanf(" Coordinates");

  nodes = new node[n];
  for(int i=0;i<n;++i){
    scanf(" %d %s %f %f %c %d"
          , &nodes[i].id, &nodes[i].name
          , &nodes[i].x, &nodes[i].y
          , &nodes[i].type,&nodes[i].station_type);
    D(nodes[i].id);
    printf(nodes[i].name);
    D(nodes[i].x);
    D(nodes[i].y);
    D(nodes[i].type);    
    D(nodes[i].station_type);
    if(nodes[i].type == 's'){
      D("Charging station");
      D(nodes[i].type);
      csts.push_back(nodes[i]);
    }
  }
  //About the stations
  scanf(" l");
  ls = new float*[3];
  for(int i=0;i<3;++i){
    ls[i] = new float[breaks];
    for(int j=0;j<breaks;++j){
      scanf(" %f", &ls[i][j]);
    }
  }

  scanf(" g");
  gs = new float*[3];
  for(int i=0;i<3;++i){
    gs[i] = new float[breaks];
    for(int j=0;j<breaks;++j){
      scanf(" %f", &gs[i][j]);
    }
  }
}

//Print charging stations
void print_csts(){
  for(int i = 0; i < csts.size(); ++i){
    cout << csts[i].id << csts[i].name << csts[i].x << csts[i].y << csts[i].type << csts[i].station_type << endl;
  }
}

int main(){
  readInput();
  Tmax -= m * st_customer;
  print_csts();
}
