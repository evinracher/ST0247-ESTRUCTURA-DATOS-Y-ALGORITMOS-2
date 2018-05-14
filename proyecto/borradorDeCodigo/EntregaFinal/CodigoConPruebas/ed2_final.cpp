#include <bits/stdc++.h>

/**
   Compile with C++11
   Trabajo en conjunto con Agustin Nieto (input)
**/
using namespace std;
#define D(x) cout << "DEBUG " << #x "=" << x << endl

#define M(x) cout << x << endl
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

//Charging function
float charging(float m, float time)
{
    return m*time;
}
//How much time i need to charge bt?
float h_t(float m, float bt)
{
    return bt/m;
}

//How much kilometers can i drive?
float h_km(float level_b)
{
    return level_b/r;
}

//How much battery i need to drive km?
float h_b(float km)
{
    return km*r;
}



//Saving all nodes
vector<node> nodes;

// Saving charging stations
vector<node> csts;

//For avoid change code xD. To save charging stations
map<int, node> est_charge;

//regiones
map<int, vector<node> > rs;

//Vector de grafos (con todas las regiones)
map<int, vector<vector<float> > > graphs;

float dist(node n1, node n2);
void print_node(node &p);

node deposito;

void readInput()
{
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
    //About the stations
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

void print_node(node &node)
{
    cout << node.id << " "
         << node.name << " "
         << node.x << " "
         << node.y << " "
         << node.type << " "
         << node.station_type << " "
         << endl;
}

//Print charging stations
void print_csts()
{
    for(int i = 0; i < csts.size(); ++i)
    {
        print_node(csts[i]);
    }
}

//Calculate distance between two nodes
float dist(node n1, node n2)
{
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

void print_vector(vector<node> nos)
{
    for(int i = 0; i < nos.size(); ++i)
    {
        print_node(nos[i]);
    }
}

//Generating finals graphs
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
    //If in last node i cant go with actual battery level
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
        //in this part, I am going to calculate min time to return really
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
        cout << "charging before return"<<endl;
        //Go to charging
        float d_charge = dist(camino[camino.size()-1].first, re[re.size()-1]);
        camino.push_back(make_pair(re[re.size()-1], costo));
        //How battery i need to go to deposit
        float d_deposit = dist(nodes[0], re[re.size()-1]);
        float b_need = h_b(d_deposit);
        //Adding charging time
        float c_time=h_t(re[re.size()-1].cing,b_need);
        //Adding time to go to deposit
        costo+=(d_charge+d_deposit)/speed+c_time;
        camino.push_back(make_pair(nodes[0], costo));
    }
    else
    {
        //I dont need minus battery coz i am going to deposit
        float d_return = dist(nodes[0], camino[camino.size()-1].first);
        costo+= d_return/speed;
        camino.push_back(make_pair(nodes[0], costo));
    }
    //Adding customer time
    //in the path will be one charging station
    // NOOOOO: costo+=st_customer*(re.size()-1);
    costoTotal+=costo;
    cout << "Costo Local: " << costo << endl;
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
    //Is charging stations is more near that any other node in its region
    if((*distance) >= dist(nodes[0], charger))
    {
        (*distance) = dist(nodes[0], charger);
        min = re.size()-1;
        cout << "Starting charging station "<< charger.id << endl;
        D(charger.type);
        //Charging full battery if I am in a charging station in the begin
        if_char = h_b((*distance));
        D(if_char);
        D("Start in charging station");
        //Adding charging time
        (*costoLocal) += h_t(charger.cing, if_char);
    }
    (*c_b)=(*c_b)-h_b((*distance))+if_char;
    return min;
}
void tspAux(int grafoA)
{
    cout << endl;
    //All routes start with full battery
    float c_b = Q;
    //Region graph
    vector<vector<float> > grafoActual = graphs[grafoA];
    //Vector for
    vector<pair<node, float> > camino;
    camino.push_back(make_pair(nodes[0], 0));
    vector<node> re = rs[grafoA];

    if(re.size() <=1)
    {
        cout << "Obsolete route: Region Only with charging station" << endl;
        result.push_back(make_pair(camino, 0));//Only for debuging in example.txt
        return;
    }

    node charger = re[re.size()-1];

    vector<bool> visited;
    visited.assign(re.size(), false);
    float costoLocal = 0;
    float distance;
    int min = initial_node(re, charger, visited, &costoLocal, &distance, &c_b);
    costoLocal = distance/speed;

    //Actually algoritm starts here
    D(re[min].id);
    cout << "starting"<<endl;
    D(charger.id);
    int pos = min;
    if(grafoActual.size() > 0)
    {
        //Last position is charging station
        for(int g = 0; g < grafoActual.size()-1; g++)
        {
	  
            D(Tmax);
            D(costoLocal+return_time(camino,c_b,re));
            //0.5 Tiempo de gracia
            if((costoLocal+return_time(camino,c_b,re)) >= Tmax-1.0)
            {
                ending(camino, costoLocal,re, c_b);
                camino.clear();
                camino.push_back(make_pair(nodes[0],0));
                c_b = Q;
                costoLocal = 0;
                pos = initial_node(re,charger,visited, &costoLocal,&distance,&c_b);
                costoLocal+= distance/speed;
            }
            if(re[pos].type == 'c'){
                costoLocal+=st_customer;
            }
            camino.push_back(make_pair(re[pos], costoLocal));
            //Don't mark charging station
            if(pos != re.size()-1)
            {
                visited[pos] = true;
            }
            float minus = MAX;
            int nuevoPos = pos;




            //Last position is charging station
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
                    //recharging
                    float d_charge = dist(re[pos],charger);
                    costoLocal+=d_charge/speed;
                    //We guest: No hay nodos tan lejos que no se pueda llegar a una estacion de carga desde ellos
                    cout << "charging" << endl;
                    c_b-=h_b(d_charge);
                    costoLocal+=h_t(charger.cing,Q-c_b);
                    //We charge battery
                    c_b = Q;
                    pos = re.size()-1;
                }
                else
                {
                    pos = nuevoPos;
                    costoLocal+= (minus / speed);
                    c_b -= h_b(minus);
                }

            }

        }
    }
    ending(camino, costoLocal,re, c_b);
}

