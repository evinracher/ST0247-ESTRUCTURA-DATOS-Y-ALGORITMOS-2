#include <iostream>

using namespace std;

void routes(int n, int d, int r){
  for (int x = 0; x < 2; ++x)
    {
      for(int i = 0; i < n; ++i)
	{
	  int hr;
	  cin >> hr;
	  cout << hr;
	  cout << " ";
	}
      cout << endl;
    }
}


int main(){
  int n,d,r;
  cin >> n;
  cin >> d;
  cin >> r;
  cout << n << " "<< d << " " << r << endl;
  while(n != 0 and d != 0 and r != 0)
    {
      routes(n,d,r);
      cin >> n;
      cin >> d;
      cin >> r;
      cout << n << " "<< d << " " << r << endl;
    }
}
