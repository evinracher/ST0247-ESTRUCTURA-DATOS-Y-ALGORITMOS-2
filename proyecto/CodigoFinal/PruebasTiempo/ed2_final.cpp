#include <bits/stdc++.h>
#include <stdio.h>
#include <sys/time.h>
/**
   Compile with C++11
   Trabajo en conjunto con Agustin Nieto (input)
**/
using namespace std;
enum nodetype
  {
    customer = 'c', station = 's', deposit = 'd'
  };

struct node
{
  int id;
  string name;
  float x, y;
  char type;
  int station_type;
  int region;
  int dregion; 
  float cing;
};

vector<vector<float> > geses;
vector<vector<float> > leses;

/**
   n = # of nodes
   m = # of customers
   u = # of charging stations
**/
vector<pair<vector<pair<node, float> >, float> > result;
int MAX = 1000000;
int n, m, u, breaks;
float r, speed, Tmax, Smax;
float st_customer, Q;
int l, g;
float costoTotal;

float calc_charge(int type)
{
  return geses[type][geses[type].size()-1]/leses[type][leses[type].size()-1];
}


float charging(float m, float time)
{
  return m*time;
}

float h_t(float m, float bt)
{
  return bt/m;
}

float h_km(float level_b)
{
  return level_b/r;
}

float h_b(float km)
{
  return km*r;
}
vector<node> nodes;
vector<node> csts;
map<int, node> est_charge;
map<int, vector<node> > rs;
map<int, vector<vector<float> > > graphs;

float dist(node n1, node n2);
void print_node(node &p);
//int gettimeofday (struct timeval *tp, NULL);

node deposito;

void readInput()
{

  
  scanf(" n = %d", &n);
    
  scanf(" m = %d", &m);
    
  scanf(" u = %d", &u);
    
  scanf(" breaks = %d", &breaks);


    
  scanf(" r = %f", &r);
    
  scanf(" speed = %f", &speed);
    
  scanf(" Tmax = %f", &Tmax);
    
  scanf(" Smax = %f", &Smax);
    
    
  scanf(" st_customer = %f", &st_customer);


    
  scanf(" Q = %f", &Q);
    
    
  scanf(" Coordinates");

  nodes.resize(n);
  for(int i=0; i<n; ++i)
    {
      cin >> nodes[i].id;
      cin >> nodes[i].name;
      cin >> nodes[i].x;
      cin >> nodes[i].y;
      cin >> nodes[i].type;
      cin >> nodes[i].station_type;
      nodes[i].region = -1;
      nodes[i].dregion = -1;

      if(nodes[i].type == 's')
        {
	  csts.push_back(nodes[i]);
        }
      else
        {
	  nodes[i].cing = 0;
        }
    }
  scanf(" l");
  leses.resize(3);
  for(int i=0; i<3; ++i)
    {
      leses[i].resize(breaks);
      for(int j=0; j<breaks; ++j)
        {
	  scanf(" %f", &leses[i][j]);
        }
    }

  scanf(" g");
  geses.resize(3);
  for(int i=0; i<3; ++i)
    {
      geses[i].resize(breaks);
      for(int j=0; j<breaks; ++j)
        {
	  scanf(" %f", &geses[i][j]);
        }
    }

  for(int i = 0; i < csts.size(); ++i)
    {
      csts[i].cing = calc_charge(csts[i].station_type);
      est_charge[csts[i].id] = csts[i];
    }
}


void c_regions()
{
  for(int i = 0; i < nodes.size(); i++)
    {
      if(nodes[i].type == 's')
        {
	  continue;
        }
      if(nodes[i].type == 'd')
        {
	  continue;
        }
      int mindist = dist(nodes[i],csts[0]);
      int idmin = csts[0].id;
      for(int j = 1; j < csts.size(); ++j)
        {
	  float dtemp = dist(nodes[i], csts[j]);
	  if(dtemp < mindist)
            {
	      mindist = dtemp;
	      idmin = csts[j].id;
            }
        }
      nodes[i].region = idmin;
      nodes[i].dregion = mindist;
      rs[idmin].push_back(nodes[i]);
    }

  for(int i = 0; i < csts.size(); ++i)
    {
      rs[csts[i].id].push_back(csts[i]);
    }
}


float dist(node n1, node n2)
{
  float x = n2.x-n1.x;
  float y = n2.y-n1.y;
  float c = pow(x,2)+pow(y,2);
  float r = pow(c,0.5);
  return r;
}


