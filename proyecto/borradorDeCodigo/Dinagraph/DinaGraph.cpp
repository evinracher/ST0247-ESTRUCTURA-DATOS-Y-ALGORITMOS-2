#include "DinaGraph.h"
#include <iostream>
#include <string>
#include "Vertex.h"
#include <vector>

using namespace std;

DinaGraph::DinaGraph(int tam)
{
    size = tam;
    cEdges = 0;
}

void DinaGraph::addVertex(int i, double x, double y, string name)
{
    Vertex vertex (x,y,i,name);
    vertexes[i] = vertex;
}

void DinaGraph::addVertex(int i, double x, double y)
{
    Vertex vertex (x,y,i);
    vertexes[i] = vertex;
}

void DinaGraph::addEdge(int i, int j)
{
    cout << "El vertice existe: "<< vertexes[j].getName() << endl;
    Edge d(vertexes[j], -1);
    cEdges++;
    adList[i].push_back(d);
}

void DinaGraph::addEdge(int i, int j, double dis, string name)
{
    cout << "El vertice existe: "<< vertexes[j].getName() << endl;
    Edge d(vertexes[j], dis, name);
    cEdges++;
    adList[i].push_back(d);
    cout << "Exito al agregar"<<endl;
}

Edge DinaGraph::getEdge(int i, int j)
{
    return adList[i][j];
}

int DinaGraph::getSize()
{
    return vertexes.size();
}

int DinaGraph::getLength()
{
    return cEdges;
}

vector< Edge> DinaGraph::getSuccessors(int i){
    return adList[i];
}
void DinaGraph::printSs(int i)
{
    for(int j = 0; j < adList[i].size(); ++j)
    {
        cout << adList[i][j].getDesId() << endl;
    }
}
