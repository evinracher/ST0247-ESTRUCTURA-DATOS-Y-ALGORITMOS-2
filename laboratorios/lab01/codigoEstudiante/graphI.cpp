#include <cstdio>
#include <vector>
#include <set>
#include <cstring>
#include <iostream>
#include <cstdlib>
#include "graphI.h"

using namespace std;

GraphI::GraphI(){
}

void GraphI:: addSimpleEdge(int a, int b){
  pair<int, int> p (a,-1);
  adjList[a].push_back(p);
}
void GraphI::addWeightedEdge(int a, int b, int w){
  pair<int, int> p (b,w);
  adjList[a].push_back(p);
}

int GraphI::getSize(){
  //I supose that this size is wrong but i dont care; may be the size of a graph refers to the grade
  return adjList.size();
}

vector<pair<int,int> > GraphI::getSuccesors(int a){
  return adjList[a];
}

void GraphI::printSuccesors(int a){
  for(int i = 0; i < adjList[a].size(); ++i){
    cout << " Va a: " << adjList[a][i].first << "; con peso: "<< adjList[a][i].second << endl;
  }
}
  
void GraphI::dfs(int v){
  was[v] = false;
  printf("Los vertices encontrados al hacer DFS de %d son: ", v);
  for(size_t i = 0; i < adjList[v].size(); ++i){
    int to = adjList[v][i].first;
    if(!was[to]){
      printf(" ,%d", to);
      dfs(to);
    }
  }
}
/**
void dijkstra(int source){
  memset(d, inf, sizeof d);
  d[source] = 0;
  int u;
  set<pair<int, int> > s;
  s.insert(make_pair(d[source], source));
  while(!s.empty()){
    u = s.begin()->second;
    s.erase(s.begin());
    for(auto p: adjList[u]){
      if(d[p.first] > d[u] + p.second){
        s.erase(make_pair(d[p.first], p.first));
        d[p.first] = d[u] + p.second;
        s.insert(make_pair(d[p.first], p.first));
      }
    }    
  }
}
int main(int argc, char **args){
  int vertices, edges;
  scanf("%d %d", &vertices, &edges);
  adjList.resize(vertices);
  for(int i = 0; i < edges; ++i){
    int a, b, w;
    scanf("%d %d %d", &a, &b, &w);
    addWeightedEdge(a, b, w);
  }
  //  dijkstra(1);
  }**/
