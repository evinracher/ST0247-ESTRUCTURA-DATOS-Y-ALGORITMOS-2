#include <bits/stdc++.h>

/**
   Compile with C++11
   Trabajo en conjunto con Agustin Nieto
**/
using namespace std;
#define D(x) cout << "DEBUG " << #x "=" << x << endl

#define M(x) cout << x << endl
enum nodetype {
  customer = 'c', station = 's', deposit = 'd'
};

struct node {
  int id;
  string name;
  float x, y;
  char type;
  int station_type;
  int region; //region, charging stations doesnt have that (region = -1 ever)
  int dregion; //distance to region
  //  node(int id, string name, float x, float y, char type, int station_type) {this->id = id; this->name = name; this->x = x; this->y = y; this->type = type; this->station_type = station_type;}
  //Charging (la pendiente)
  float cing;
};

vector<vector<float> > geses;
vector<vector<float> > leses;

/**
   n = # of nodes
   m = # of customers
   u = # of charging stations
**/

int MAX = 1000000;
int n, m, u, breaks;
float r, speed, Tmax, Smax;
float st_customer, Q;
int l, g;
float **ls, **gs;
float costoTotal;


float calc_charge(int type){
  return geses[type][geses[type].size()-1]/leses[type][leses[type].size()-1];
}

//Charging function
float charging(float m, float time){
  return m*time;
}

//How much kilometers can i drive?
float h_km(float level_b){
  return level_b/r;
}

//How much battery i need to drive km?
float h_b(float km){
  return km*r;
}


//Saving all nodes
vector<node> nodes;

// Saving charging stations
vector<node> csts;

//regiones
map<int, vector<node> > rs;

//Vector de grafos (con todas las regiones)
map<int, vector<vector<float> > > graphs;

float dist(node n1, node n2);
void print_node(node &p);

node deposito;

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

  nodes.resize(n);
  for(int i=0;i<n;++i){
    cin >> nodes[i].id;
    cin >> nodes[i].name;
    cin >> nodes[i].x;
    cin >> nodes[i].y;
    cin >> nodes[i].type;
    cin >> nodes[i].station_type;
    nodes[i].region = -1;
    nodes[i].dregion = -1;

    if(nodes[i].type == 's'){
      csts.push_back(nodes[i]);
    }else{
      nodes[i].cing = 0;
    } 
  }
  //About the stations
  scanf(" l");
  leses.resize(3);
  for(int i=0;i<3;++i){
    leses[i].resize(breaks);
    for(int j=0;j<breaks;++j){
      scanf(" %f", &leses[i][j]);
    }
  }
  
  scanf(" g");
  geses.resize(3);
  for(int i=0;i<3;++i){
    geses[i].resize(breaks);
    for(int j=0;j<breaks;++j){
      scanf(" %f", &geses[i][j]);
    }
  }

  for(int i = 0; i < csts.size();++i){
    csts[i].cing = calc_charge(csts[i].station_type);
    D(csts[i].station_type);
    D(i);
    D(csts[i].cing);
  }
}


void c_regions(){
  for(int i = 0; i < nodes.size(); i++){
    if(nodes[i].type == 's'){
      continue;
    }
    if(nodes[i].type == 'd'){
      continue;
    }
    int mindist = dist(nodes[i],csts[0]);
    int idmin = csts[0].id;
    for(int j = 1; j < csts.size(); ++j){
      float dtemp = dist(nodes[i], csts[j]);
      if(dtemp < mindist){
	mindist = dtemp;
	idmin = csts[j].id;
      }
    }
    nodes[i].region = idmin;
    nodes[i].dregion = mindist;
    rs[idmin].push_back(nodes[i]);
  }
}

//print regions
/*void print_rs(){
  for(map<int, vector<node> >::iterator it = rs.begin(); it != rs.end(); ++it){
    cout << it->first << " :" << endl;
    vector<node> r = it->second;
    for(int i = 0; i < r.size(); i++){
      print_node(r[i]);
    }
  }
}*/

void print_node(node &node){
  cout << node.id << " "
       << node.name << " "
       << node.x << " "
       << node.y << " "
       << node.type << " "
       << node.station_type << " "
       << endl;
}

//Print charging stations
void print_csts(){
  for(int i = 0; i < csts.size(); ++i){
    print_node(csts[i]);
  }
}

