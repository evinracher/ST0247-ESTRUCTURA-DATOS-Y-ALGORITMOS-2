#include <vector>
#include <iostream>
#include <algorithm> //reverse
#include <queue>

//Para la pareja,  first  = distancia, second = sucesor

const int MAXN = 100005;
const int INF = 1 << 30;

using namespace std;

typedef pair <int,int> dist_node;
typedef pair <int, int> edge;
vector <edge> g[MAXN]; //Arreglo de vectores
int d[MAXN];//Distancias
int p[MAXN];//Predecesor

void Dijkstra(int s, int n){
  for(int i = 0; i <= n; ++i){
    d[i] = INF;
    p[i] = -1;    
  }

  priority_queue < dist_node, vector<dist_node>, greater<dist_node> > q;
  d[s] = 0;
  q.push(dist_node(0, s));
  while(!q.empty()){
    int dist = q.top().first;
    int cur = q.top().second;
    q.pop();
    if (dist < d[cur]) continue;
    for(int i = 0; i < g[cur].size(); ++i){
      int next = g[cur][i].second;//Creo que es second
      int w_extra = g[cur][i].first;
      if(d[cur] + w_extra < d[next]){
	d[next] = d[cur]+w_extra;
	p[next] = cur;
	q.push(dist_node(d[next], next));
      }
    }

  }
  
}
//Para sacar el camino desde el inicio (s) a t;
vector <int> find_path (int t){
  vector<int> path;
  int cur = t;
  while(cur != -1){
    path.push_back(cur);
    cur = p[cur];
  }

  reverse(path.begin(), path.end());
  return path;
}

int main(){

  g[0][0] = make_pair(20, 1);
  g[0][1] = make_pair(80, 3);
  g[0][2] = make_pair(90, 6);
  g[1][0] = make_pair(10, 5);
  g[5][0] = make_pair(10, 2);
  g[5][1] = make_pair(40, 3);
  g[2][0] = make_pair(50, 5);
  g[2][1] = make_pair(20, 7);
  g[2][2] = make_pair(10, 3);
  g[3][0] = make_pair(20, 6);
  g[6][0] = make_pair(20, 0);
  g[4][0] = make_pair(30, 6);
  g[4][1] = make_pair(50, 1);
  Dijkstra(0, 7);
  vector<int> cami = find_path(6);
  for(int i = 0; i < cami.size();++i){
    cout << cami[i] << " - "; 
  }
  return 0;
}