vector<vector<float> > grafo(vector<node > rgs)
{
  vector< vector <float> > graph_a (rgs.size());
  for(int i = 0; i < graph_a.size(); ++i)
    {
      graph_a[i].resize(rgs.size());
    }
  for(int i = 0; i < rgs.size(); i++)
    {
      for(int j = 0; j < rgs.size(); j++)
        {
	  if(i != j)
            {
	      float distancia = dist(rgs[i], rgs[j]);
	      graph_a[i][j]= distancia;
            }
        }
    }
  return graph_a;
}


void vgraph()
{
  for(map<int, vector<node> >::iterator it = rs.begin(); it != rs.end(); ++it)
    {
      vector<node > r = it->second;
      int identifier = it->first;
      graphs[identifier] = grafo(r);
    }
}
bool can_return(vector<pair<node, float> > camino, float c_b)
{
  float d_return = dist(nodes[0], camino[camino.size()-1].first);
  float last_battery = h_b(d_return);
  if(c_b-last_battery <= 0)
    {
      return false;
    }
  return true;
}

float return_time(vector<pair<node, float> > camino, float c_b, vector<node> re)
{
  float d_return = dist(nodes[0], camino[camino.size()-1].first);
  if(!can_return(camino, c_b))
    {
      float d_charge = dist(camino[camino.size()-1].first, re[re.size()-1]);
      d_return = dist(nodes[0], re[re.size()-1]);
      float charge_time = h_t(re[re.size()-1].cing,h_b(d_return));
      return ((d_charge+d_return)/speed)+charge_time;
    }
  else
    {
      return d_return/speed;
    }
}

void ending(vector<pair<node, float> > camino, float costo, vector<node> re, float c_b)
{
  if(!can_return(camino, c_b))
    {
      // cout << "charging before return"<<endl;
      float d_charge = dist(camino[camino.size()-1].first, re[re.size()-1]);
      camino.push_back(make_pair(re[re.size()-1], (d_charge/speed)));
      float d_deposit = dist(nodes[0], re[re.size()-1]);
      float b_need = h_b(d_deposit);
      float c_time=h_t(re[re.size()-1].cing,b_need);
      costo+=(d_charge+d_deposit)/speed+c_time;
      camino.push_back(make_pair(nodes[0], (d_deposit/speed)));
    }
  else
    {
      float d_return = dist(nodes[0], camino[camino.size()-1].first);
      costo+= d_return/speed;
      camino.push_back(make_pair(nodes[0], (d_return/speed)));
    }
  costoTotal+=costo;
  //cout << "Costo Local: " << costo << endl;
  result.push_back(make_pair(camino,costo));
}

float initial_node(vector<node> re, node charger, vector<bool> visited, float *costoLocal, float *distance, float *c_b)
{
  (*distance) = dist(nodes[0], re[0]);
  int min = 0;
  for(int i = 1; i < re.size(); i++)
    {
      if((*distance) > dist(nodes[0], re[i]))
        {
	  (*distance) = dist(nodes[0], re[i]);
	  min = i;
        }
    }

  float if_char =0;
  if((*distance) >= dist(nodes[0], charger))
    {
      (*distance) = dist(nodes[0], charger);
      min = re.size()-1;
      //cout << "Starting charging station "<< charger.id << endl;
    
    
      if_char = h_b((*distance));
    
    
    
      (*costoLocal) += h_t(charger.cing, if_char);
    }
  (*c_b)=(*c_b)-h_b((*distance))+if_char;
  return min;
}
void tspAux(int grafoA)
{   
  float c_b = Q;
    
  vector<vector<float> > grafoActual = graphs[grafoA];
    
  vector<pair<node, float> > camino;
  camino.push_back(make_pair(nodes[0], 0));
  vector<node> re = rs[grafoA];

  if(re.size() <=1)
    {
      //cout << "Obsolete route: Region Only with charging station" << endl;
      result.push_back(make_pair(camino, 0));
      return;
    }

  node charger = re[re.size()-1];

  vector<bool> visited;
  visited.assign(re.size(), false);
  float costoLocal = 0;
  float costoNode = 0;
  float distance;
  int min = initial_node(re, charger, visited, &costoLocal, &distance, &c_b);
  costoLocal = distance/speed;
  costoNode = costoLocal;
    
    
  //cout << "starting"<<endl;
    
  int pos = min;
  if(grafoActual.size() > 0)
    {
      for(int g = 0; g < grafoActual.size()-1; g++)
        {           
	  if((costoLocal+return_time(camino,c_b,re)) >= Tmax-1.5)
            {
	      ending(camino, costoLocal,re, c_b);
	      camino.clear();
	      camino.push_back(make_pair(nodes[0],0));
	      c_b = Q;
	      costoLocal = 0;
	      pos = initial_node(re,charger,visited, &costoLocal,&distance,&c_b);
	      costoLocal+= distance/speed;
	      costoNode = distance/speed;
            }
	  if(re[pos].type == 'c'){
	    costoLocal+=st_customer;
	  }
	  camino.push_back(make_pair(re[pos], costoNode));
           
	  if(pos != re.size()-1)
            {
	      visited[pos] = true;
            }
	  float minus = MAX;
	  int nuevoPos = pos;
	  for(int i = 0; i < grafoActual.size()-1; i++)
            {
	      if(minus > grafoActual[pos][i] && visited[i] == false)
                {
		  minus = grafoActual[pos][i];
		  nuevoPos = i;
                }
            }

	  if(minus != MAX)
            {
	      if(c_b-h_b(minus) < h_b(dist(re[nuevoPos], charger)))
                {
		  float d_charge = dist(re[pos],charger);
		  costoLocal+=d_charge/speed;
		  //cout << "charging" << endl;
		  c_b-=h_b(d_charge);
		  costoLocal+=h_t(charger.cing,Q-c_b);
		  costoNode = d_charge/speed;
		  c_b = Q;
		  pos = re.size()-1;
                }
	      else
                {
		  pos = nuevoPos;
		  costoLocal+= (minus / speed);
		  costoNode = minus/speed;
		  c_b -= h_b(minus);
                }

            }

        }
    }
  ending(camino, costoLocal,re, c_b);
}