void print_g(int id)
{
    if(graphs[id].size() <= 1)
    {
        return;
    }
    cout << "[ ";
    for(int i = 0; i < graphs[id].size(); ++i)
        cout << i <<  " ";
    cout << endl;
    for(int i = 0; i < graphs[id].size(); ++i)
    {
        cout << i << " ";
        for(int j = 0; j < graphs[id][i].size(); ++j)
        {
            cout << graphs[id][i][j] << " ";
        }
        cout << endl;
    }
    cout << "]" << endl;
}

//print final graf
void print_f()
{
    for(int i = 0; i < graphs.size(); ++i)
    {
        print_g(i);
    }
}

//Print nodes
void print_ns()
{
    for(int i = 0; i < nodes.size(); ++i)
    {
        print_node(nodes[i]);
    }
}


int main()
{
    readInput();
    //Generating regions
    c_regions();
    //print_rs();
    vgraph();
    Tmax-=0.1;
    for(map<int, vector<vector<float> > >::iterator it = graphs.begin(); it != graphs.end(); it++)
    {
        int identifier = it->first;
        tspAux(identifier);
    }
    //print routes at the end
    for(int j = 0; j < result.size(); ++j)
      {
	cout << "Ruta " << j+1 << ": "<< endl;
	for(int i  = 0; i < result[j].first.size(); i++)
	  {
	    float time = result[j].first[i].second;
	    //Minutes, por si las moscas
	    //time = time/60.0;
	    cout << result[j].first[i].first.id << " (" << time <<")"<< endl;
	  }
	cout << "costo Local: " << result[j].second << endl;
      }
    cout << endl << "Costo Total: "<<costoTotal << endl;
    //print_f();
}
