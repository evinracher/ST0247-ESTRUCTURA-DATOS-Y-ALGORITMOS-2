#include <math.h>
#include <stdio.h>
#include <vector>
#include <utility>
#include <iostream>
#define min(a,b) a>b?b:a
//#define sizePOW 1024 // 2^10
#define INT_MAX  10000 // I guest this like max
using namespace std;
/**
   Tsp de*: https://stackoverflow.com/questions/25681432/using-bitmasking-in-dynamic-programming
   *se hizo modificaciones y se puede correr con ./karo < test.txt
   En el taller hay un error, es 22 y no 24 el resultado
   **/

#define D(x) cout << "DEBUG: "<< #x<< " = " << x << endl


//int n,npow,g[size][sizePOW],p[size][sizePOW],adj[size][size];
int n,npow;
vector<vector <int> > g;
vector<vector <int> > p;
vector<vector <int> > adj;
int getWeight(pair<int, int> node, pair<int, int> node1){
  int x = node.first;
  int y = node.second;
  int x1 = node1.first;
  int y1 = node1.second;
  int r = x-x1+y-y1;
  if (r < 0){
    r = r*(-1);
  }
  return r;
}

int compute(int start,int set)
{
  int masked,mask,result=INT_MAX,temp,i;

  if(g[start][set]!=-1){
    return g[start][set];
  }
  for(i=0;i<n;i++)
    {
      mask=(npow-1)-(1<<i);
      masked=set&mask;
      if(masked!=set)
        {
	  temp=adj[start][i]+compute(i,masked);
	  if(temp<result)
	    result=temp,p[start][set]=i;
        }
    }
  return g[start][set]=result;
}

void getpath(int start,int set)
{
  if(p[start][set]==-1) return;
  int x=p[start][set];
  int mask=(npow-1)-(1<<x);
  int masked=set&mask;
  printf("%d ",x);
  getpath(x,masked);
}
void TSP()
{
  D(adj.size());
  int i,j;
  //g(i,S) is length of shortest path starting at i visiting all vertices in S and ending at 1
  for(i=0;i<n;i++)
    for(j=0;j<npow;j++)
      g[i][j]=p[i][j]=-1;
  for(i=0;i<n;i++)
    g[i][0]=adj[i][0];
  int result=compute(0,npow-2);
  printf("Tour cost:%d\n",result);
  //getpath(0,npow-2);
}


void print(){
  cout << "  ";
  for (int i = 0; i < adj.size(); ++i)
    {
      cout << i;
      cout << " ";
    }
  cout << endl;
  for(int i = 0; i < adj.size(); ++i)
	{
	  cout << i << " ";
	  for(int j = 0; j < adj[i].size(); ++j)
		{
		  cout << adj[i][j] << " ";
		}
	  cout << endl;
	}
}

int main(void) {
  int con= 0;
  int ncases;
  scanf("%d", &ncases);
  D(ncases);
  while(con < ncases){
    int tx,ty;
    scanf("%d %d", &tx,&ty);
    D(tx);
    D(ty);
    int x,y;
    scanf("%d %d", &x, &y);
    scanf("%d", &n);
    D(x);
    D(y);
    vector< vector <int> > a (n+1);
    npow=(int)pow(2,n+1);
    vector< vector <int> > gs (n+1);
    for(int i = 0; i < a.size(); ++i){
      vector<int> p (n+1);
      a[i] = p;
      vector<int> w (npow);
      gs[i] = w;
    }
    adj = a;
    g = gs;
    p = gs;

    D(adj.size());
    D(p.size());
    D(g.size());
    vector<pair <int, int> > nodes;
    nodes.push_back(make_pair(x,y));
    for(int i = 0; i < n;++i){
      cin >> x;
      cin >> y;
      nodes.push_back(make_pair(x,y));
    }
    
    for(int i = 0; i < n+1; ++i){
      pair<int, int> node = nodes[i];
      for(int j = 0; j < n+1; ++j){
	pair<int, int> node1 = nodes[j];
	int peso = getWeight(node, node1);
	adj[i][j] = peso;
      }
    }
    //bit number required to represent all possible sets
    n= n+1;
    print();
    TSP();
    con++;
  }

  return 0;

}
