#pragma once
#include <cstdio>
#include <vector>
#include <set>
#include <cstring>
#include <iostream>
#include <cstdlib>

using namespace std;
class GraphI{
  static const int N = 100;
  static const int inf = 100000000;
  vector<vector<pair<int, int> > > adjList;
  bool was[N];
  int d[N];

 public:
  GraphI();
  void addSimpleEdge(int a, int b);
  void addWeightedEdge(int a, int b ,int w);
  int getSize();
  vector<pair<int, int> > getSuccesors(int a);
  void printSuccesors(int a);
  void dfs(int v);
};
