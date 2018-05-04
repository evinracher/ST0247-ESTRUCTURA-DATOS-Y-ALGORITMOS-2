#include <vector>
#include <iostream>
#include <cmath>

using namespace std;

#define D(x) cout << " DEBUG: " << #x << " = " << x <<endl

vector<int> tablero;

void print(vector <int> tablero)
{
    for(int j = 0; j < tablero.size(); j++)
    {
        for(int i = 0; i < tablero.size(); i++)
        {
            if(tablero[i] == j)
            {
                cout << j;
                cout << "#";
            }
            else
            {
                cout << " ";
            }
            cout << " ";
        }
        cout << endl;
    }
}

int c_inv(vector<int> tablero)
{
    int con = 0;
    for(int i = 0; i < tablero.size(); ++i)
    {
        for(int j = i + 1; j < tablero.size(); ++j)
        {
            if(tablero[i] == tablero[j] || abs(tablero[j]-tablero[i]) == abs(j-i))
            {
                con++;
            }
        }
    }
    print(tablero);
    return con;
}

int aux_queens(int i)
{
    vector <int> tab = tablero;
    tab[i] = 0;
    int ca = c_inv(tab);
    D(ca);
    for(int j = 1; j < tab.size(); ++j)
    {
        tab[i] = j;
        int other_a = c_inv(tab);
        D(other_a);
        if(other_a < ca)
        {
            ca = other_a;
        }
        else
        {
            tablero = tab;
            break;
        }
    }
    return ca;
}


void l_search(int n)
{
    tablero.resize(n);

    for(int i = 0; i < tablero.size(); i++)
    {
        tablero[i] = 0;
    }
    vector<int> tabr = tablero;
    int c = aux_queens(0);
    for(int i = 1; i < tablero.size(); ++i)
    {
        int other = aux_queens(i);
        D(other);
        if (other < c)
        {
            c = other;
            D(c);
        }
        else
        {
            tabr = tablero;
            break;
        }
    }
    cout << "Soluction"<<endl;
    print(tabr);
}

int main()
{
    cout << "4-queens" <<endl;
    l_search(4);

    return 0;
}