//Calculate distance between two nodes
float dist(node n1, node n2){
  float x = n2.x-n1.x;
  float y = n2.y-n1.y;
  float c = pow(x,2)+pow(y,2);
  float r = pow(c,0.5);
  return r;
}

// No se identifica en el recorrido por id... si necesitamos saber el id solo se hace algo como rgs[i].id
// maybe we are goint to need more that distance
vector<vector<float> > grafo(vector<node > rgs)
{
  vector< vector <float> > graph_a (rgs.size());
  for(int i = 0; i < graph_a.size(); ++i){
    graph_a[i].resize(rgs.size());
  }
  for(int i = 0; i < rgs.size(); i++)
    {
      for(int j = 0; j < rgs.size(); j++)
	{
	  if(i != j){
	    float distancia = dist(rgs[i], rgs[j]);
	    graph_a[i][j]= distancia;
	  }
	}
    }
  return graph_a;
}

void print_vector(vector<node> nos){
  for(int i = 0; i < nos.size(); ++i){
    print_node(nos[i]);
  }
}

//Generating finals graphs
void vgraph(){
  for(map<int, vector<node> >::iterator it = rs.begin(); it != rs.end(); ++it){
    vector<node > r = it->second;
    int identifier = it->first;
    graphs[identifier] = grafo(r);
  }
}

vector<pair<node, float> > tspAux(int grafoA)
{
  float c_b = Q;
  vector<vector<float> > grafoActual = graphs[grafoA];
  vector<pair<node, float> > camino;
  camino.push_back(make_pair(nodes[0], 0));
  vector<node> re = rs[grafoA];
  float distance = dist(nodes[0], re[0]);
  int min = 0;
  for(int i = 1; i < re.size(); i++)
    {
      if(distance > dist(nodes[0], re[i]))
	{
	  distance = dist(nodes[0], re[i]);
	  min = i;
	}
    }
  costoTotal = costoTotal + (distance/speed);
  float costoLocal = distance/speed;
  int pos = min;
  vector<bool> visited;
  visited.assign(re.size(), false);
  if(grafoActual.size() > 0)
    {
      for(int g = 0; g < grafoActual.size(); g++)
	{
	  camino.push_back(make_pair(re[pos], costoLocal));
	  visited[pos] = true;
	  float minus = MAX;
	  bool change = true;
	  int nuevoPos = pos;
	  for(int i = 0; i < grafoActual.size(); i++)
	    {
	      if(minus > grafoActual[pos][i] && visited[i] == false)
		{
		  minus = grafoActual[pos][i];
		  nuevoPos = i;
		}
	      if(minus != MAX){
	    pos = nuevoPos;
	    costoLocal = costoLocal + (minus / speed);
	      }
	    }
	}
    }
  int d_return = dist(nodes[0], camino[camino.size()-1].first);
  costoLocal+= d_return/speed;
  camino.push_back(make_pair(nodes[0], costoLocal));
  costoTotal+=costoLocal;
  cout << "Costo Local: " << costoLocal << endl;
  return camino;
}

void print_g(int id){
  if(graphs[id].size() <= 1){
    return;
  }
  cout << "[ ";
  for(int i = 0; i < graphs[id].size(); ++i)
    cout << i <<  " ";
  cout << endl;
  for(int i = 0; i < graphs[id].size(); ++i){
    cout << i << " ";
    for(int j = 0; j < graphs[id][i].size();++j){
      cout << graphs[id][i][j] << " ";
    }
    cout << endl;
  }
  cout << "]" << endl;
}

//print final graf
void print_f(){
  for(int i = 0; i < graphs.size(); ++i){
    print_g(i);
  }
}

//Print nodes
void print_ns(){
  for(int i = 0; i < nodes.size(); ++i){
    print_node(nodes[i]);
  }
}


int main(){
  readInput();
  //Tmax -= m * st_customer; //ruta total
  //Generating regions
  c_regions();
  //print_rs();
  vgraph();

  for(map<int, vector<vector<float> > >::iterator it = graphs.begin(); it != graphs.end(); it++)
    {
      int identifier = it->first;
      vector<pair<node, float> > result = tspAux(identifier);
      cout << "ruta: " << endl;
      for(int i  = 0; i < result.size(); i++)
	{
	  cout << result[i].first.id << ": " << result[i].second << endl;
	}
    }
  cout << costoTotal << endl;
  //print_f();
}
