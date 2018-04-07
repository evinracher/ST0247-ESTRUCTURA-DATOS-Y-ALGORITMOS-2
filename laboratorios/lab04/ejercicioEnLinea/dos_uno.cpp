#include <iostream>
#include <vector>
#include <queue>

using namespace std;

//Util proces to print a vector
ostream& operator<<(ostream& os, vector<int> const& arr){
  for(int i=0;i<arr.size();++i)
    os << arr[i] << " ";
  os << endl;
  return os;
}


int routes(int n, int d, int r){
  vector<vector <int> > routes (2);
  for (int x = 0; x < 2; ++x)
    {
      for(int i = 0; i < n; ++i)
	{
	  int hr;
	  cin >> hr;
	  routes[x].push_back(hr);
	}
      cout << routes[x];
    }

  //Algorithm
  int acum = 0;
  vector<bool> nT (n, false);
  for(int x = 0; x < n; ++x)
    {
      int m = routes[0][x];
      int sum = 0;

      //pair <difference, i>
      priority_queue<pair <int,int> > pos;
      priority_queue<pair <int,int> > neg;
      bool zero = false;
      for (int i = 0; i < n; ++i)
	{
	  if(!nT[i]){
	    int t = routes[1][i];
	    sum = m+t;
	    int g = sum-d;
	    if(g == 0){
	      nT[i] = true;
	      zero = true;
	      break;
	    }
	    if(g < 0){
	      neg.push(make_pair(g*-1,i));
	    }else if(g > 0){
	      pos.push(make_pair(g,i));
	    }
	  }
	}
      if(!zero){
	if(!neg.empty()){
	  nT[neg.top().second] = true;
	}else{
	  acum += pos.top().first;
	  nT[pos.top().second] = true;
	}
      }
    }
  return acum*r;
}

int main(){
  int n,d,r;
  cin >> n;
  cin >> d;
  cin >> r;
  cout << n << " "<< d << " " << r << endl;
  while(n != 0 and d != 0 and r != 0)
    {
      cout << routes(n,d,r) << endl;
      cin >> n;
      cin >> d;
      cin >> r;
      cout << n << " "<< d << " " << r << endl;
    }
}