int main(void)
{
  struct timeval ti, tf;
  double tiempo;
  gettimeofday(&ti, NULL);   // Instante inicial

  /*gettimeofday(&tf, NULL);   // Instante final
  tiempo= (tf.tv_sec - ti.tv_sec)*1000 + (tf.tv_usec - ti.tv_usec)/1000.0;
  printf("Has tardado: %g milisegundos\n", tiempo);*/



  //tomar tiempo lectura y creacion de vectores
  //gettimeofday(&ti, NULL);  
  readInput();
  //gettimeofday(&tf, NULL);
  //tiempo= (tf.tv_sec - ti.tv_sec)*1000 + (tf.tv_usec - ti.tv_usec)/1000.0;
  //printf("tiempo de lectura: %g milisegundos\n", tiempo);

  
  //tiempo en divisio  de regiones
  //gettimeofday(&ti, NULL);  
  c_regions();
  //gettimeofday(&tf, NULL);   // Instante final
  //tiempo= (tf.tv_sec - ti.tv_sec)*1000 + (tf.tv_usec - ti.tv_usec)/1000.0;
  //printf("division: %g milisegundos\n", tiempo);

  //tiempo en creacion de grafos
  //gettimeofday(&ti, NULL);  
  vgraph();
  gettimeofday(&tf, NULL);
  tiempo= (tf.tv_sec - ti.tv_sec)*1000 + (tf.tv_usec - ti.tv_usec)/1000.0;
  printf("creacion de grafos: %g milisegundos\n", tiempo);



  //tiempo de recorrido de cada region
  gettimeofday(&ti, NULL);
  for(map<int, vector<vector<float> > >::iterator it = graphs.begin(); it != graphs.end(); it++)
    {
      int identifier = it->first;
      tspAux(identifier);
    }
  gettimeofday(&tf, NULL);
  tiempo= (tf.tv_sec - ti.tv_sec)*1000 + (tf.tv_usec - ti.tv_usec)/1000.0;
  printf("recorrido de cada region: %g milisegundos\n", tiempo);


  //imprimir resultados
  //gettimeofday(&ti, NULL);
  for(int j = 0; j < result.size(); ++j)
    {
      //cout << "Ruta " << j+1 << ": " << endl;
      for(int i  = 0; i < result[j].first.size(); i++)
	{
	  float time = result[j].first[i].second;
	  //cout << result[j].first[i].first.id << " (" << time <<")"<< endl;
	}
      //cout << "costo Local: " << result[j].second << endl << endl;
    }
  //cout << endl << "Costo Total: "<< costoTotal << endl;
  //gettimeofday(&tf, NULL);
  //tiempo= (tf.tv_sec - ti.tv_sec)*1000 + (tf.tv_usec - ti.tv_usec)/1000.0;
  //printf("tiempo TSP: %g milisegundos\n", tiempo);
}
