#include <iostream>
#include <vector>

#define inf 100
#define Digraph vector<vector<pair <int, int> > >
#define suc vector<pair <int, int> >
using namespace std;

Digraph adList(4);

int getWeigth(int pD, int i)
{
    return adList[pD][i].second;
}

suc getSuccessors(Digraph *g, int pD)
{
    return (*g)[pD];
}

void nearAux(int start, int pD, vector<bool> *pb, int *suma, Digraph *g)
{
    suc successors = getSuccessors(g,pD);
    int mW = inf;
    int pW = -1;
    int aux;
    for(int i = 0; i < successors.size(); ++i)
    {
        int p = getWeigth(pD,i);
        if(p < mW)
        {
            if(!(*pb)[adList[pD][i].first])
            {
                mW = p;
                pW = adList[pD][i].first;
            }
            else
            {
                if(adList[pD][i].first== start)
                {
                    aux = adList[pD][i].first;
                }
            }
        }
    }

    if(pW == -1)
    {
        *suma += adList[pD][aux].second;
    }
    else
    {
        *suma = *suma + mW;
        (*pb)[pW] = true;
        nearAux(start,pW, pb, suma, g);
    }
}
void visitados(vector<bool> *r)
{
    for(int i = 0; i < r->size(); ++i)
    {
        cout << (*r)[i] << endl;
    }
}

int near()
{
    vector<bool> r(adList.size(),false);
    vector<bool> *p = &r;
    Digraph *g = &adList;
    int pD = 0;
    int sum = 0;
    int *suma = &sum;
    (*p)[0] = true;
    nearAux(0,0, p, suma, g);
    return sum;
}


int main()
{
    adList[0].push_back(make_pair(3,6));
    adList[0].push_back(make_pair(1,7));
    adList[0].push_back(make_pair(2,15));
    adList[1].push_back(make_pair(0,2));
    adList[1].push_back(make_pair(2,7));
    adList[1].push_back(make_pair(3,3));
    adList[2].push_back(make_pair(0,9));
    adList[2].push_back(make_pair(1,6));
    adList[2].push_back(make_pair(3,12));
    adList[3].push_back(make_pair(0,10));
    adList[3].push_back(make_pair(1,4));
    adList[3].push_back(make_pair(2,8));

    //Imprimiendo grafo
    cout << adList.size() <<endl;
    for(int x = 0; x < adList.size(); ++x)
    {
        cout << x << ": ";
        for(int j = 0; j < adList[x].size(); ++j)
        {
            cout << "["<< adList[x][j].first << "," << adList[x][j].second << "] ";
        }
        cout << endl;
    }
    cout << near() << endl;

    return 0;
}
