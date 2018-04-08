#include <iostream>
#include <cstdio>
#include <vector>
#include <string>


#define D(x) cout << "DEBUG: " << #x " = "<< x << endl

using namespace std;
//coordinates x,y
vector<pair<int, int> > points;
vector<vector<string> > cplane;

//obsolete
void initPoints(){
  for(int i = 0; i <= 5; ++i){
    points.push_back(make_pair(-1,-1));
  }
}

void printPoints(){
  for(int i = 0; i < points.size();++i){
    int a = points[i].first;
    int b = points[i].second;
    cout << "("<<a << ","<< b << ")" << endl;
  }
}

void cResize(){
  cplane.resize(points.size()-1);
  for(int i = 0; i < cplane.size();++i){
    cplane[i].resize(points.size()-1);
  }
}
void cPlane(){
  cResize();
  for(int i = 0; i < points.size();++i){
    int a = points[i].first;
    int b = points[i].second;
    cplane[a][b] = "#";
  }
}

//Print points in Cartesian Plane
void printCP(){
  for(int y = cplane.size()-1; y >= 0;--y){
    cout << y << "|";
    for(int x = 0; x < cplane[0].size();++x){
      string p = cplane[x][y];
      if(p != ""){
	cout << p;
      }else{
	cout << " ";
      }
    }
    cout << endl;
  }
  cout << "  ";
  for(int x = 0; x < cplane.size(); ++x){
    cout << x;
  }
  cout << endl;
}

int main(){
  int x,y;
  scanf("%i",&x);
  scanf("%i",&y);
  while(x != 0 and y != 0){
    points.push_back(make_pair(x,y));
    scanf("%i",&x);
    scanf("%i",&y);
  }
  printPoints();
  cPlane();
  printCP();
  return 0;
}
